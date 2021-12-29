package com.nzt.gdx.test.s_try.list.scene2D.widgets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.nzt.gdx.scene2D.StagePlacementUtils;
import com.nzt.gdx.test.utils.archi.mains.dev.FastTesterMain;
import com.nzt.gdx.test.utils.archi.screens.ScreenTry;
import com.nzt.gdx.test.utils.screen_selector.TestScreen;

@TestScreen(group = "scene2D.widgets.touchpads")
public class STryGdxTouchPadSkinUI extends ScreenTry {

    public STryGdxTouchPadSkinUI(FastTesterMain main) {
        super(main);
        init();
    }

    @Override
    public String getTestExplication() {
        return "Test TouchPad d'un skin";
    }

    public void init() {
        Touchpad touchpad = new Touchpad(500, skin);
        touchpad.setSize(Gdx.graphics.getWidth() / 4, Gdx.graphics.getWidth() / 4);
        StagePlacementUtils.placeCenter(touchpad,
                new Vector2(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2));
        nzStage.addActor(touchpad);
    }

    @Override
    public void renderTestScreen(float dt) {

    }

    @Override
    public void disposeTestScreen() {

    }

}
