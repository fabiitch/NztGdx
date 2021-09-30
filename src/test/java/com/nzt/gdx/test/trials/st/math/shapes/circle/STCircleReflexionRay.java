package com.nzt.gdx.test.trials.st.math.shapes.circle;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.input.impl.simple.SimpleClickInputHandler;
import com.nzt.gdx.math.AngleUtils;
import com.nzt.gdx.math.intersectors.IntersectorCircle;
import com.nzt.gdx.math.shapes.Segment;
import com.nzt.gdx.math.shapes.utils.CircleUtils;
import com.nzt.gdx.math.vectors.V2;
import com.nzt.gdx.test.trials.tester.archi.mains.FastTesterMain;

public class STCircleReflexionRay extends BaseSTCircle {


    Vector2 rayToCenter = new Vector2(); //rayToCenter between click and center
    Vector2 tangentCircle = new Vector2();
    Vector2 posOnCircle = new Vector2();

    boolean defineTouch1 = true;
    Vector2 touch = new Vector2();//where userTouch screen
    Vector2 touch2 = new Vector2();
    Vector2 dirTouch = new Vector2();

    Segment segment = new Segment();

    private float angleIncidence;
    Vector2 normalTangent = new Vector2();
    Vector2 incidence = new Vector2(1, 0);
    Vector2 reflexion = new Vector2(1, 0);

    public STCircleReflexionRay(FastTesterMain main) {
        super(main);
        infoMsg("Click for define first and second point of segment");
        infoMsg("----------", "---------");
        infoMsg("cyan ", "segment");
        infoMsg("green ", "tangentCircle");
        infoMsg("blue", "normal of tangentCircle");
        infoMsg("yellow ", "incidence");
        infoMsg("purple ", "reflexion");
    }

    @Override
    public String getTestExplication() {
        return "Calcul reflexion rayToCenter on circle";
    }

    protected InputProcessor inputProcessor() {
        return new SimpleClickInputHandler() {
            @Override
            public boolean click(int screenX, int screenY, int pointer, int button) {
                if (defineTouch1) {
                    this.getClickPos(screenX, screenY, touch);
                } else {
                    this.getClickPos(screenX, screenY, touch2);
                    calcul();
                }
                defineTouch1 = !defineTouch1;
                return false;
            }
        };
    }


    private void calcul() {
        segment.set(touch, touch2);
        V2.directionTo(touch, touch2, dirTouch);
        IntersectorCircle.firstSegmentIntersection(circle, segment, posOnCircle.setZero());
        if (!posOnCircle.isZero()) {
            touch2.set(posOnCircle);
            V2.directionTo(circleCenter, posOnCircle, rayToCenter);
            tangentCircle = CircleUtils.getTangent(circle, posOnCircle, tangentCircle);

            normalTangent = CircleUtils.dirFromCenter(circle, posOnCircle, normalTangent);

            angleIncidence = AngleUtils.angleIncidence(tangentCircle, dirTouch);
            incidence.setAngleDeg(angleIncidence);

            float angleReflexion = AngleUtils.incidenceToReflexion(angleIncidence);
            reflexion.setAngleDeg(angleReflexion);
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
            shapeRenderer.line(posOnCircle.cpy().add(tangentCircle.setLength(150)), posOnCircle.cpy().sub(tangentCircle.setLength(150)));

            shapeRenderer.setColor(Color.BLUE);
            shapeRenderer.line(posOnCircle, posOnCircle.cpy().add(normalTangent.setLength(100)));

            shapeRenderer.setColor(Color.PURPLE);
            shapeRenderer.line(posOnCircle, posOnCircle.cpy().add(reflexion.setLength(150)));

            shapeRenderer.setColor(Color.YELLOW);
            shapeRenderer.line(posOnCircle, posOnCircle.cpy().add(incidence.setLength(150)));

        }
        shapeRenderer.end();
    }
}
