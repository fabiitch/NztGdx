package com.nzt.gdx.test.trials.tester.archi.screens.stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.nzt.gdx.test.trials.st.scene2D.Scene2DTestConstants;
import com.nzt.gdx.test.trials.tester.archi.main.FastTesterMain;
import com.nzt.gdx.test.trials.tester.archi.screens.SimpleTestScreen;

public abstract class STStageScreen extends SimpleTestScreen {
	protected Stage stage;
	protected Skin skin;

	public STStageScreen(FastTesterMain main) {
		super(main);
		System.out.println("STStageScreen");
		this.stage = new Stage();
		this.skin = new Skin(Gdx.files.internal(Scene2DTestConstants.UI_SKIN));
		Gdx.input.setInputProcessor(stage);
		init();
	}

	public abstract void init();

	@Override
	protected void renderScreen(float dt) {
		stage.act();
		stage.draw();
	}

	@Override
	public void doDispose() {
		stage.dispose();
		skin.dispose();
	}
}
