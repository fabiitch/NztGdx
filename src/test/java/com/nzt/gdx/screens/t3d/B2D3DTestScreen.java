package com.nzt.gdx.screens.t3d;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
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
import com.nzt.gdx.main.AbstractMain;
import com.nzt.gdx.screen.SimpleScreen;
import com.nzt.gdx.screens.b2D.B2DTestConstants;

public class B2D3DTestScreen extends SimpleScreen<AbstractMain> {
	public Camera b2dCamera;
	private ModelBuilder modelBuilder;

	public Model wardModel;
	public ModelInstance wargInstance;
	public Environment environment;

	public B2D3DTestScreen(AbstractMain main) {
		super(main);
//      this.b2dCamera = new OrthographicCamera(GameConstants.WIDTH_PPM, GameConstants.HEIGHT_PPM);
		this.b2dCamera = new OrthographicCamera(B2DTestConstants.WIDTH_PPM, B2DTestConstants.HEIGHT_PPM);
		this.b2dCamera.position.set(10, 10, 10);
		this.b2dCamera.lookAt(0, 0, 0);
		b2dCamera.near = 1f;
		b2dCamera.far = 300f;
		b2dCamera.update();

		ModelBuilder modelBuilder = new ModelBuilder();

		environment = new Environment();
		environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f));
		environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -1f, -0.8f, -0.2f));

		Gdx.input.setInputProcessor(new CameraInputController(b2dCamera));

		wardModel = new G3dModelLoader(new UBJsonReader()).loadModel(Gdx.files.internal("models/warg.g3db"));
		wargInstance = new ModelInstance(wardModel);
		for (Animation anim : wargInstance.animations) {
			System.out.println(anim.id);
		}
	}

	@Override
	protected void renderScreen(float dt) {

		this.b2dCamera.update();
		modelBatch.begin(b2dCamera);
		modelBatch.render(wargInstance);
		modelBatch.end();

	}
}