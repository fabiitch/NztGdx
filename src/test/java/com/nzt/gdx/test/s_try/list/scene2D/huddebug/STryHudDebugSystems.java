package com.nzt.gdx.test.s_try.list.scene2D.huddebug;

import com.badlogic.gdx.graphics.Color;
import com.nzt.gdx.ashley.systems.debug.hud.HudDebugApplicationInfoSystem;
import com.nzt.gdx.ashley.systems.debug.hud.HudDebugGlProfilerSystem;
import com.nzt.gdx.ashley.systems.debug.hud.HudDebugPerformanceSystem;
import com.nzt.gdx.debug.hud.HudDebugPosition;
import com.nzt.gdx.debug.hud.core.HudDebug;
import com.nzt.gdx.test.utils.archi.mains.mains.FastTesterMain;
import com.nzt.gdx.test.utils.archi.screens.BaseSystemTestScreen;
import com.nzt.gdx.test.utils.archi.systems.HudSystemAdapter;
import com.nzt.gdx.test.utils.screen_selector.TestScreen;

/**
 * Test FramePerformance on systems
 */
@TestScreen(group = "scene2D.hud debug")
public class STryHudDebugSystems extends BaseSystemTestScreen {
    private HudDebug debugHud;

    public STryHudDebugSystems(FastTesterMain main) {
        super(main);
        HudSystemAdapter hudSystem = new HudSystemAdapter(nzStage);
        engine.addSystem(hudSystem);

        HudDebugApplicationInfoSystem hudDebugGlobalInfoSystem = new HudDebugApplicationInfoSystem(
                HudDebugPosition.TOP_LEFT, Color.CYAN, 10);
        engine.addSystem(hudDebugGlobalInfoSystem);

        HudDebugGlProfilerSystem glProfilerSystem = new HudDebugGlProfilerSystem(main.logManager.nzGlProfiler,
                HudDebugPosition.TOP_RIGHT, Color.RED, 10);

        HudDebugPerformanceSystem perfSystem = new HudDebugPerformanceSystem(HudDebugPosition.BOT_RIGHT,
                Color.WHITE, 15);
        engine.addSystem(perfSystem);
        engine.addSystem(glProfilerSystem);

    }

    @Override
    public String getTestExplication() {
        return "Test des system qui log sur HudDebug";
    }

    @Override
    public void disposeTestScreen() {
        engine.getSystem(HudDebugGlProfilerSystem.class).desactive();
    }
}
