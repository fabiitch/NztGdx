package com.nzt.gdx.test.trials.st.math.quadtree;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.FloatArray;
import com.badlogic.gdx.utils.QuadTreeFloat;
import com.nzt.gdx.test.trials.tester.archi.mains.FastTesterMain;
import com.nzt.gdx.test.trials.tester.archi.screens.TestScreen;
import com.nzt.gdx.test.trials.tester.selector.TestScreenList;

@TestScreenList(group = "math.quadtree")
public class STFloatQuadTreeNearest extends TestScreen {
    QuadTreeFloat q = new QuadTreeFloat();
    FloatArray points = new FloatArray(100 * 2);
    FloatArray results = new FloatArray(false, 16);

    public STFloatQuadTreeNearest(FastTesterMain main) {
        super(main);
        q.setBounds(10, 10, 400, 400);
        for (int i = 0; i < 30; i++) {
            float x = MathUtils.random(10, 400);
            float y = MathUtils.random(10, 400);
            points.add(x, y);
            q.add(i, x, y);
        }
    }

    @Override
    public String getTestExplication() {
        return "QuadTreeNearest test from Gdx tests project";
    }

    @Override
    public void renderTestScreen(float dt) {
        float x = Gdx.input.getX(), y = Gdx.graphics.getHeight() - Gdx.input.getY();
        results.clear();
        boolean found = q.nearest(x, y, results);

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        draw(q);
        shapeRenderer.setColor(Color.GREEN);
        if (found) {
            float radius = (float) Math.sqrt(results.get(QuadTreeFloat.DISTSQR));
            shapeRenderer.circle(x, y, radius);
            float foundX = results.get(QuadTreeFloat.X), foundY = results.get(QuadTreeFloat.Y);
            shapeRenderer.circle(foundX, foundY, 10);
        }
        shapeRenderer.end();
    }

    void draw(QuadTreeFloat q) {
        shapeRenderer.setColor(Color.WHITE);
        shapeRenderer.rect(q.x, q.y, q.width, q.height);
        if (q.values != null) {
            for (int i = 0, n = q.count; i < n; i += 3) {
                shapeRenderer.setColor(!results.isEmpty() && q.values[i] == results.get(QuadTreeFloat.VALUE) ? Color.YELLOW : Color.RED);
                shapeRenderer.x(q.values[i + 1], q.values[i + 2], 7);
            }
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
