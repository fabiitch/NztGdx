package com.nzt.gdx.test.screens.scene2D.widgets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.nzt.gdx.scene2D.StagePlacementUtils;
import com.nzt.gdx.test.screens.scene2D.Scene2DTestConstants;
import com.nzt.gdx.test.tester.archi.main.FastTesterMain;
import com.nzt.gdx.test.tester.archi.screen.SimpleTestScreen;
import com.nzt.gdx.test.tester.selector.TestScreen;

@TestScreen(groupName = { "scene2D", "widgets","knob" })
public class STTouchPadSkinUI extends SimpleTestScreen {
	private Stage stage;
	private Skin skin = new Skin(Gdx.files.internal(Scene2DTestConstants.UI_SKIN));

	public STTouchPadSkinUI(FastTesterMain main) {
		super(main);
		this.stage = new Stage();

		Touchpad touchpad = new Touchpad(500, skin);

		touchpad.setSize(Gdx.graphics.getWidth() / 4, Gdx.graphics.getWidth() / 4);
		StagePlacementUtils.placeCenter(touchpad,
				new Vector2(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2));
		stage.addActor(touchpad);
		Gdx.input.setInputProcessor(stage);
	}

	@Override
	protected void renderScreen(float dt) {
		stage.act();
		stage.draw();
	}
}
