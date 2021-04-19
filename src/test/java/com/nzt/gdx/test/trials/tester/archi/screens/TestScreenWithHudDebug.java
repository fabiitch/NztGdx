package com.nzt.gdx.test.trials.tester.archi.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.nzt.gdx.debug.hud.base.HudDebug;
import com.nzt.gdx.scene2D.nz.NzStage;
import com.nzt.gdx.test.trials.st.scene2D.Scene2DTestConstants;
import com.nzt.gdx.test.trials.tester.archi.main.FastTesterMain;

public abstract class TestScreenWithHudDebug extends SimpleTestScreen {
	protected NzStage nzStage;
	protected Skin skin;
	private HudDebug debugHud;

	public TestScreenWithHudDebug(FastTesterMain main) {
		super(main);
		this.nzStage = new NzStage();
		this.skin = new Skin(Gdx.files.internal(Scene2DTestConstants.UI_SKIN));
		this.debugHud = new HudDebug(nzStage, skin);
	}

	public abstract void renderAfterHud(float dt);

	@Override
	protected void renderScreen(float dt) {
		nzStage.act();
		nzStage.draw();
		renderAfterHud(dt);
	}

	@Override
	public void doDispose() {
		nzStage.dispose();
		skin.dispose();
	}
}
