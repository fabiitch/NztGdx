package com.nzt.gdx.test.trials.st.input;

import com.badlogic.gdx.Gdx;
import com.nzt.gdx.input.camera.Cam2DController;
import com.nzt.gdx.test.trials.tester.archi.main.FastTesterMain;
import com.nzt.gdx.test.trials.tester.selector.TestScreenList;

@TestScreenList(group = "input")
public class ST2DControlCam extends BaseST2DControlCam {

    private Cam2DController cam2DController;

    public ST2DControlCam(FastTesterMain main) {
        super(main);
        this.cam2DController = new Cam2DController(camera);
        Gdx.input.setInputProcessor(cam2DController);
    }

    @Override
    public String getExplication() {
        return "Camera control en 2D, ZQSD for move or click/drag";
    }

    @Override
    public void renderTestScreen(float dt) {
        cam2DController.update(dt);
        super.renderTestScreen(dt);
    }

}
