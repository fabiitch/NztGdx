package com.nzt.gdx.test.s_try.list.t3d;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.loader.G3dModelLoader;
import com.badlogic.gdx.graphics.g3d.model.Animation;
import com.badlogic.gdx.utils.UBJsonReader;
import com.nzt.gdx.test.utils.archi.mains.mains.FastTesterMain;
import com.nzt.gdx.test.utils.screen_selector.TestScreen;

@TestScreen(group = "3D")
public class STry3DLoadModel extends BaseSTry3D {
    public Model cubeModel;
    public ModelInstance cubeModelInstance;

    String modelPath = "models/cubeColor.g3db";

    public STry3DLoadModel(FastTesterMain main) {
        super(main);
        cubeModel = new G3dModelLoader(new UBJsonReader()).loadModel(Gdx.files.internal(modelPath));
        cubeModelInstance = new ModelInstance(cubeModel);
        for (Animation anim : cubeModelInstance.animations) {
            System.out.println(anim.id);
        }
        for (Material material : cubeModelInstance.materials) {
            System.out.println(material.id);
        }
    }

    @Override
    public void createCamera() {
        camera = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.position.set(10f, 10f, 10f);
        this.camera.lookAt(0, 0, 0);
        camera.near = 1f;
        camera.far = 300f;
        camera.update();
    }

    @Override
    public String getTestExplication() {
        return "Load 3D model";
    }

    @Override
    public void render3D(float dt) {
        camController.update();
        modelBatch.render(cubeModelInstance);
    }

    @Override
    public void dispose3D() {
        cubeModel.dispose();
    }
}
