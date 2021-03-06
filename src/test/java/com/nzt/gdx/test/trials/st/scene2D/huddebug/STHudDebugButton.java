package com.nzt.gdx.test.trials.st.scene2D.huddebug;

import com.nzt.gdx.test.trials.tester.archi.main.FastTesterMain;
import com.nzt.gdx.test.trials.tester.archi.screens.TestScreen;
import com.nzt.gdx.test.trials.tester.selector.TestScreenList;

@TestScreenList(group = "scene2D.HudDebug")
public class STHudDebugButton extends TestScreen {
    public STHudDebugButton(FastTesterMain main) {
        super(main);
        setMsg("Hud debug have no button");
    }

    @Override
    public String getExplication() {
        return "Not Impl";
    }

    @Override
    public void renderTestScreen(float dt) {

    }

    @Override
    public void disposeTestScreen() {

    }
}
