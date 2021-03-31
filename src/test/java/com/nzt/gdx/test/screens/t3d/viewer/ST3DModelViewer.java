package com.nzt.gdx.test.screens.t3d.viewer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.loader.G3dModelLoader;
import com.badlogic.gdx.graphics.g3d.model.Animation;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Tree;
import com.badlogic.gdx.utils.UBJsonReader;
import com.nzt.gdx.scene2D.nz.NzStage;
import com.nzt.gdx.test.tester.selector.TestScreen;
import com.nzt.gdx.test.tester.archi.main.FastTesterMain;
import com.nzt.gdx.test.tester.archi.screen.SimpleTestScreen;

import java.io.File;
import java.nio.file.Path;

@TestScreen(groupName = "3D")
public class ST3DModelViewer extends SimpleTestScreen {
    Skin skin = new Skin(Gdx.files.internal("ui/uiskin.json"));

    public Camera camera;

    public CameraInputController camController;
    public Model model;
    public ModelInstance modelInstance;

    String modelPathStart = "models";

    private boolean loading = true;


    private NzStage nzStage;
    Tree<ChangeModelNode, String> treeModels;

    public ST3DModelViewer(FastTesterMain main) {
        super(main);
        camera = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.position.set(10f, 10f, 10f);
        this.camera.lookAt(0, 0, 0);
        camera.near = 1f;
        camera.far = 300f;
        camera.update();

        camController = new CameraInputController(camera);
        Gdx.input.setInputProcessor(camController);
        nzStage = new NzStage();
        treeModels = new Tree<>(skin);
        treeModels.setPosition(0, Gdx.graphics.getHeight() / 2);
        nzStage.addActor(treeModels);
        nzStage.setDebugAll(true);

        new ModelViewerScanner(treeModels, skin);
    }


    public void changeModel(String modelPath) {
        loading = true;
        model.dispose();
        model = new G3dModelLoader(new UBJsonReader()).loadModel(Gdx.files.internal(modelPath));
        System.out.println("==== new model loaded :" + modelPath);
        for (Animation anim : modelInstance.animations) {
            System.out.println(anim.id);
        }
        for (Material material : modelInstance.materials) {
            System.out.println(material.id);
        }
        modelInstance = new ModelInstance(model);
        loading = false;
    }

    @Override
    public void clearScreen() {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
    }

    @Override
    protected void renderScreen(float dt) {
        this.camera.update();
        camController.update();
        if (!loading) {
            modelBatch.begin(camera);
            modelBatch.render(modelInstance);
            modelBatch.end();
        }
        nzStage.act();
        nzStage.draw();

    }


    public void doDispose() {
        nzStage.dispose();
        model.dispose();
    }
}