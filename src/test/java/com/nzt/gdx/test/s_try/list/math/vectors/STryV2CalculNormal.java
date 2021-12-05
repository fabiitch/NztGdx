package com.nzt.gdx.test.s_try.list.math.vectors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.input.impl.simple.SimpleClickInputHandler;
import com.nzt.gdx.math.vectors.V2;
import com.nzt.gdx.test.utils.archi.mains.mains.FastTesterMain;
import com.nzt.gdx.test.utils.archi.screens.ScreenTry;
import com.nzt.gdx.test.utils.screen_selector.TestScreen;
import com.nzt.gdx.utils.GdxUtils;

@TestScreen(group = "math.vector2")
public class STryV2CalculNormal extends ScreenTry {

    private final Vector2 vector2 = new Vector2(150, 0);
    private final Vector2 tangent = new Vector2(50, 0);
    private final Vector2 middle;


    private final Vector2 posA = new Vector2(0, 0);
    private final Vector2 posB = new Vector2(0, 0);
    private final Vector2 middleAB = new Vector2();
    private final Vector2 normalAB = new Vector2(150, 0);
    private boolean definePosA = true;

    public STryV2CalculNormal(FastTesterMain main) {
        super(main);
        infoMsg("RED", "Vector");
        infoMsg("Blue", "Tangent");
        middle = new Vector2(GdxUtils.getScreenCenterX(), GdxUtils.getScreenCenterY());

        infoMsg("Click to trace Vector");

        SimpleClickInputHandler inputHandler = new SimpleClickInputHandler() {
            @Override
            public boolean click(int screenX, int screenY, int pointer, int button) {
                if (definePosA)
                    posA.set(screenX, Gdx.graphics.getHeight() - screenY);
                else {
                    posB.set(screenX, Gdx.graphics.getHeight() - screenY);
                    V2.getNormal(V2.directionTo(posA, posB, normalAB), normalAB);
                    V2.middle(posA, posB, middleAB);
                }
                definePosA = !definePosA;
                return false;
            }
        };
        Gdx.input.setInputProcessor(inputHandler);
    }

    @Override
    public String getTestExplication() {
        return "Calcul tangent of vector";
    }

    @Override
    public void renderTestScreen(float dt) {
        vector2.rotateDeg(1);
        V2.getNormal(vector2, tangent);

        shapeRenderer.begin();
        shapeRenderer.set(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(Color.RED);
        shapeRenderer.line(middle.cpy().add(vector2), middle.cpy().sub(vector2));
        shapeRenderer.setColor(Color.BLUE);
        shapeRenderer.line(middle, middle.cpy().add(tangent));

        shapeRenderer.setColor(Color.PURPLE);
        if (!definePosA) {
            shapeRenderer.circle(posA, 5);
        } else {
            shapeRenderer.line(posA, posB);
            shapeRenderer.setColor(Color.GREEN);
            shapeRenderer.line(middleAB, middleAB.cpy().add(normalAB.setLength(100)));
        }
        shapeRenderer.end();
    }

    @Override
    public void disposeTestScreen() {

    }
}
