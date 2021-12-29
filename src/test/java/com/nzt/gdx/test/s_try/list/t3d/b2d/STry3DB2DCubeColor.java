package com.nzt.gdx.test.s_try.list.t3d.b2d;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.loader.G3dModelLoader;
import com.badlogic.gdx.graphics.g3d.model.Animation;
import com.badlogic.gdx.utils.UBJsonReader;
import com.nzt.gdx.test.s_try.list.B2dTestConstants;
import com.nzt.gdx.test.s_try.list.t3d.BaseSTry3D;
import com.nzt.gdx.test.utils.archi.mains.dev.FastTesterMain;
import com.nzt.gdx.test.utils.screen_selector.TestScreen;

@TestScreen(group = "3D.B2D")
public class STry3DB2DCubeColor extends BaseSTry3D {
    public String modelPath = "models/cubeColor.g3db";

    public Model cubeModel;
    public ModelInstance cubeInstance;
    public Environment environment;

    public STry3DB2DCubeColor(FastTesterMain main) {
        super(main);
        environment = new Environment();
        environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f));
        environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -1f, -0.8f, -0.2f));

        cubeModel = new G3dModelLoader(new UBJsonReader()).loadModel(Gdx.files.internal(modelPath));
        cubeInstance = new ModelInstance(cubeModel);
        for (Animation anim : cubeInstance.animations) {
            System.out.println(anim.id);
        }
    }

    @Override
    public void createCamera() {
        this.camera = new OrthographicCamera(B2dTestConstants.WIDTH_PPM, B2dTestConstants.HEIGHT_PPM);
        this.camera.position.set(10, 10, 10);
        this.camera.lookAt(0, 0, 0);
        camera.near = 1f;
        camera.far = 300f;
        camera.update();
    }

    @Override
    public String getTestExplication() {
        return "Cube Color";
    }

    @Override
    public void render3D(float dt) {
        camController.update();
        modelBatch.render(cubeInstance);
    }

    @Override
    public void clearScreen() {
        Gdx.gl.glClearColor(1, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
    }

    @Override
    public void dispose3D() {
        cubeModel.dispose();
    }
}
