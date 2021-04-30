package com.nzt.gdx.test.trials.st.scene2D.huddebug;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.nzt.gdx.ashley.systems.debug.HudDebugApplicationInfoSystem;
import com.nzt.gdx.ashley.systems.debug.HudDebugGlProfilerSystem;
import com.nzt.gdx.ashley.systems.debug.HudDebugPerformanceSystem;
import com.nzt.gdx.debug.hud.HudDebugPosition;
import com.nzt.gdx.debug.hud.base.HudDebug;
import com.nzt.gdx.scene2D.nz.NzStage;
import com.nzt.gdx.test.trials.st.scene2D.Scene2DTestConstants;
import com.nzt.gdx.test.trials.tester.archi.main.FastTesterMain;
import com.nzt.gdx.test.trials.tester.archi.screens.systems.BaseSystemScreen;
import com.nzt.gdx.test.trials.tester.archi.systems.HudSystem;
import com.nzt.gdx.test.trials.tester.selector.TestScreen;

/**
 * Test FramePerformance on systems
 */
@TestScreen(group = "scene2D.HudDebug")
public class STHudDebugSystems extends BaseSystemScreen {
	protected NzStage nzStage;
	protected Skin skin;
	private HudDebug debugHud;

	public STHudDebugSystems(FastTesterMain main) {
		super(main);
		this.nzStage = new NzStage();
		this.skin = new Skin(Gdx.files.internal(Scene2DTestConstants.UI_SKIN));
		debugHud = new HudDebug(nzStage, skin);

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
	public void doDispose() {
		engine.getSystem(HudDebugGlProfilerSystem.class).desactive();
		nzStage.dispose();
		skin.dispose();
	}

}
