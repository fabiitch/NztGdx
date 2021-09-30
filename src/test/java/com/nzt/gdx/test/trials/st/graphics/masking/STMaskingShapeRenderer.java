package com.nzt.gdx.test.trials.st.graphics.masking;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.nzt.gdx.test.trials.tester.archi.mains.FastTesterMain;
import com.nzt.gdx.test.trials.tester.archi.screens.TestScreen;
import com.nzt.gdx.test.trials.tester.selector.TestScreenList;

import static com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Line;

/**
 * https://github.com/libgdx/libgdx/wiki/Masking
 */
@TestScreenList(group = "graphics.masking")
public class STMaskingShapeRenderer extends TestScreen {
    private ShapeRenderer shapeRenderer;

    public STMaskingShapeRenderer(FastTesterMain main) {
        super(main);
        /* We can use a SpriteBatch or a ShapeRenderer to draw our masked elements. */
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setAutoShapeType(true);

        /* Increase the OpenGL line thickness for better visualization. */
        Gdx.gl.glLineWidth(2);
    }

    private void drawMasks() {
        /* Clear our depth buffer info from previous frame. */
        Gdx.gl.glClear(GL20.GL_DEPTH_BUFFER_BIT);

        /* Set the depth function to LESS. */
        Gdx.gl.glDepthFunc(GL20.GL_LESS);

        /* Enable depth writing. */
        Gdx.gl.glEnable(GL20.GL_DEPTH_TEST);

        /* Disable RGBA color writing. */
        Gdx.gl.glColorMask(false, false, false, false);

        /* Render mask elements. */
        shapeRenderer.set(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.circle(100, 200, 100);
        shapeRenderer.triangle(0, 0, 100, 100, 200, 0);
        shapeRenderer.flush();
    }

    private void drawMasked() {
        /* Enable RGBA color writing. */
        Gdx.gl.glColorMask(true, true, true, true);

        /* Set the depth function to LESS. */
        Gdx.gl.glDepthFunc(GL20.GL_EQUAL);

        /* Render masked elements. */
        shapeRenderer.setColor(Color.RED);
        shapeRenderer.circle(100, 100, 100);
        shapeRenderer.flush();
    }

    private void drawContours() {
        /* Disable depth writing. */
        Gdx.gl.glDisable(GL20.GL_DEPTH_TEST);

        shapeRenderer.set(Line);

        /* The circle and triangle masks. */
        shapeRenderer.setColor(Color.CYAN);
        shapeRenderer.circle(100, 200, 100);
        shapeRenderer.triangle(0, 0, 100, 100, 200, 0);

        /* The masked circle. */
        shapeRenderer.setColor(Color.GREEN);
        shapeRenderer.circle(100, 100, 100);
    }

    @Override
    public String getTestExplication() {
        return null;
    }

    @Override
    public void renderTestScreen(float dt) {
        ScreenUtils.clear(Color.BLACK);

        shapeRenderer.begin();

        drawMasks();
        drawMasked();
        drawContours();

        shapeRenderer.end();
    }

    @Override
    public void disposeTestScreen() {
        shapeRenderer.dispose();
    }
}
