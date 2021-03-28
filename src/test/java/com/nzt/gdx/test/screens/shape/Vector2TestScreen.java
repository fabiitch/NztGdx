package com.nzt.gdx.test.screens.shape;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.math.AngleUtils;
import com.nzt.gdx.test.tester.TestScreen;
import com.nzt.gdx.test.tester.archi.main.FastTesterMain;
import com.nzt.gdx.test.tester.archi.screen.SimpleTestScreen;

@TestScreen(groupName = "shape")
public class Vector2TestScreen extends SimpleTestScreen {

    Texture tt = new Texture("badlogic.jpg");
    Vector2 oldDir;
    Vector2 newDir;
    Vector2 result;

    public Vector2TestScreen(FastTesterMain main) {
        super(main);

    }

    @Override
    public void doShow() {
        oldDir = new Vector2(1, 0);
        newDir = new Vector2(1, -0.1f).nor();
        float diffAngle = AngleUtils.distanceSigned(newDir, oldDir);

        System.out.println(diffAngle);
        result = new Vector2(oldDir).rotateDeg(diffAngle);
    }

    Vector2 middle = new Vector2(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);

    private Vector2 getV(Vector2 v) {
        return v.cpy().nor().scl(150).add(middle);
    }

    private void draw(Vector2 v, Color color) {
        nzShapeRenderer.setColor(color);
        nzShapeRenderer.line(middle, getV(v));
    }

    @Override
    protected void renderScreen(float dt) {
        nzShapeRenderer.begin();
        draw(oldDir, Color.GREEN);
        draw(newDir, Color.RED);
//        draw(result, Color.YELLOW);
        nzShapeRenderer.end();
    }

}