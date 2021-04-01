package com.nzt.gdx.test.screens.t3d.viewer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.loader.G3dModelLoader;
import com.badlogic.gdx.graphics.g3d.model.Animation;
import com.badlogic.gdx.utils.UBJsonReader;
import com.nzt.gdx.test.screens.t3d.CameraInputControllerFR;

public class ModelViewerHelper {
    public Model model;
    public ModelInstance modelInstance;

    public ST3DModelViewer viewer;

    public ModelViewerHelper(ST3DModelViewer viewer) {
        this.viewer = viewer;
    }

    public void resetCamera() {
        viewer.camera.position.set(10f, 10f, 10f);
        viewer.camera.lookAt(0, 0, 0);
        viewer.camera.near = 1f;
        viewer.camera.far = 300f;
        viewer.camController.reset();
    }

    public boolean changeCameraType() {
        boolean toReturn;
        Camera camera = viewer.camera;
        if (camera.getClass() == PerspectiveCamera.class) {
            viewer.camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
            toReturn = false;
        } else {
            viewer.camera = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
            toReturn = true;
        }
        viewer.camController.camera = viewer.camera;
        viewer.camController.reset();
        resetCamera();
        return toReturn;
    }

    public void changeModel(String modelPath) {
        if (model != null)
            model.dispose();
        model = new G3dModelLoader(new UBJsonReader()).loadModel(Gdx.files.internal("models/" + modelPath));
        System.out.println("==== new model loaded : " + modelPath);
        if (model.animations != null && model.animations.size > 0) {
            System.out.println("Animation list !");
            for (Animation anim : model.animations) {
                System.out.println("id=" + anim.id + "  duration=" + anim.duration);
            }
        }
        if (model.materials != null && model.materials.size > 0) {
            System.out.println("Materials list !");
            for (Material material : model.materials) {
                System.out.println("id=" + material.id + " mast" + material.getMask());
            }
        }
        System.out.println("====End load ======");
        modelInstance = new ModelInstance(model);
    }
}
