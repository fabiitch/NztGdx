package com.nzt.gdx.test.tester.archi.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.nzt.gdx.scene2D.nz.NzStage;
import com.nzt.gdx.test.screens.scene2D.Scene2DTestConstants;
import com.nzt.gdx.test.tester.archi.main.FastTesterMain;

public class STNzStageScreen extends SimpleTestScreen {
	protected NzStage nzStage;
	protected Skin skin;

	public STNzStageScreen(FastTesterMain main) {
		super(main);
		this.nzStage = new NzStage();
		this.skin = new Skin(Gdx.files.internal(Scene2DTestConstants.UI_SKIN));
		Gdx.input.setInputProcessor(nzStage);
	}

	@Override
	public void doDispose() {
		nzStage.act();
		nzStage.draw();
	}

	@Override
	protected void renderScreen(float dt) {
		nzStage.dispose();
		skin.dispose();
	}
}
