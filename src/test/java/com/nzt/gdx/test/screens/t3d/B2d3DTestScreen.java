package com.nzt.gdx.test.screens.t3d;

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
import com.nzt.gdx.test.screens.b2D.B2DTestConstants;
import com.nzt.gdx.test.tester.archi.main.FastTesterMain;
import com.nzt.gdx.test.tester.archi.screen.SimpleTestScreen;

public class B2d3DTestScreen extends SimpleTestScreen {
    public Camera b2dCamera;

    public CameraInputController camController;
    private ModelBuilder modelBuilder;

    public Model wardModel;
    public ModelInstance wargInstance;
    public Environment environment;

    public B2d3DTestScreen(FastTesterMain main) {
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

        wardModel = new G3dModelLoader(new UBJsonReader()).loadModel(Gdx.files.internal("models/warg.g3db"));
        wargInstance = new ModelInstance(wardModel);
        for (Animation anim : wargInstance.animations) {
            System.out.println(anim.id);
        }

        camController = new CameraInputController(b2dCamera);
        Gdx.input.setInputProcessor(camController);
    }

    @Override
    public void clearScreen() {
        Gdx.gl.glClearColor(1, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
    }

    @Override
    protected void renderScreen(float dt) {
        this.b2dCamera.update();
        camController.update();
        modelBatch.begin(b2dCamera);
        modelBatch.render(wargInstance);
        modelBatch.end();

    }
}