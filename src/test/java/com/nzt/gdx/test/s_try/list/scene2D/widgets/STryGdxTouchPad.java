package com.nzt.gdx.test.s_try.list.scene2D.widgets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad.TouchpadStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.nzt.gdx.test.s_try.list.scene2D.STryScene2DConstants;
import com.nzt.gdx.test.utils.archi.mains.dev.FastTesterMain;
import com.nzt.gdx.test.utils.archi.screens.ScreenTry;
import com.nzt.gdx.test.utils.screen_selector.TestScreen;

@TestScreen(group = "scene2D.widgets.touchpads")
public class STryGdxTouchPad extends ScreenTry {

    private OrthographicCamera camera;
    private Touchpad touchpad;
    private TouchpadStyle touchpadStyle;
    private Skin touchpadSkin;
    private Drawable touchBackground;
    private Drawable touchKnob;
    private Texture blockTexture;
    private Sprite blockSprite;
    private float blockSpeed;

    private int skinNum;

    public STryGdxTouchPad(FastTesterMain main) {
        super(main);
        init();
    }

    @Override
    public String getTestExplication() {
        return null;
    }

    public void init() {
        skinNum = 0;
        // Create camera
        float aspectRatio = (float) Gdx.graphics.getWidth() / (float) Gdx.graphics.getHeight();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 10f * aspectRatio, 10f);

        // Create a Stage and add TouchPad

        // Create block sprite
        blockTexture = new Texture(Gdx.files.internal("badlogic.jpg"));
        blockSprite = new Sprite(blockTexture, Gdx.graphics.getWidth() / 6, Gdx.graphics.getWidth() / 6);
        // Set order to centre of the screen
        blockSprite.setPosition(Gdx.graphics.getWidth() / 2 - blockSprite.getWidth() / 2,
                Gdx.graphics.getHeight() / 2 - blockSprite.getHeight() / 2);

        blockSpeed = 5;

        createTouchPad();

        this.skin = new Skin(Gdx.files.internal(STryScene2DConstants.UI_SKIN));
        TextButton changeSkinButton = new TextButton("Change Skin", skin);

        changeSkinButton.setPosition(Gdx.graphics.getWidth() - changeSkinButton.getWidth(),
                Gdx.graphics.getHeight() - changeSkinButton.getHeight());

        changeSkinButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                touchpad.remove();
                touchpadSkin.dispose();
                touchpad.clear();
                if (skinNum == 1) {
                    skinNum = 0;
                } else {
                    skinNum = 1;
                }
                createTouchPad();

            }
        });
        nzStage.addActor(changeSkinButton);
        Gdx.input.setInputProcessor(nzStage);
    }

    private void createTouchPad() {
        String knobChoose;
        if (skinNum == 1) {
            log("Skin = PICKED");
            knobChoose = STryScene2DConstants.TOUCHPAD_PICKED;
        } else {
            log("Skin = MFL");
            knobChoose = STryScene2DConstants.TOUCHPAD_MFL;
        }
        // Create a touchpad skin
        touchpadSkin = new Skin();
        // Set background image
        touchpadSkin.add("touchBackground", new Texture(knobChoose + "background.png"));
        // Set knob image
        touchpadSkin.add("touchKnob", new Texture(knobChoose + "knob.png"));
        // Create TouchPad Style
        touchpadStyle = new TouchpadStyle();
        // Create Drawable's from TouchPad skin
        touchBackground = touchpadSkin.getDrawable("touchBackground");
        touchKnob = touchpadSkin.getDrawable("touchKnob");
        // Apply the Drawables to the TouchPad Style
        touchpadStyle.background = touchBackground;
        touchpadStyle.knob = touchKnob;
        touchpadStyle.knob.setMinWidth(100);
        touchpadStyle.knob.setMinHeight(100);
        // Create new TouchPad with the created style
        touchpad = new Touchpad(10, touchpadStyle);
        // setBounds(x,y,width,height)
        touchpad.setBounds(15, 15, 200, 200);
        nzStage.addActor(touchpad);
    }

    @Override
    public void renderTestScreen(float dt) {
        camera.update();

        // Move blockSprite with TouchPad
        blockSprite.setX(blockSprite.getX() + touchpad.getKnobPercentX() * blockSpeed);
        blockSprite.setY(blockSprite.getY() + touchpad.getKnobPercentY() * blockSpeed);

        // Draw
        spriteBatch.begin();
        blockSprite.draw(spriteBatch);
        spriteBatch.end();
        nzStage.act(Gdx.graphics.getDeltaTime());
        nzStage.draw();

    }

    @Override
    public void disposeTestScreen() {
        touchpadSkin.dispose();
    }

}
