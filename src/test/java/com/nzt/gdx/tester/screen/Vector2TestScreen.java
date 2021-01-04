package com.nzt.gdx.tester.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.archi.AbstractMain;
import com.nzt.gdx.math.AngleUtils;
import com.nzt.gdx.screen.BaseScreen;

public class Vector2TestScreen extends BaseScreen {

    Texture tt = new Texture("badlogic.jpg");
    Vector2 oldDir;
    Vector2 newDir;
    Vector2 result;

    public Vector2TestScreen(AbstractMain main) {
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
        shapeRenderer.setColor(color);
        shapeRenderer.line(middle, getV(v));
    }

    @Override
    protected void renderScreen(float dt) {
        shapeRenderer.begin();
        draw(oldDir, Color.GREEN);
        draw(newDir, Color.RED);
//        draw(result, Color.YELLOW);
        shapeRenderer.end();
    }

}
