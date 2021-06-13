package com.nzt.gdx.test.trials.st.t3d.viewer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.utils.ScreenUtils;
import com.nzt.gdx.test.trials.st.t3d.BaseST3D;
import com.nzt.gdx.test.trials.st.t3d.CameraInputControllerFR;
import com.nzt.gdx.test.trials.tester.archi.main.FastTesterMain;
import com.nzt.gdx.test.trials.tester.archi.screens.SimpleTestScreen;
import com.nzt.gdx.test.trials.tester.archi.screens.TestScreen;
import com.nzt.gdx.test.trials.tester.selector.TestScreenList;

@TestScreenList(group = "3D")
public class ST3DModelViewer extends BaseST3D {

    public InputMultiplexer inputMultiplexer;
    public Camera camera;
    public CameraInputController camController;

    private ModelViewerStage stage;
    private ModelViewerHelper helper;

    public ST3DModelViewer(FastTesterMain main) {
        super(main);

        camera = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.position.set(10f, 10f, 10f);
        this.camera.lookAt(0, 0, 0);
        camera.near = 1f;
        camera.far = 300f;
        camera.update();

        camController = new CameraInputControllerFR(camera);
        this.helper = new ModelViewerHelper(this);
        stage = new ModelViewerStage(this, helper);


        this.inputMultiplexer = new InputMultiplexer(stage, camController);
        Gdx.input.setInputProcessor(inputMultiplexer);
        helper.changeModel("warg.g3db");
    }

    @Override
    public void renderTestScreen(float dt) {
        this.camera.update();
        this.stage.update();
        camController.update();
        modelBatch.begin(camera);
        modelBatch.render(helper.modelInstance);
        modelBatch.end();

        stage.act();
        stage.draw();
    }

    @Override
    public void disposeTestScreen() {
        if (helper.model != null)
            helper.model.dispose();
    }


    @Override
    public void clearScreen() {
        ScreenUtils.clear(Color.BLACK, true);
    }

    @Override
    public void doResize(int width, int height) {
        stage.resize(width, height);
    }
}
