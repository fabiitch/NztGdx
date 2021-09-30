package com.nzt.gdx.test.trials.st.scene2D.huddebug;

import com.badlogic.gdx.math.MathUtils;
import com.nzt.gdx.test.trials.tester.archi.main.FastTesterMain;
import com.nzt.gdx.test.trials.tester.archi.screens.TestScreen;
import com.nzt.gdx.test.trials.tester.selector.TestScreenList;

@TestScreenList(group = "scene2D.hud debug")
public class STHudDebugRightDisplay extends TestScreen {
    public STHudDebugRightDisplay(FastTesterMain main) {
        super(main);
    }

    @Override
    public String getTestExplication() {
        return "Test le display sur le right";
    }

    @Override
    public void renderTestScreen(float dt) {

    }

    private String randomString(int min, int max) {
        String s = "";
        int random = MathUtils.random(min, max);
        for (int i = 0; i < random; i++) {
            s += "1";
        }
        return s;
    }

    @Override
    public void disposeTestScreen() {

    }
}
