package com.nzt.gdx.tester.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.archi.AbstractMain;
import com.nzt.gdx.math.random.Randoms;
import com.nzt.gdx.screen.BaseScreen;

public class TriangleTestScreen extends BaseScreen {

    Texture tt = new Texture("badlogic.jpg");

    public TriangleTestScreen(AbstractMain main) {
        super(main);
    }

    Vector2 midde = new Vector2(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);

    Vector2 getV(Vector2 v) {
        return v.cpy().nor().scl(150).add(midde);
    }

    void draw(Vector2 v, Color color) {
        shapeRenderer.setColor(color);
        shapeRenderer.line(midde, getV(v));
    }

    @Override
    protected void renderScreen(float dt) {
        shapeRenderer.begin();
        Vector2 v1 = new Vector2(1, 0);
        Vector2 v2 = new Vector2(1, 0).rotateAroundDeg(Vector2.Zero, 90);

        float new_x = (float) (v1.x * Math.cos(180) - v1.y * Math.sin(180));
        float new_y = (float) (v1.x * Math.sin(180) + v1.y * Math.cos(180));
        draw(v1, Color.GREEN);
        draw(v2, Color.RED);
        draw(new Vector2(new_x, new_y), Color.YELLOW);
        shapeRenderer.end();
    }

    @Override
    public void doShow() {
        // TODO Auto-generated method stub

    }

}
