package com.nzt.gdx.test.trials.st.utils.perf.memory;

import com.nzt.gdx.debug.hud.HudDebugApplicationInfo;
import com.nzt.gdx.test.trials.tester.archi.main.FastTesterMain;
import com.nzt.gdx.test.trials.tester.archi.screens.TestScreenWithHudDebug;
import com.nzt.gdx.test.trials.tester.selector.TestScreen;

@TestScreen(group = "utils.perf.memory")
public class STAllocationTrackingHudDebug extends TestScreenWithHudDebug {
    HudDebugApplicationInfo hudDebugApplicationInfo;

    public STAllocationTrackingHudDebug(FastTesterMain main) {
        super(main);
        hudDebugApplicationInfo = new HudDebugApplicationInfo();
        glProfiler.removeHudDebug();
        glProfiler.desactive();
    }

    @Override
    public void renderAfterHud(float dt) {
        hudDebugApplicationInfo.update(dt);
    }
}
