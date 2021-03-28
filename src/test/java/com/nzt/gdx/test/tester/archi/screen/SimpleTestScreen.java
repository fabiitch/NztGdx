package com.nzt.gdx.test.tester.archi.screen;

import com.badlogic.gdx.Gdx;
import com.nzt.gdx.screen.SimpleScreen;
import com.nzt.gdx.test.tester.archi.main.FastTesterMain;

public abstract class SimpleTestScreen extends SimpleScreen<FastTesterMain> {

	public SimpleTestScreen(FastTesterMain main) {
		super(main);
	}

	@Override
	public void setTitle(float dt) {
		Gdx.graphics.setTitle(this.getClass().getSimpleName() + "  FPS : " + Gdx.graphics.getFramesPerSecond());
	}


}
