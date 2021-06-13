package com.nzt.gdx.test.trials.st.input;

import com.nzt.gdx.test.trials.tester.archi.main.FastTesterMain;
import com.nzt.gdx.test.trials.tester.archi.screens.TestScreen;
import com.nzt.gdx.test.trials.tester.selector.TestScreenList;

@TestScreenList(group = "input")
public class ST2DControlCam extends TestScreen {
    public ST2DControlCam(FastTesterMain main) {
        super(main);
    }

    @Override
    public String getExplication() {
        return "Camera control en 2D";
    }

    @Override
    public void renderTestScreen(float dt) {

    }

    @Override
    public void disposeTestScreen() {

    }
}
