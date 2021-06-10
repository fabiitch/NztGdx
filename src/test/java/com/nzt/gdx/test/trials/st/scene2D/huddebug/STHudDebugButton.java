package com.nzt.gdx.test.trials.st.scene2D.huddebug;

import com.nzt.gdx.test.trials.tester.archi.main.FastTesterMain;
import com.nzt.gdx.test.trials.tester.archi.screens.TestScreenWithHudDebug;
import com.nzt.gdx.test.trials.tester.selector.TestScreen;

@TestScreen(group = "scene2D.HudDebug")
public class STHudDebugButton extends TestScreenWithHudDebug {
    public STHudDebugButton(FastTesterMain main) {
        super(main);
    }

    @Override
    public void renderAfterHud(float dt) {

    }
}
