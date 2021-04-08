package com.nzt.gdx.test.screens.scene2D.widgets.nzt;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.nzt.gdx.test.screens.scene2D.Scene2DTestConstants;
import com.nzt.gdx.test.tester.archi.main.FastTesterMain;
import com.nzt.gdx.test.tester.archi.screens.SimpleTestScreen;
import com.nzt.gdx.test.tester.selector.TestScreen;

//TODO a reprendre quand on refait les touchpad générique
@TestScreen(group = "scene2D.widgets.touchpad.nzt")
public class STTouchPadNormalStage extends SimpleTestScreen {
	private Stage stage;

//	private TouchPad touchpad;

	private Texture textureBase;
	private Texture textureKnob;

	public STTouchPadNormalStage(FastTesterMain main) {
		super(main);
		this.stage = new Stage();
		createTouchPad();
	}

	private void createTouchPad() {
		textureBase = new Texture(Scene2DTestConstants.TOUCHPAD_MFL_BASE);
		textureKnob = new Texture(Scene2DTestConstants.TOUCHPAD_MFL_KNOB);
//		TouchPadConfig config = new TouchPadConfig(textureBase, textureKnob, false, new Vector2(100, 100), 150, 50);
//		touchpad = new TouchPad(config);

	}

	@Override
	protected void renderScreen(float dt) {
		this.stage.act();
		this.stage.draw();

	}

	@Override
	public void doDispose() {
		stage.dispose();
		textureBase.dispose();
		textureKnob.dispose();

	}
}
