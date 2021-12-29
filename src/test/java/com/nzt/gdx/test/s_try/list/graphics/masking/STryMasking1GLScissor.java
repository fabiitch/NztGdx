package com.nzt.gdx.test.s_try.list.graphics.masking;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.nzt.gdx.test.utils.archi.mains.dev.FastTesterMain;
import com.nzt.gdx.test.utils.archi.screens.ScreenTry;
import com.nzt.gdx.test.utils.screen_selector.TestScreen;

/**
 * https://github.com/libgdx/libgdx/wiki/Masking#1-masking-using-glScissor-rectangle
 */
@TestScreen(group = "graphics.masking")
public class STryMasking1GLScissor extends ScreenTry {

    @Override
    public String getTestExplication() {
        return "Masking using glScissor (Rectangle)";
    }

    private ShapeRenderer shapeRenderer;

    public STryMasking1GLScissor(FastTesterMain main) {
        super(main, true);

        /* We can use a SpriteBatch or a ShapeRenderer to draw our masked elements. */
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setAutoShapeType(true);

        /* Increase the OpenGL line thickness for better visualization. */
        Gdx.gl.glLineWidth(2);
    }

    private void drawMasked() {
        /* To activate the scissor test, first enable the GL_SCISSOR_TEST enumerator.
         * Once enabled, pixels outside the scissor box will be discarded. */
        Gdx.gl.glEnable(GL20.GL_SCISSOR_TEST);

        /* To define the scissor box, use this function: */
        Gdx.gl.glScissor(100, 100, 200, 200);
        /* The x and y is the window-space lower-left order of the scissor box,
         * and width and height define the size of the rectangle. */

        /* Draw our circle to be masked, we could also draw sprites with a SpriteBatch. */
        shapeRenderer.set(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.RED);
        shapeRenderer.circle(100, 100, 100);

        /* Remember to flush before changing GL states again. */
        shapeRenderer.flush();

        /* Deactivate the scissor test before continuing with further rendering operations. */
        Gdx.gl.glDisable(GL20.GL_SCISSOR_TEST);
    }

    private void drawContours() {
        shapeRenderer.set(ShapeRenderer.ShapeType.Line);

        /* Draw the circle's contour for comparison. */
        shapeRenderer.setColor(Color.GREEN);
        shapeRenderer.circle(100, 100, 100);

        /* Draw the clipped area contour for comparison. */
        shapeRenderer.setColor(Color.CYAN);
        shapeRenderer.rect(100, 100, 200, 200);
    }


    @Override
    public void renderTestScreen(float dt) {
        shapeRenderer.begin();

        drawMasked();
        drawContours();

        shapeRenderer.end();
    }

    @Override
    public void disposeTestScreen() {
        shapeRenderer.dispose();
    }
}
