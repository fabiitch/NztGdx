package com.nzt.gdx.test.trials.st.scene2D.huddebug;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.nzt.gdx.debug.hud.core.HudDebug;
import com.nzt.gdx.test.trials.tester.archi.main.FastTesterMain;
import com.nzt.gdx.test.trials.tester.archi.screens.stages.STStageScreen;
import com.nzt.gdx.test.trials.tester.selector.TestScreen;

/**
 * Test HudDebug Display
 */
@TestScreen(group = "scene2D.HudDebug")
public class STHudDebugDisplay extends STStageScreen {

	private HudDebug hudDebug;

	public STHudDebugDisplay(FastTesterMain main) {
		super(main);
	}

	@Override
	public void init() {
		this.hudDebug = new HudDebug(stage, skin);
		for (int i = 0; i < 5; i++) {
			HudDebug.addTopLeft("addTopLeft " + i, Gdx.app.getJavaHeap(), Color.RED);
		}
		for (int i = 0; i < 5; i++) {
			HudDebug.addTopMiddle("addTopMiddle " + i, Gdx.app.getJavaHeap(), Color.WHITE);
		}
		for (int i = 0; i < 5; i++) {
			HudDebug.addTopRight("addTopRight " + i, Gdx.app.getJavaHeap(), Color.YELLOW);
		}
		for (int i = 0; i < 5; i++) {
			HudDebug.addBotLeft("addBotLeft " + i, Gdx.app.getJavaHeap(), Color.GOLD);
		}
		for (int i = 0; i < 5; i++) {
			HudDebug.addBotMiddle("addBotMiddle " + i, Gdx.app.getJavaHeap(), Color.GREEN);
		}
		for (int i = 0; i < 5; i++) {
			HudDebug.addBotRight("addBotRight" + i, Gdx.app.getJavaHeap(), Color.BROWN);
		}
		for (int i = 0; i < 5; i++) {
			HudDebug.addRightMiddle("addRightMiddle" + i, Gdx.app.getJavaHeap(), Color.GRAY);
		}
		for (int i = 0; i < 5; i++) {
			HudDebug.addLeftMiddle("addLeftMiddle" + i, Gdx.app.getJavaHeap(), Color.CYAN);
		}
	}
}
