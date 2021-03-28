package com.nzt.gdx.test.screens.t3d;

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
import com.nzt.gdx.test.tester.TestScreen;
import com.nzt.gdx.test.tester.archi.main.FastTesterMain;
import com.nzt.gdx.test.tester.archi.screen.SimpleTestScreen;

@TestScreen(groupName = "3D")
public class OrthoCam3DTest extends SimpleTestScreen {
    public Camera camera;

    public CameraInputController camController;
    private ModelBuilder modelBuilder;

    public Model wardModel;
    public ModelInstance wargInstance;
    public Environment environment;

    public OrthoCam3DTest(FastTesterMain main) {
        super(main);
        this.camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        this.camera.position.set(10, 10, 10);
        this.camera.lookAt(0, 0, 0);
        camera.near = 1f;
        camera.far = 300f;
        camera.update();

        ModelBuilder modelBuilder = new ModelBuilder();

        environment = new Environment();
        environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f));
        environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -1f, -0.8f, -0.2f));

        wardModel = new G3dModelLoader(new UBJsonReader()).loadModel(Gdx.files.internal("models/warg.g3db"));
        wargInstance = new ModelInstance(wardModel);
        for (Animation anim : wargInstance.animations) {
            System.out.println(anim.id);
        }

        camController = new CameraInputController(camera);
        Gdx.input.setInputProcessor(camController);
    }

    @Override
    protected void renderScreen(float dt) {
        camController.update();
        modelBatch.begin(camera);
        modelBatch.render(wargInstance);
        modelBatch.end();
    }

    @Override
    public void doDispose() {
        wardModel.dispose();
    }

}
