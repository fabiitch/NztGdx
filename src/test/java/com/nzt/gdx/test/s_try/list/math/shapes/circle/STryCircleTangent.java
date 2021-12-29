package com.nzt.gdx.test.s_try.list.math.shapes.circle;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.input.impl.simple.SimpleClickInputHandler;
import com.nzt.gdx.math.shapes.utils.CircleUtils;
import com.nzt.gdx.math.vectors.V2;
import com.nzt.gdx.test.utils.archi.mains.dev.FastTesterMain;

/**
 * {@link CircleUtils#getTangentRad(Circle, float, Vector2)}
 */
public class STryCircleTangent extends BaseSTryCircle {
    Vector2 touch = new Vector2();//where userTouch screen

    Vector2 rayToCenter = new Vector2();
    Vector2 tangent = new Vector2();
    Vector2 posOnCircle = new Vector2();


    public STryCircleTangent(FastTesterMain main) {
        super(main);
    }

    @Override
    public String getTestExplication() {
        return "Tangent on Circle";
    }

    protected InputProcessor inputProcessor() {
        return new SimpleClickInputHandler() {
            @Override
            public boolean click(int screenX, int screenY, int pointer, int button) {
                this.getClickPos(screenX, screenY, touch);
                calculTangent();
                return false;
            }
        };
    }

    protected void calculTangent() {
        V2.directionTo(circleCenter, touch, rayToCenter);
        CircleUtils.posWithAngleDeg(circle, rayToCenter.angleDeg(), posOnCircle);
        CircleUtils.getTangentDeg(circle, rayToCenter.angleDeg(), tangent);
    }


    @Override
    public void renderTestScreen(float dt) {
        shapeRenderer.begin();
        shapeRenderer.setColor(Color.RED);
        shapeRenderer.circle(circle);
        shapeRenderer.setColor(Color.CYAN);
        shapeRenderer.line(touch, posOnCircle);
        shapeRenderer.setColor(Color.GREEN);
        shapeRenderer.line(posOnCircle.cpy().add(tangent.setLength(100)), posOnCircle.cpy().sub(tangent.setLength(100)));
        shapeRenderer.end();
    }


}
