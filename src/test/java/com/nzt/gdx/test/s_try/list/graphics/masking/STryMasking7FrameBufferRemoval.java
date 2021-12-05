package com.nzt.gdx.test.s_try.list.graphics.masking;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.nzt.gdx.test.utils.archi.mains.mains.FastTesterMain;
import com.nzt.gdx.test.utils.archi.screens.ScreenTry;
import com.nzt.gdx.test.utils.screen_selector.TestScreen;

import static com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Filled;
import static com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Line;

/**
 * https://github.com/libgdx/libgdx/wiki/Masking#7-masking-using-the-framebuffer-removal
 */
@TestScreen(group = "graphics.masking")
public class STryMasking7FrameBufferRemoval extends ScreenTry {
    @Override
    public String getTestExplication() {
        return "Masking using the FrameBuffer (Removal)";
    }

    private ShapeRenderer shapeRenderer;
    private FrameBuffer frameBuffer;
    private SpriteBatch spriteBatch;

    public STryMasking7FrameBufferRemoval(FastTesterMain main) {
        super(main, true);
        /**
         * Step 1 - Preparations
         */
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setAutoShapeType(true);
        Gdx.gl20.glLineWidth(2);

        frameBuffer = new FrameBuffer(Pixmap.Format.RGBA8888, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), false);

        spriteBatch = new SpriteBatch();
    }

    /**
     * Step 2 - Drawing the masked elements and the mask elements
     */
    private void drawCircles() {
        shapeRenderer.set(Filled);

        /* An example circle, remember to flush before changing the blending function */
        shapeRenderer.setColor(Color.RED);
        shapeRenderer.circle(200, 200, 100);
        shapeRenderer.flush();

        /* We'll need blending enabled for the technique to work*/
        Gdx.gl.glEnable(GL20.GL_BLEND);

        /* With this blending function, wherever we draw pixels next
         * we will actually remove previously drawn pixels. */
        Gdx.gl.glBlendFuncSeparate(GL20.GL_ZERO, GL20.GL_ZERO, GL20.GL_ONE_MINUS_SRC_ALPHA, GL20.GL_ONE_MINUS_DST_ALPHA);
        shapeRenderer.circle(300, 200, 70);
        shapeRenderer.circle(100, 200, 35);
        shapeRenderer.flush();

        /* Restore defaults. */
        Gdx.gl.glDisable(GL20.GL_BLEND);

        /* The default blend function in case we need standard blending elsewhere.
         * Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA); */
    }

    /**
     * Step 3 - Drawing the contours for debugging purposes
     */
    private void drawContours() {
        shapeRenderer.set(Line);

        /* Contour of the masked circle */
        shapeRenderer.setColor(Color.GREEN);
        shapeRenderer.circle(200, 200, 100);

        /* Contour of the masks */
        shapeRenderer.setColor(Color.CYAN);
        shapeRenderer.circle(300, 200, 70);
        shapeRenderer.circle(100, 200, 35);
    }
    @Override
    public void renderTestScreen(float dt) {
        ScreenUtils.clear(Color.GRAY);

        frameBuffer.bind();
        shapeRenderer.begin();
        drawCircles();
        drawContours();
        shapeRenderer.end();
        frameBuffer.end();

        Texture texture = frameBuffer.getColorBufferTexture();
        Sprite sprite = new Sprite(texture);
        sprite.flip(false, true);

        spriteBatch.begin();
        sprite.draw(spriteBatch);
        spriteBatch.end();
    }

    @Override
    public void disposeTestScreen() {
        shapeRenderer.dispose();
        frameBuffer.dispose();
        spriteBatch.dispose();
    }
}
