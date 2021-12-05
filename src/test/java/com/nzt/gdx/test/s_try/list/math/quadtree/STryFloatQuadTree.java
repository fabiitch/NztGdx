package com.nzt.gdx.test.s_try.list.math.quadtree;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.FloatArray;
import com.badlogic.gdx.utils.QuadTreeFloat;
import com.nzt.gdx.test.utils.archi.mains.mains.FastTesterMain;
import com.nzt.gdx.test.utils.archi.screens.ScreenTry;
import com.nzt.gdx.test.utils.screen_selector.TestScreen;

@TestScreen(group = "math.quadtree")
public class STryFloatQuadTree extends ScreenTry {
    QuadTreeFloat q = new QuadTreeFloat();
    FloatArray results = new FloatArray(false, 16);

    public STryFloatQuadTree(FastTesterMain main) {
        super(main);
        q.setBounds(10, 10, 400, 400);
        for (int i = 0; i < 100; i++) {
            float x = MathUtils.random(10, 400);
            float y = MathUtils.random(10, 400);
            q.add(x + y * 410, x, y);
        }
        for (int i = 0; i < q.maxDepth; i++)
            q.add(100 + 100 * 410, 100, 100);
    }

    @Override
    public String getTestExplication() {
        return "QuadTree from Gdx tests project";
    }

    @Override
    public void renderTestScreen(float dt) {
        float radius = 50, x = Gdx.input.getX(), y = Gdx.graphics.getHeight() - Gdx.input.getY();
        results.clear();
        q.query(x, y, radius, results);

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        draw(q);
        shapeRenderer.setColor(Color.GREEN);
        shapeRenderer.circle(x, y, radius, 64);
        for (int i = 0, n = results.size; i < n; i += 4) {
            float value = results.get(i);
            float valueX = value % 410;
            float valueY = value / 410;
            shapeRenderer.circle(valueX, valueY, 10);
        }
        shapeRenderer.end();
    }

    void draw(QuadTreeFloat q) {
        shapeRenderer.setColor(Color.WHITE);
        shapeRenderer.rect(q.x, q.y, q.width, q.height);
        if (q.values != null) {
            shapeRenderer.setColor(Color.RED);
            for (int i = 1, n = q.count; i < n; i += 3)
                shapeRenderer.x(q.values[i], q.values[i + 1], 7);
        }
        if (q.nw != null) draw(q.nw);
        if (q.sw != null) draw(q.sw);
        if (q.ne != null) draw(q.ne);
        if (q.se != null) draw(q.se);
    }

    @Override
    public void disposeTestScreen() {

    }
}
