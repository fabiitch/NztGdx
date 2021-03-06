package com.nzt.gdx.test.trials.st.t3d;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.graphics.g3d.utils.MeshPartBuilder;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.nzt.gdx.test.trials.st.B2dTestConstants;
import com.nzt.gdx.test.trials.tester.archi.main.FastTesterMain;
import com.nzt.gdx.test.trials.tester.archi.screens.TestScreen;

//TODO a voir l'utilité
public abstract class BaseST3D extends TestScreen {
    public CameraInputController camController;
    public Camera camera;

    public BaseST3D(FastTesterMain main) {
        super(main);
        createCamera();
        camController = new CameraInputControllerFR(camera);
        Gdx.input.setInputProcessor(camController);
        addHudToGlProfiler();
        createAxes();
    }

    public void giveCamera(boolean toOrtho, boolean toB2D) {
        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();
        if (toB2D) {
            width /= B2dTestConstants.PPM;
            height /= B2dTestConstants.PPM;
        }
        if (toOrtho) {
            this.camera = new OrthographicCamera(width, height);
        } else {
            this.camera = new PerspectiveCamera(67, width, height);
        }
        this.camController.camera = this.camera;
        this.camController.reset();
    }
    public abstract void createCamera();

    public abstract void render3D(float dt);

    public final void renderTestScreen(float dt) {
        camera.update();
        modelBatch.begin(camera);
        if (showAxes) modelBatch.render(axesInstance);
        render3D(dt);
        modelBatch.end();
    }

    final float GRID_MIN = -10f;
    final float GRID_MAX = 10f;
    final float GRID_STEP = 1f;
    public boolean showAxes = true;
    public Model axesModel;
    public ModelInstance axesInstance;

    private void createAxes() {
        ModelBuilder modelBuilder = new ModelBuilder();
        modelBuilder.begin();
        MeshPartBuilder builder = modelBuilder.part("grid", GL20.GL_LINES, VertexAttributes.Usage.Position | VertexAttributes.Usage.ColorUnpacked, new Material());
        builder.setColor(Color.LIGHT_GRAY);
        for (float t = GRID_MIN; t <= GRID_MAX; t += GRID_STEP) {
            builder.line(t, 0, GRID_MIN, t, 0, GRID_MAX);
            builder.line(GRID_MIN, 0, t, GRID_MAX, 0, t);
        }
        builder = modelBuilder.part("axes", GL20.GL_LINES, VertexAttributes.Usage.Position | VertexAttributes.Usage.ColorUnpacked, new Material());
        builder.setColor(Color.RED);
        builder.line(0, 0, 0, 100, 0, 0);
        builder.setColor(Color.GREEN);
        builder.line(0, 0, 0, 0, 100, 0);
        builder.setColor(Color.BLUE);
        builder.line(0, 0, 0, 0, 0, 100);
        axesModel = modelBuilder.end();
        axesInstance = new ModelInstance(axesModel);
    }

    @Override
    public void clearScreen() {
        Gdx.gl.glClearColor(1, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
    }

    public abstract void dispose3D();

    @Override
    public final void disposeTestScreen() {
        axesModel.dispose();

    }
}
