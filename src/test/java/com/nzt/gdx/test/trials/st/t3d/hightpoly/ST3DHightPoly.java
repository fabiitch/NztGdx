package com.nzt.gdx.test.trials.st.t3d.hightpoly;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.loader.G3dModelLoader;
import com.badlogic.gdx.graphics.g3d.model.Animation;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.utils.UBJsonReader;
import com.nzt.gdx.test.trials.st.t3d.BaseST3D;
import com.nzt.gdx.test.trials.tester.archi.main.FastTesterMain;
import com.nzt.gdx.test.trials.tester.selector.TestScreenList;

@TestScreenList(group = "3D")
public class ST3DHightPoly extends BaseST3D {
    public Model cubeModel;
    public ModelInstance cubeModelInstance;

    public ST3DHightPoly(FastTesterMain main) {
        super(main);
        cubeModel = new G3dModelLoader(new UBJsonReader()).loadModel(Gdx.files.internal("models/test/Zephyr.g3db"));
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
    public String getExplication() {
        return "Test Hight poly";
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
