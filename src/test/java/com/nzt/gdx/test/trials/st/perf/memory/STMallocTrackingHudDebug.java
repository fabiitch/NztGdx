package com.nzt.gdx.test.trials.st.perf.memory;

import com.badlogic.gdx.graphics.Color;
import com.nzt.gdx.debug.hud.HudDebugApplicationInfo;
import com.nzt.gdx.debug.hud.core.HudDebug;
import com.nzt.gdx.debug.perf.PerformanceFrame;
import com.nzt.gdx.test.trials.tester.archi.main.FastTesterMain;
import com.nzt.gdx.test.trials.tester.archi.screens.TestScreen;
import com.nzt.gdx.test.trials.tester.selector.TestScreenList;
import com.nzt.gdx.utils.GdxUtils;

@TestScreenList(group = "perf.malloc")
public class STMallocTrackingHudDebug extends TestScreen {
    private final HudDebugApplicationInfo hudDebugApplicationInfo;
    private final long memoryStart;

    public STMallocTrackingHudDebug(FastTesterMain main) {
        super(main);
        hudDebugApplicationInfo = new HudDebugApplicationInfo();
        nzGLProfiler.desactive();

        PerformanceFrame.enabled = false;

        HudDebug.addTopMiddle("Memory Grow", "No", Color.BLUE);
        this.memoryStart = GdxUtils.getHeapMb();
    }

    @Override
    public String getExplication() {
        return "Cherche alloc sur HudDebug";
    }

    @Override
    public void renderTestScreen(float dt) {
        hudDebugApplicationInfo.update(dt);
        if (GdxUtils.getHeapMb() > memoryStart) {
            HudDebug.changeColor("Memory Grow", Color.RED);
            HudDebug.update("Memory Grow", GdxUtils.getHeapMb() - memoryStart);
        }
    }

    @Override
    public void disposeTestScreen() {

    }
}
