package com.nzt.gdx.test.trials.st.perf.memory;

import com.badlogic.gdx.graphics.Color;
import com.nzt.gdx.debug.hud.HudDebugApplicationInfo;
import com.nzt.gdx.debug.hud.core.HudDebug;
import com.nzt.gdx.debug.perf.PerformanceFrame;
import com.nzt.gdx.test.trials.tester.archi.main.FastTesterMain;
import com.nzt.gdx.test.trials.tester.archi.screens.TestScreenWithHudDebug;
import com.nzt.gdx.test.trials.tester.selector.TestScreen;
import com.nzt.gdx.utils.GdxUtils;

@TestScreen(group = "perf.malloc")
public class STMallocTrackingHudDebug extends TestScreenWithHudDebug {
    final HudDebugApplicationInfo hudDebugApplicationInfo;

    private final long memoryStart;

    public STMallocTrackingHudDebug(FastTesterMain main) {
        super(main);
        hudDebugApplicationInfo = new HudDebugApplicationInfo();
        glProfiler.removeHudDebug();
        nzGLProfiler.desactive();

        PerformanceFrame.enabled = false;

        HudDebug.addTopMiddle("Memory Grow", "No", Color.BLUE);
        this.memoryStart = GdxUtils.getHeapMb();
    }

    @Override
    public void renderAfterHud(float dt) {
        hudDebugApplicationInfo.update(dt);
        if (GdxUtils.getHeapMb() > memoryStart) {
            HudDebug.changeColor("Memory Grow", Color.RED);
            HudDebug.update("Memory Grow", GdxUtils.getHeapMb() - memoryStart);
        }
    }
}
