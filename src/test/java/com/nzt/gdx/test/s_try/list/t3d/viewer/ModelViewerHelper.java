package com.nzt.gdx.test.s_try.list.t3d.viewer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.loader.G3dModelLoader;
import com.badlogic.gdx.graphics.g3d.model.Animation;
import com.badlogic.gdx.utils.UBJsonReader;
import com.nzt.gdx.test.s_try.list.B2dTestConstants;

public class ModelViewerHelper {
    public Model model;
    public ModelInstance modelInstance;
    public STry3DModelViewer viewer;

    public ModelViewerHelper(STry3DModelViewer viewer) {
        this.viewer = viewer;
    }

    public void resetCamera(boolean toB2D) {
        float divide = toB2D ? B2dTestConstants.PPM : 1;
        float start = toB2D ? 150 : 10;

        viewer.camera.position.set(start / divide, start / divide, start / divide);
        viewer.camera.lookAt(0, 0, 0);
        viewer.camera.near = 1f;
        viewer.camera.far = 300f;
        viewer.camController.reset();
    }

    public void changeCameraType(boolean toOrtho, boolean toB2D) {
        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();
        if (toB2D) {
            width /= B2dTestConstants.PPM;
            height /= B2dTestConstants.PPM;
        }
        if (toOrtho) {
            viewer.camera = new OrthographicCamera(width, height);
        } else {
            viewer.camera = new PerspectiveCamera(67, width, height);
        }
        viewer.camController.camera = viewer.camera;
        viewer.camController.reset();
        resetCamera(toB2D);
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
                System.out.println("id=" + material.id + " mask" + material.getMask());
            }
        }
        System.out.println("====End load ======");
        modelInstance = new ModelInstance(model);
    }
}
