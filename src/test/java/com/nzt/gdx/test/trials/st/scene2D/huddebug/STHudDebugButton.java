package com.nzt.gdx.test.trials.st.scene2D.huddebug;

import com.nzt.gdx.test.trials.tester.archi.main.FastTesterMain;
import com.nzt.gdx.test.trials.tester.selector.TestScreenList;

@TestScreenList(group = "scene2D.hud debug")
public class STHudDebugButton extends com.nzt.gdx.test.trials.tester.archi.screens.TestScreen {
    public STHudDebugButton(FastTesterMain main) {
        super(main);
        setMsg("Hud debug have no button");
    }

    @Override
    public String getTestExplication() {
        return "Not Impl";
    }

    @Override
    public void renderTestScreen(float dt) {

    }

    @Override
    public void disposeTestScreen() {

    }
}
