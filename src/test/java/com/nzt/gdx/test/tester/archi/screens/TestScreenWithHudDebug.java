package com.nzt.gdx.test.tester.archi.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.nzt.gdx.debug.hud.base.HudDebug;
import com.nzt.gdx.scene2D.nz.NzStage;
import com.nzt.gdx.test.screens.scene2D.Scene2DTestConstants;
import com.nzt.gdx.test.tester.archi.main.FastTesterMain;

public abstract class TestScreenWithHudDebug extends SimpleTestScreen {
	protected Stage stage;
	protected Skin skin;
	private HudDebug debugHud;

	public TestScreenWithHudDebug(FastTesterMain main) {
		super(main);
		this.stage = new NzStage();
		this.skin = new Skin(Gdx.files.internal(Scene2DTestConstants.UI_SKIN));
		this.debugHud = new HudDebug(stage, skin);
	}

	public abstract void renderAfterHud(float dt);

	@Override
	protected void renderScreen(float dt) {
		stage.act();
		stage.draw();
		renderAfterHud(dt);
	}

	@Override
	public void doDispose() {
		stage.dispose();
		skin.dispose();
	}
}
