package com.nzt.gdx.tester.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.nzt.gdx.archi.AbstractMain;
import com.nzt.gdx.debug.hud.base.HudDebugDisplay;
import com.nzt.gdx.screen.SimpleScreen;

public class HudDebugDisplayScreen extends SimpleScreen {
	private Stage stage;
	private HudDebugDisplay debugHud;

	public HudDebugDisplayScreen(AbstractMain main) {
		super(main);
		stage = new Stage();
		this.debugHud = new HudDebugDisplay(stage);
	}

	@Override
	public void doShow() {
		for (int i = 0; i < 5; i++) {
			HudDebugDisplay.instance.addTopLeft("addTopLeft " + i, Gdx.app.getJavaHeap(), Color.RED);
		}
		for (int i = 0; i < 5; i++) {
			HudDebugDisplay.instance.addTopMiddle("addTopMiddle " + i, Gdx.app.getJavaHeap(), Color.WHITE);
		}
		for (int i = 0; i < 5; i++) {
			HudDebugDisplay.instance.addTopRight("addTopRight " + i, Gdx.app.getJavaHeap(), Color.YELLOW);
		}
		for (int i = 0; i < 5; i++) {
			HudDebugDisplay.instance.addBotLeft("addBotLeft " + i, Gdx.app.getJavaHeap(), Color.GOLD);
		}
		for (int i = 0; i < 5; i++) {
			HudDebugDisplay.instance.addBotMiddle("addBotMiddle " + i, Gdx.app.getJavaHeap(), Color.GREEN);
		}
		for (int i = 0; i < 5; i++) {
			HudDebugDisplay.instance.addBotRight("addBotRight" + i, Gdx.app.getJavaHeap(), Color.BROWN);
		}
		for (int i = 0; i < 5; i++) {
			HudDebugDisplay.instance.addRightMiddle("addRightMiddle" + i, Gdx.app.getJavaHeap(), Color.GRAY);
		}
		for (int i = 0; i < 5; i++) {
			HudDebugDisplay.instance.addLeftMiddle("addLeftMiddle" + i, Gdx.app.getJavaHeap(), Color.CYAN);
		}
	}

	@Override
	protected void renderScreen(float dt) {
		stage.act();
		stage.draw();
	}
}
