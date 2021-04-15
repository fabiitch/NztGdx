package com.nzt.gdx.test.screens.scene2D;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.nzt.gdx.debug.hud.base.HudDebug;
import com.nzt.gdx.test.tester.archi.main.FastTesterMain;
import com.nzt.gdx.test.tester.archi.screens.stages.STStageScreen;
import com.nzt.gdx.test.tester.selector.TestScreen;

@TestScreen(group = "scene2D.hud")
public class STHudDebug extends STStageScreen {

	private HudDebug debugHud;

	public STHudDebug(FastTesterMain main) {
		super(main);
		this.debugHud = new HudDebug(stage, skin);
	}


	@Override
	public void init() {
		for (int i = 0; i < 5; i++) {
			HudDebug.instance.addTopLeft("addTopLeft " + i, Gdx.app.getJavaHeap(), Color.RED);
		}
		for (int i = 0; i < 5; i++) {
			HudDebug.instance.addTopMiddle("addTopMiddle " + i, Gdx.app.getJavaHeap(), Color.WHITE);
		}
		for (int i = 0; i < 5; i++) {
			HudDebug.instance.addTopRight("addTopRight " + i, Gdx.app.getJavaHeap(), Color.YELLOW);
		}
		for (int i = 0; i < 5; i++) {
			HudDebug.instance.addBotLeft("addBotLeft " + i, Gdx.app.getJavaHeap(), Color.GOLD);
		}
		for (int i = 0; i < 5; i++) {
			HudDebug.instance.addBotMiddle("addBotMiddle " + i, Gdx.app.getJavaHeap(), Color.GREEN);
		}
		for (int i = 0; i < 5; i++) {
			HudDebug.instance.addBotRight("addBotRight" + i, Gdx.app.getJavaHeap(), Color.BROWN);
		}
		for (int i = 0; i < 5; i++) {
			HudDebug.instance.addRightMiddle("addRightMiddle" + i, Gdx.app.getJavaHeap(), Color.GRAY);
		}
		for (int i = 0; i < 5; i++) {
			HudDebug.instance.addLeftMiddle("addLeftMiddle" + i, Gdx.app.getJavaHeap(), Color.CYAN);
		}
	}
}
