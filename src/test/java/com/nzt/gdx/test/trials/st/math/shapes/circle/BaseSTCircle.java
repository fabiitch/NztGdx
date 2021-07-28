package com.nzt.gdx.test.trials.st.math.shapes.circle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.math.shapes.utils.CircleUtils;
import com.nzt.gdx.test.trials.tester.archi.main.FastTesterMain;
import com.nzt.gdx.test.trials.tester.selector.TestScreenList;
import com.nzt.gdx.utils.GdxUtils;

@TestScreenList(group = "math.shapes.circle")
abstract class BaseSTCircle extends com.nzt.gdx.test.trials.tester.archi.screens.TestScreen {
    Circle circle;
    Vector2 touch = new Vector2();//where userTouch screen
    Vector2 circleCenter = new Vector2();

    Vector2 ray = new Vector2(); //ray between click and center
    Vector2 tangent = new Vector2();
    Vector2 posOnCircle = new Vector2();


    public BaseSTCircle(FastTesterMain main) {
        super(main);
        infoMsg("Click on screen");
        circle = new Circle(GdxUtils.getScreenCenterX(), GdxUtils.getScreenCenterY(), 100);
        CircleUtils.getCenter(circle, circleCenter);
        Gdx.input.setInputProcessor(inputProcessor());
    }

    protected abstract InputProcessor inputProcessor();

    @Override
    public void disposeTestScreen() {

    }
}
