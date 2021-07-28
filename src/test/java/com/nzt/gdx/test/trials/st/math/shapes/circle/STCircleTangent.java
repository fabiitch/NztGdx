package com.nzt.gdx.test.trials.st.math.shapes.circle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.input.impl.simple.SimpleClickInputHandler;
import com.nzt.gdx.math.shapes.utils.CircleUtils;
import com.nzt.gdx.math.vectors.V2;
import com.nzt.gdx.test.trials.tester.archi.main.FastTesterMain;

/**
 * {@link CircleUtils#getTangentRad(Circle, float, Vector2)}
 */
public class STCircleTangent extends BaseSTCircle {

    public STCircleTangent(FastTesterMain main) {
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
                touch.set(screenX, Gdx.graphics.getHeight() - screenY);
                calculTangent();
                return false;
            }
        };
    }

    protected void calculTangent() {
        V2.directionTo(circleCenter, touch, ray);
        CircleUtils.posWithAngleDeg(circle, ray.angleDeg(), posOnCircle);
        CircleUtils.getTangentDeg(circle, ray.angleDeg(), tangent);
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
