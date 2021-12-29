package com.nzt.gdx.test.s_try.list.math.shapes.segment;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.input.impl.simple.SimpleClickInputHandler;
import com.nzt.gdx.math.vectors.V2;
import com.nzt.gdx.test.utils.archi.mains.dev.FastTesterMain;

public class STrySegmentNormal extends BaseSTrySegment {

    Vector2 normal = new Vector2();
    Vector2 touch = new Vector2();
    Vector2 dirToMiddle = new Vector2();
    Vector2 middleSeg = new Vector2();

    public STrySegmentNormal(FastTesterMain main) {
        super(main);
        middleSeg = segment.getMiddle(middleSeg);

        SimpleClickInputHandler clickInputHandler = new SimpleClickInputHandler() {
            @Override
            public boolean click(int screenX, int screenY, int pointer, int button) {
                touch.set(screenX, Gdx.graphics.getHeight() - screenY);

                dirToMiddle = V2.directionTo(touch, middleSeg, dirToMiddle);

                normal = segment.getNormal(touch, normal);
                return false;
            }
        };
        Gdx.input.setInputProcessor(clickInputHandler);
    }

    @Override
    public String getTestExplication() {
        return "Calcul normal between segment and Vector Dir";
    }

    @Override
    public void renderTestScreen(float dt) {
        shapeRenderer.begin();
        shapeRenderer.setColor(Color.RED);
        shapeRenderer.segment(segment);

        shapeRenderer.setColor(Color.GREEN);
        shapeRenderer.circle(middleSeg, 5);

        shapeRenderer.setColor(Color.BLUE);
        shapeRenderer.circle(touch, 5);
        shapeRenderer.line(touch, middleSeg);

        shapeRenderer.setColor(Color.CYAN);
        shapeRenderer.line(middleSeg, middleSeg.cpy().add(normal.setLength(300)));
        shapeRenderer.end();
    }
}
