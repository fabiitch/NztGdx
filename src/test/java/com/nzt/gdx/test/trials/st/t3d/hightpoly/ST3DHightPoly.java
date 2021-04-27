package com.nzt.gdx.test.trials.st.t3d.hightpoly;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.loader.G3dModelLoader;
import com.badlogic.gdx.graphics.g3d.model.Animation;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.utils.UBJsonReader;
import com.nzt.gdx.test.trials.tester.archi.screens.TestScreenWithHudDebug;
import com.nzt.gdx.test.trials.tester.selector.TestScreen;
import com.nzt.gdx.test.trials.tester.archi.main.FastTesterMain;
import com.nzt.gdx.test.trials.tester.archi.screens.SimpleTestScreen;

@TestScreen(group = "3D")
public class ST3DHightPoly extends TestScreenWithHudDebug {
	public Camera camera;

	public CameraInputController camController;
	public Model cubeModel;
	public ModelInstance cubeModelInstance;

	public ST3DHightPoly(FastTesterMain main) {
		super(main);
		camera = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera.position.set(10f, 10f, 10f);
		this.camera.lookAt(0, 0, 0);
		camera.near = 1f;
		camera.far = 300f;
		camera.update();

		cubeModel = new G3dModelLoader(new UBJsonReader()).loadModel(Gdx.files.internal("models/test/Zephyr.g3db"));
		cubeModelInstance = new ModelInstance(cubeModel);
		for (Animation anim : cubeModelInstance.animations) {
			System.out.println(anim.id);
		}
		for (Material material : cubeModelInstance.materials) {
			System.out.println(material.id);
		}
		camController = new CameraInputController(camera);
		Gdx.input.setInputProcessor(camController);
	}

	@Override
	public void renderAfterHud(float dt) {
		this.camera.update();
		camController.update();
		modelBatch.begin(camera);
		modelBatch.render(cubeModelInstance);
		modelBatch.end();
	}

	@Override
	public void clearScreen() {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
	}

	@Override
	public void doDispose() {
		cubeModel.dispose();

	}
}
