package com.nzt.gdx.test.trials.st.math.shapes.circle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.input.impl.simple.SimpleClickInputHandler;
import com.nzt.gdx.math.AngleUtils;
import com.nzt.gdx.math.intersectors.IntersectorCircle;
import com.nzt.gdx.math.shapes.Segment;
import com.nzt.gdx.math.shapes.utils.CircleUtils;
import com.nzt.gdx.math.vectors.V2;
import com.nzt.gdx.test.trials.tester.archi.main.FastTesterMain;

public class STCircleReflexionRay extends BaseSTCircle {
    Vector2 touch2 = new Vector2();
    Segment segment = new Segment();
    boolean defineTouch1 = true;

    private float angleReflexion;

    public STCircleReflexionRay(FastTesterMain main) {
        super(main);
        infoMsg("Click for define first and second point of segment");
        infoMsg("cyan ", "segment");
        infoMsg("green ", "tangent");
        infoMsg("purple ", "reflexion");
    }

    @Override
    public String getTestExplication() {
        return "Calcul reflexion ray on circle";
    }

    protected InputProcessor inputProcessor() {
        return new SimpleClickInputHandler() {
            @Override
            public boolean click(int screenX, int screenY, int pointer, int button) {
                if (defineTouch1) {
                    touch.set(screenX, Gdx.graphics.getHeight() - screenY);
                } else {
                    touch2.set(screenX, Gdx.graphics.getHeight() - screenY);
                    calcul();
                }
                defineTouch1 = !defineTouch1;
                return false;
            }
        };
    }


    private void calcul() {
        segment.set(touch, touch2);
        IntersectorCircle.firstSegmentIntersection(circle, segment, posOnCircle.setZero());
        if (!posOnCircle.isZero()) {
            touch2.set(posOnCircle);
            V2.directionTo(circleCenter, posOnCircle, ray);
            CircleUtils.getTangentDeg(circle, ray.angleDeg(), tangent);
            angleReflexion = AngleUtils.angleReflexionDeg(tangent, ray);
        }

    }

    @Override
    public void renderTestScreen(float dt) {
        shapeRenderer.begin();
        shapeRenderer.setColor(Color.RED);
        shapeRenderer.circle(circle);
        shapeRenderer.setColor(Color.CYAN);
        if (!defineTouch1) {
            shapeRenderer.circle(touch, 5);
        } else {
            shapeRenderer.line(touch, touch2);
        }
        if (!posOnCircle.isZero()) {
            shapeRenderer.setColor(Color.GREEN);
            shapeRenderer.line(posOnCircle.cpy().add(tangent.setLength(100)), posOnCircle.cpy().sub(tangent.setLength(100)));

            shapeRenderer.setColor(Color.PURPLE);
            float angleIncidence = AngleUtils.reflexionToIncidence(angleReflexion);
            Vector2 vector2 = new Vector2(1, 0).setAngleDeg(angleReflexion).setLength(100);
            shapeRenderer.line(posOnCircle, posOnCircle.cpy().add(vector2));

        }
        shapeRenderer.end();
    }
}
