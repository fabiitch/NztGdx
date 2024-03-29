package com.nzt.gdx.test.s_try.list.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import com.badlogic.gdx.math.Matrix4;
import com.nzt.gdx.test.utils.archi.mains.dev.FastTesterMain;
import com.nzt.gdx.test.utils.archi.screens.ScreenTry;
import com.nzt.gdx.test.utils.screen_selector.TestScreen;

/**
 * https://gist.github.com/thomasleese/e6ab52efd2118adff696
 */
@TestScreen(group = "graphics")
public class STryFrameBuffer extends ScreenTry {
    FrameBuffer fbo;
    TextureRegion texture;
    Texture img;

    public STryFrameBuffer(FastTesterMain main) {
        super(main, true);
        img = new Texture("badlogic.jpg");
        fbo = new FrameBuffer(Pixmap.Format.RGBA8888, img.getWidth(), img.getHeight(), false);

        texture = new TextureRegion(fbo.getColorBufferTexture());
        texture.flip(false, true);

        fbo.begin();
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        Matrix4 matrix = new Matrix4();
        matrix.setToOrtho2D(0, 0, img.getWidth(), img.getHeight());
        spriteBatch.setProjectionMatrix(matrix);

        spriteBatch.begin();
        spriteBatch.draw(img, 0, 0);
        spriteBatch.end();
        fbo.end();
    }

    @Override
    public String getTestExplication() {
        return "FrameBuffer test";
    }

    @Override
    public void renderTestScreen(float dt) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        spriteBatch.begin();
        spriteBatch.draw(texture, 0, 0);
        spriteBatch.end();
    }

    @Override
    public void disposeTestScreen() {
        img.dispose();
        fbo.dispose();
    }
}
