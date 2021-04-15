package com.nzt.gdx.test.screens.scene2D.widgets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.nzt.gdx.scene2D.StagePlacementUtils;
import com.nzt.gdx.test.tester.archi.main.FastTesterMain;
import com.nzt.gdx.test.tester.archi.screens.stages.STStageScreen;
import com.nzt.gdx.test.tester.selector.TestScreen;

@TestScreen(group = "scene2D.widgets.touchpad")
public class STGdxTouchPadSkinUI extends STStageScreen {

	public STGdxTouchPadSkinUI(FastTesterMain main) {
		super(main);
	}

	@Override
	public void init() {
		Touchpad touchpad = new Touchpad(500, skin);
		touchpad.setSize(Gdx.graphics.getWidth() / 4, Gdx.graphics.getWidth() / 4);
		StagePlacementUtils.placeCenter(touchpad,
				new Vector2(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2));
		stage.addActor(touchpad);

	}

}
