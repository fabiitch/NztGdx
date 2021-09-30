package com.nzt.gdx.test.trials.st.scene2D.widgets.nzt;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.nzt.gdx.test.trials.st.scene2D.Scene2DTestConstants;
import com.nzt.gdx.test.trials.tester.archi.mains.FastTesterMain;
import com.nzt.gdx.test.trials.tester.archi.screens.SimpleTestScreen;
import com.nzt.gdx.test.trials.tester.selector.TestScreenList;

//TODO a reprendre quand on refait les touchpad générique
@TestScreenList(group = "scene2D.widgets.touchpads")
public class STTouchPadNormalStage extends SimpleTestScreen {
    private final Stage stage;

//	private TouchPad touchpad;

    private Texture textureBase;
    private Texture textureKnob;

    BitmapFont font;

    public STTouchPadNormalStage(FastTesterMain main) {
        super(main);
        this.stage = new Stage();
        createTouchPad();

        font = new BitmapFont();
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
        spriteBatch.begin();
        font.draw(spriteBatch, "Not Impl //TODO", Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
        spriteBatch.end();
    }

    @Override
    public void doDispose() {
        stage.dispose();
        textureBase.dispose();
        textureKnob.dispose();

    }
}
