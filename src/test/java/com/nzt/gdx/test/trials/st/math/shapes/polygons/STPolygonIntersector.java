package com.nzt.gdx.test.trials.st.math.shapes.polygons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.input.impl.simple.SimpleMvtInputController;
import com.nzt.gdx.test.trials.tester.archi.mains.FastTesterMain;
import com.nzt.gdx.test.trials.tester.archi.screens.TestScreen;
import com.nzt.gdx.test.trials.tester.selector.TestScreenList;

@TestScreenList(group = "math.shapes.polygon")
public class STPolygonIntersector extends TestScreen {
    Polygon p1, p2, result = new Polygon();

    Polygon controlPoly;

    Vector2 velocity = new Vector2();
    boolean rotatePoly = false;

    public STPolygonIntersector(FastTesterMain main) {
        super(main);
        infoMsg("Press T for change body control");
        infoMsg("Press R for rotate");
        float[] vertices = new float[]{0, 0, 0, 100, 50, 200, 200, 300, 25, -50};
        p1 = new Polygon(vertices);

        float[] vertices2 = new float[]{0, 0, 0, 100, 50, 200, 200, 300, 25, -50};
        p2 = new Polygon(vertices2);
        debugMsg("Intersect", false);

        p1.setPosition(-100, 0);
        p2.setPosition(200, 0);
        controlPoly = p1;
        Gdx.input.setInputProcessor(addInputListener());
    }

    private InputProcessor addInputListener() {
        SimpleMvtInputController mvtInputController = new SimpleMvtInputController() {
            final int speed = 15;

            @Override
            public boolean doKeyDown(int keycode) {
                if (keycode == Input.Keys.T)
                    controlPoly = controlPoly == p1 ? p2 : p1;

                if (keycode == Input.Keys.R)
                    rotate(true);
                return super.doKeyDown(keycode);
            }

            @Override
            public boolean doKeyUp(int keycode) {
                if (keycode == Input.Keys.R)
                    rotate(false);
                return super.doKeyUp(keycode);
            }

            public void rotate(boolean pressed) {
                rotatePoly = pressed;
            }

            @Override
            public void up(boolean pressed) {
                velocity.y = pressed ? speed : 0;
            }

            @Override
            public void down(boolean pressed) {
                velocity.y = pressed ? -speed : 0;
            }

            @Override
            public void left(boolean pressed) {
                velocity.x = pressed ? -speed : 0;
            }

            @Override
            public void right(boolean pressed) {
                velocity.x = pressed ? speed : 0;
            }
        };
        return mvtInputController;
    }

    @Override
    public String getTestExplication() {
        return "Test Intersector.intersectPolygons (Polygon p1, Polygon p2, Polygon overlap)";
    }

    @Override
    public void renderTestScreen(float dt) {
        if (rotatePoly)
            controlPoly.rotate(5);
        controlPoly.setPosition(controlPoly.getX() + velocity.x, controlPoly.getY() + velocity.y);

        result = new Polygon();
        boolean intersectPolygons = Intersector.intersectPolygons(p1, p2, result);
        debugMsg("Intersect", intersectPolygons);

        shapeRenderer.begin();
        shapeRenderer.setColor(Color.GREEN);
        shapeRenderer.polygon(p1);
        shapeRenderer.setColor(Color.BLUE);
        shapeRenderer.polygon(p2);
        if (intersectPolygons) {
            shapeRenderer.setColor(Color.RED);
            shapeRenderer.polygon(result);
        }
        shapeRenderer.end();
    }

    @Override
    public void disposeTestScreen() {

    }
}
