package com.nzt.gdx.test.trials.st.math.shapes.circle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.math.shapes.utils.CircleUtils;
import com.nzt.gdx.test.trials.tester.archi.mains.FastTesterMain;
import com.nzt.gdx.test.trials.tester.archi.screens.TestScreen;
import com.nzt.gdx.test.trials.tester.selector.TestScreenList;
import com.nzt.gdx.utils.GdxUtils;

@TestScreenList(group = "math.shapes.circle")
abstract class BaseSTCircle extends TestScreen {
    protected Circle circle;
    protected Vector2 circleCenter;

    public BaseSTCircle(FastTesterMain main) {
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
