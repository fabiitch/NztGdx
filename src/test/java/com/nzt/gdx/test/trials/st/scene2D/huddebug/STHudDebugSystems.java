package com.nzt.gdx.test.trials.st.scene2D.huddebug;

import com.badlogic.gdx.graphics.Color;
import com.nzt.gdx.ashley.systems.debug.hud.HudDebugApplicationInfoSystem;
import com.nzt.gdx.ashley.systems.debug.hud.HudDebugGlProfilerSystem;
import com.nzt.gdx.ashley.systems.debug.hud.HudDebugPerformanceSystem;
import com.nzt.gdx.debug.hud.HudDebugPosition;
import com.nzt.gdx.debug.hud.core.HudDebug;
import com.nzt.gdx.test.trials.tester.archi.main.FastTesterMain;
import com.nzt.gdx.test.trials.tester.archi.screens.BaseSystemTestScreen;
import com.nzt.gdx.test.trials.tester.archi.systems.HudSystem;
import com.nzt.gdx.test.trials.tester.selector.TestScreenList;

/**
 * Test FramePerformance on systems
 */
@TestScreenList(group = "scene2D.hud debug")
public class STHudDebugSystems extends BaseSystemTestScreen {
	private HudDebug debugHud;

	public STHudDebugSystems(FastTesterMain main) {
		super(main);
		HudSystem hudSystem = new HudSystem(nzStage);
		engine.addSystem(hudSystem);

		HudDebugApplicationInfoSystem hudDebugGlobalInfoSystem = new HudDebugApplicationInfoSystem(
				HudDebugPosition.TOP_LEFT, Color.CYAN);
		engine.addSystem(hudDebugGlobalInfoSystem);

		HudDebugGlProfilerSystem glProfilerSystem = new HudDebugGlProfilerSystem(main.logManager.nzGlProfiler,
				HudDebugPosition.TOP_RIGHT, Color.RED);

		HudDebugPerformanceSystem perfSystem = new HudDebugPerformanceSystem(HudDebugPosition.BOT_RIGHT);
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
