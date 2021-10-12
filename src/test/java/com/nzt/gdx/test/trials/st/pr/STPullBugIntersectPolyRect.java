package com.nzt.gdx.test.trials.st.pr;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.FloatArray;
import com.nzt.gdx.debug.hud.core.HudDebug;
import com.nzt.gdx.input.impl.simple.SimpleClickInputHandler;
import com.nzt.gdx.test.trials.tester.archi.mains.FastTesterMain;
import com.nzt.gdx.test.trials.tester.archi.screens.TestScreen;
import com.nzt.gdx.test.trials.tester.selector.TestScreenList;

import java.security.Key;

@TestScreenList(group = "pullrequest")
public class STPullBugIntersectPolyRect extends TestScreen {
    float[] vertices1 = new float[]{-50, 0, 50, 0, 50, 50, -50, 50};
    float[] vertices2 = new float[]{-10, -100, 10, -100, 10, 100, -10, 100};
    Polygon poly1 = new Polygon(vertices1);
    Polygon poly2 = new Polygon(vertices2);

    public STPullBugIntersectPolyRect(FastTesterMain main) {
        super(main);
        HudDebug.addBotLeft("Intersector.intersectPolygons (Polygon p1, Polygon p2, Polygon overlap)", false);
        HudDebug.addBotLeft("Intersector.intersectPolygons (FloatArray polygon1, FloatArray polygon2)", false);
        HudDebug.addBotLeft("Intersector.intersectPolygonEdges (FloatArray polygon1, FloatArray polygon2)", false);
        poly1.setPosition(200, 200);
        poly2.setPosition(200, 200);


        HudDebug.addTopRight("Poly1 rotation", 0);
        HudDebug.addTopRight("Poly2 rotation", 0);

        infoMsg("B/N => rotate polys");
        infoMsg("Right/Left click => move polys");
        Gdx.input.setInputProcessor(addInputHandler());
    }

    public InputProcessor addInputHandler() {
        SimpleClickInputHandler inputHandler = new SimpleClickInputHandler() {
            @Override
            public boolean click(int screenX, int screenY, int pointer, int button) {
                Vector2 clickPos = getClickPos(screenX, screenY);
                if (button == Input.Buttons.LEFT) {
                    poly1.setPosition(clickPos.x, clickPos.y);
                } else if (button == Input.Buttons.RIGHT) {
                    poly2.setPosition(clickPos.x, clickPos.y);
                }
                return false;
            }
        };
        return inputHandler;
    }

    @Override
    public String getTestExplication() {
        return "Test intersect two Polygon rectangle";
    }

    @Override
    public void renderTestScreen(float dt) {

        if (Gdx.input.isKeyPressed(Input.Keys.B)) {
            poly1.rotate(5);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.N)) {
            poly2.rotate(5);
        }

        HudDebug.update("Poly1 rotation", poly1.getRotation());
        HudDebug.update("Poly2 rotation", poly2.getRotation());

        shapeRenderer.begin();
        shapeRenderer.set(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(Color.RED);
        shapeRenderer.polygon(poly1);
        shapeRenderer.setColor(Color.BLUE);
        shapeRenderer.polygon(poly2);
        shapeRenderer.end();

        HudDebug.update("Intersector.intersectPolygons (Polygon p1, Polygon p2, Polygon overlap)",
                Intersector.intersectPolygons(poly1, poly2, null));

        HudDebug.update("Intersector.intersectPolygons (FloatArray polygon1, FloatArray polygon2)",
                Intersector.intersectPolygons(new FloatArray(poly1.getTransformedVertices()), new FloatArray(poly2.getTransformedVertices())));

        HudDebug.update("Intersector.intersectPolygonEdges (FloatArray polygon1, FloatArray polygon2)",
                Intersector.intersectPolygonEdges(new FloatArray(poly1.getTransformedVertices()), new FloatArray(poly2.getTransformedVertices())));
    }

    @Override
    public void disposeTestScreen() {

    }
}
