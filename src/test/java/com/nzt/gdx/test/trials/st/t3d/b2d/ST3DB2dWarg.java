package com.nzt.gdx.test.trials.st.t3d.b2d;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.loader.G3dModelLoader;
import com.badlogic.gdx.graphics.g3d.model.Animation;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.utils.UBJsonReader;
import com.nzt.gdx.test.trials.st.b2D.B2DTestConstants;
import com.nzt.gdx.test.trials.st.t3d.BaseST3D;
import com.nzt.gdx.test.trials.tester.archi.main.FastTesterMain;
import com.nzt.gdx.test.trials.tester.selector.TestScreenList;

@TestScreenList(group = "3D.B2D")
public class ST3DB2dWarg extends BaseST3D {

	public String modelPath = "models/warg.g3db";

	public Camera b2dCamera;

	public CameraInputController camController;
	private ModelBuilder modelBuilder;

	public Model wardModel;
	public ModelInstance wargInstance;
	public Environment environment;

	public ST3DB2dWarg(FastTesterMain main) {
		super(main);
		this.b2dCamera = new OrthographicCamera(B2DTestConstants.WIDTH_PPM, B2DTestConstants.HEIGHT_PPM);
//		this.b2dCamera = new OrthographicCamera(B2DTestConstants.WIDTH_PPM, B2DTestConstants.HEIGHT_PPM);
		this.b2dCamera.position.set(10, 10, 10);
		this.b2dCamera.lookAt(0, 0, 0);
		b2dCamera.near = 1f;
		b2dCamera.far = 300f;
		b2dCamera.update();

		modelBuilder = new ModelBuilder();

		environment = new Environment();
		environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f));
		environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -1f, -0.8f, -0.2f));

		wardModel = new G3dModelLoader(new UBJsonReader()).loadModel(Gdx.files.internal(modelPath));
		wargInstance = new ModelInstance(wardModel);
		for (Animation anim : wargInstance.animations) {
			System.out.println(anim.id);
		}

		camController = new CameraInputController(b2dCamera);
		Gdx.input.setInputProcessor(camController);
	}

	@Override
	public void renderTestScreen(float dt) {
		this.b2dCamera.update();
		camController.update();
		modelBatch.begin(b2dCamera);
		modelBatch.render(wargInstance);
		modelBatch.end();
	}

	@Override
	public void disposeTestScreen() {
		wardModel.dispose();
	}
}
