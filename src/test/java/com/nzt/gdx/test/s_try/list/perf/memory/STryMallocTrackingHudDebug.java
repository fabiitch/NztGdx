package com.nzt.gdx.test.s_try.list.perf.memory;

import com.badlogic.gdx.graphics.Color;
import com.nzt.gdx.debug.hud.HudDebugApplicationInfo;
import com.nzt.gdx.debug.hud.core.HudDebug;
import com.nzt.gdx.debug.perf.PerformanceFrame;
import com.nzt.gdx.test.utils.archi.mains.dev.FastTesterMain;
import com.nzt.gdx.test.utils.archi.screens.ScreenTry;
import com.nzt.gdx.test.utils.screen_selector.TestScreen;
import com.nzt.gdx.utils.GdxUtils;

@TestScreen(group = "utils.perf.malloc")
public class STryMallocTrackingHudDebug extends ScreenTry {
    private final HudDebugApplicationInfo hudDebugApplicationInfo;
    private final long memoryStart;

    public STryMallocTrackingHudDebug(FastTesterMain main) {
        super(main);
        hudDebugApplicationInfo = new HudDebugApplicationInfo();
        nzGLProfiler.desactive();

        PerformanceFrame.enabled = false;

        HudDebug.addTopMiddle("Memory Grow", "No", Color.BLUE);
        this.memoryStart = GdxUtils.getHeapMb();
    }

    @Override
    public String getTestExplication() {
        return "Cherche alloc sur HudDebug";
    }

    @Override
    public void renderTestScreen(float dt) {
        hudDebugApplicationInfo.update(dt);
        if (GdxUtils.getHeapMb() > memoryStart) {
            HudDebug.updateColor("Memory Grow", Color.RED);
            HudDebug.update("Memory Grow", GdxUtils.getHeapMb() - memoryStart);
        }
    }

    @Override
    public void disposeTestScreen() {

    }
}
