package com.nzt.gdx.test.s_try.list.math.shapes.circle;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Rectangle;
import com.nzt.gdx.input.impl.simple.SimpleClickInputHandler;
import com.nzt.gdx.math.shapes.utils.CircleUtils;
import com.nzt.gdx.test.utils.archi.mains.dev.FastTesterMain;

public class STryCircleRectBounds extends BaseSTryCircle {

    Rectangle rectBounds = new Rectangle();

    public STryCircleRectBounds(FastTesterMain main) {
        super(main);
    }

    @Override
    protected InputProcessor inputProcessor() {
        return new SimpleClickInputHandler() {

            @Override
            public boolean click(int screenX, int screenY, int pointer, int button) {
                circle.setPosition(getClickPos(screenX, screenY));
                return false;
            }
        };
    }

    @Override
    public String getTestExplication() {
        return "Test CircleUtils.getRectBounds";
    }

    @Override
    public void renderTestScreen(float dt) {
        CircleUtils.getRectBounds(circle, rectBounds);
        shapeRenderer.begin();
        shapeRenderer.setColor(Color.GREEN);
        shapeRenderer.circle(circle);
        shapeRenderer.setColor(Color.RED);
        shapeRenderer.rect(rectBounds);
        shapeRenderer.end();
    }
}
