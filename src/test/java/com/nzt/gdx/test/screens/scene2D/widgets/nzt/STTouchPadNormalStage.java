package com.nzt.gdx.test.screens.scene2D.widgets.nzt;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.nzt.gdx.graphics.DrawableUtils;
import com.nzt.gdx.scene2D.widgets.knob.TouchPad;
import com.nzt.gdx.scene2D.widgets.knob.TouchPadConfig;
import com.nzt.gdx.test.tester.archi.main.FastTesterMain;
import com.nzt.gdx.test.tester.archi.screen.SimpleTestScreen;
import com.nzt.gdx.test.tester.selector.TestScreen;

@TestScreen(group = "scene2D.widgets.touchpad.nzt")
public class STTouchPadNormalStage extends SimpleTestScreen {
	private Stage stage;

	private TouchPad touchpad;

	private static Texture textureBase = new Texture("gfx/hud/hud_mvt_base.png");
	private static Texture textureKnob = new Texture("gfx/hud/hud_mvt_little.png");

	public STTouchPadNormalStage(FastTesterMain main) {
		super(main);
		this.stage = new Stage();
	}

	private void createTouchPad() {

		TouchPadConfig config = new TouchPadConfig(textureBase, textureKnob, false, new Vector2(100, 100), 150, 50);

		touchpad = new TouchPad(config);

	}

	@Override
	protected void renderScreen(float dt) {
		this.stage.act();
		this.stage.draw();

	}

	@Override
	public void doDispose() {
		stage.dispose();

	}
}
