package com.nzt.gdx.test.screens.scene2D.widgets;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.nzt.gdx.test.tester.archi.main.FastTesterMain;
import com.nzt.gdx.test.tester.archi.screen.SimpleTestScreen;
import com.nzt.gdx.test.tester.selector.TestScreen;

@TestScreen(groupName = { "scene2D", "widgets" })
public class STKnob extends SimpleTestScreen {
	private Stage stage;

	public STKnob(FastTesterMain main) {
		super(main);
		this.stage = new Stage();
	}

	@Override
	protected void renderScreen(float dt) {

	}
}
