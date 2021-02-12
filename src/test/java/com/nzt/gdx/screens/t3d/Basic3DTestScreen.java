package com.nzt.gdx.screens.t3d;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.nzt.gdx.main.AbstractMain;
import com.nzt.gdx.screen.SimpleScreen;

public class Basic3DTestScreen extends SimpleScreen<AbstractMain> {
	public PerspectiveCamera cam;
	public Model model;
	public ModelInstance instance;
	public Environment environment;
	public CameraInputController camController;

	public Basic3DTestScreen(AbstractMain main) {
		super(main);
	}

	@Override
	public void doShow() {
		cam = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		cam.position.set(10f, 10f, 10f);
		cam.lookAt(0, 0, 0);
		cam.near = 1f;
		cam.far = 300f;
		cam.update();

		ModelBuilder modelBuilder = new ModelBuilder();
		model = modelBuilder.createBox(5f, 5f, 5f, new Material(ColorAttribute.createDiffuse(Color.GREEN)),
				Usage.Position | Usage.Normal);
		instance = new ModelInstance(model);

		environment = new Environment();
		environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f));
		environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -1f, -0.8f, -0.2f));

		camController = new CameraInputController(cam);
		Gdx.input.setInputProcessor(camController);
	}

	@Override
	protected void renderScreen(float dt) {
		camController.update();
		modelBatch.begin(cam);
		modelBatch.render(instance);
		modelBatch.end();
	}

	@Override
	public void doDispose() {
		model.dispose();
	}
}
