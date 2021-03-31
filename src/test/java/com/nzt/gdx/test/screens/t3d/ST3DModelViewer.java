package com.nzt.gdx.test.screens.t3d;

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
import com.badlogic.gdx.utils.UBJsonReader;
import com.nzt.gdx.scene2D.nz.NzStage;
import com.nzt.gdx.test.tester.selector.TestScreen;
import com.nzt.gdx.test.tester.archi.main.FastTesterMain;
import com.nzt.gdx.test.tester.archi.screen.SimpleTestScreen;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

@TestScreen(groupName = "3D")
public class ST3DModelViewer extends SimpleTestScreen {
    public Camera camera;

    public CameraInputController camController;
    public Model model;
    public ModelInstance modelInstance;

    String modelPathStart = "models";

    private NzStage nzStage;

    private boolean loading = true;

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

    }


    private synchronized void listModels() {
        try {
            ClassLoader classLoader = this.getClass().getClassLoader();
            File modelsFolder = new File(classLoader.getResource("models").toURI());
            modelsFolder.list();
            Stream<Path> walk = Files.walk(Paths.get(modelsFolder.toURI()));

            walk.forEach(path -> {
                System.out.println(path);
            });
            System.out.println(walk);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadModel(String modelPath) {
        loading = true;
        model.dispose();
        model = new G3dModelLoader(new UBJsonReader()).loadModel(Gdx.files.internal(modelPath));
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
        }
        modelBatch.end();
    }
}