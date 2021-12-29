package com.nzt.gdx.test.s_try.list.math.shapes.circle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.math.shapes.utils.CircleUtils;
import com.nzt.gdx.test.utils.archi.mains.dev.FastTesterMain;
import com.nzt.gdx.test.utils.archi.screens.ScreenTry;
import com.nzt.gdx.test.utils.screen_selector.TestScreen;
import com.nzt.gdx.utils.GdxUtils;

@TestScreen(group = "math.shapes.circle")
abstract class BaseSTryCircle extends ScreenTry {
    protected Circle circle;
    protected Vector2 circleCenter;

    public BaseSTryCircle(FastTesterMain main) {
        super(main);
        infoMsg("Click on screen");
        circle = new Circle(GdxUtils.getScreenCenterX(), GdxUtils.getScreenCenterY(), 100);
        circleCenter = CircleUtils.getCenter(circle, new Vector2());
        Gdx.input.setInputProcessor(inputProcessor());
    }

    protected abstract InputProcessor inputProcessor();

    @Override
    public void disposeTestScreen() {

    }
}
