package com.nzt.gdx.test.s_try.list.graphics.masking;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.nzt.gdx.test.utils.archi.mains.mains.FastTesterMain;
import com.nzt.gdx.test.utils.archi.screens.ScreenTry;
import com.nzt.gdx.test.utils.screen_selector.TestScreen;

import static com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Filled;

/**
 * https://github.com/libgdx/libgdx/wiki/Masking#8-masking-using-the-framebuffer-tinting
 */
@TestScreen(group = "graphics.masking")
public class STryMasking8FrameBufferTinting extends ScreenTry {
    @Override
    public String getTestExplication() {
        return "Masking using the FrameBuffer (Tinting)";
    }
    private ShapeRenderer shapeRenderer;
    private SpriteBatch spriteBatch;
    private BitmapFont menuItemFont;
    private FrameBuffer frameBuffer;
    private float textWidth, textHeight, textX, textY;
    public STryMasking8FrameBufferTinting(FastTesterMain main) {
        super(main, true);

        /**
         * Step 1 - Preparations
         */
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setAutoShapeType(true);

        spriteBatch = new SpriteBatch();

        menuItemFont = new BitmapFont();
        menuItemFont.getData().setScale(6f);

        int screenWidth = Gdx.graphics.getWidth();
        int screenHeight = Gdx.graphics.getHeight();

        GlyphLayout glyphLayout = new GlyphLayout();
        glyphLayout.setText(menuItemFont, "ONE PLAYER");
        textWidth = glyphLayout.width;
        textHeight = glyphLayout.height;
        textX = screenWidth / 2f - textWidth / 2f;
        textY = screenHeight / 2f + textHeight / 2f;

        frameBuffer = new FrameBuffer(Pixmap.Format.RGBA8888, screenWidth, screenHeight, false);
    }
    /**
     * Step 2 - Drawing the mask and masked elements
     */
    private void draw() {
        spriteBatch.begin();
        menuItemFont.draw(spriteBatch, "ONE PLAYER", textX, textY);
        spriteBatch.end();

        Gdx.gl.glEnable(GL20.GL_BLEND);

        Gdx.gl.glBlendFunc(GL20.GL_DST_COLOR, GL20.GL_ZERO);

        shapeRenderer.begin();
        shapeRenderer.set(Filled);
        shapeRenderer.rect(textX - 10, textY + 10, textWidth + 20, -(textHeight + 20),
                Color.LIME, Color.LIME, Color.BLACK, Color.BLACK);
        shapeRenderer.end();

        Gdx.gl.glDisable(GL20.GL_BLEND);
    }

    @Override
    public void renderTestScreen(float dt) {
        ScreenUtils.clear(Color.RED);

        frameBuffer.bind();
        draw();
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
        spriteBatch.dispose();
        menuItemFont.dispose();
        frameBuffer.dispose();
    }
}
