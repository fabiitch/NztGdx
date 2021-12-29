package com.nzt.gdx.test.s_try.list.scene2D.widgets.nzt;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.nzt.gdx.test.s_try.list.scene2D.STryScene2DConstants;
import com.nzt.gdx.test.utils.archi.mains.dev.FastTesterMain;
import com.nzt.gdx.test.utils.archi.screens.SimpleTestScreen;
import com.nzt.gdx.test.utils.screen_selector.TestScreen;

//TODO a reprendre quand on refait les touchpad générique
@TestScreen(group = "scene2D.widgets.touchpads")
public class STryTouchPadNormalStage extends SimpleTestScreen {
    private final Stage stage;

//	private TouchPad touchpad;

    private Texture textureBase;
    private Texture textureKnob;

    BitmapFont font;

    public STryTouchPadNormalStage(FastTesterMain main) {
        super(main);
        this.stage = new Stage();
        createTouchPad();

        font = new BitmapFont();
    }

    private void createTouchPad() {
        textureBase = new Texture(STryScene2DConstants.TOUCHPAD_MFL_BASE);
        textureKnob = new Texture(STryScene2DConstants.TOUCHPAD_MFL_KNOB);
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
