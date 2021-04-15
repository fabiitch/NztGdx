package com.nzt.gdx.test.trials.tester.archi.screens;

import com.badlogic.gdx.Gdx;
import com.nzt.gdx.screen.SimpleScreen;
import com.nzt.gdx.test.trials.tester.archi.main.FastTesterMain;

public abstract class SimpleTestScreen extends SimpleScreen<FastTesterMain> {

	public SimpleTestScreen(FastTesterMain main) {
		super(main);
	}

	@Override
	public void setTitle(float dt) {
		Gdx.graphics.setTitle(this.getClass().getSimpleName() + "  FPS : " + Gdx.graphics.getFramesPerSecond());
	}

	public void log(String log) {
		Gdx.app.log(this.getClass().getSimpleName(), log);
	}

}
