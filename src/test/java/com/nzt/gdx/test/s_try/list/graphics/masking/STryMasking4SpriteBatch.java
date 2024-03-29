package com.nzt.gdx.test.s_try.list.graphics.masking;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.nzt.gdx.test.utils.archi.mains.dev.FastTesterMain;
import com.nzt.gdx.test.utils.archi.screens.ScreenTry;
import com.nzt.gdx.test.utils.screen_selector.TestScreen;

/**
 * https://github.com/libgdx/libgdx/wiki/Masking#4-masking-using-the-spritebatch-any-shape
 */
@TestScreen(group = "graphics.masking")
public class STryMasking4SpriteBatch extends ScreenTry {

    @Override
    public String getTestExplication() {
        return "Masking using the SpriteBatch";
    }


    /* Some attributes we're going to need. */
    private SpriteBatch spriteBatch;
    private Sprite mask, maskedSprite, alphaInvertedMaskedSprite;

    public STryMasking4SpriteBatch(FastTesterMain main) {
        super(main, true);
        spriteBatch = new SpriteBatch();

        /* Load the mask containing the alpha information. */
        mask = new Sprite(new Texture("graphics/masking/4/mask.png"));

        /* Load the sprite which will be masked. */
        maskedSprite = new Sprite(new Texture("graphics/masking/4/sprite.png"));
        maskedSprite.setColor(Color.RED);

        /* The technique requires us to provide the inverted alpha version of the sprite we want to mask. */
        alphaInvertedMaskedSprite = new Sprite(new Texture("graphics/masking/4/alphaInvertedSprite.png"));
    }

    private void drawMasks() {
        /* Disable RGB color writing, enable alpha writing to the frame buffer. */
        Gdx.gl.glColorMask(false, false, false, true);

        /* Change the blending function for our alpha map. */
        spriteBatch.setBlendFunction(Gdx.graphics.getGL20().GL_ONE, GL20.GL_ZERO);

        /* Draw alpha masks. */
        mask.draw(spriteBatch);

        /* This blending function makes it so we subtract instead of adding to the alpha map. */
        spriteBatch.setBlendFunction(GL20.GL_ZERO, GL20.GL_ONE_MINUS_SRC_ALPHA);

        /* Remove the masked sprite's inverse alpha from the map. */
        alphaInvertedMaskedSprite.draw(spriteBatch);

        /* Flush the batch to the GPU. */
        spriteBatch.flush();
    }

    private void drawMasked() {
        /* Now that the buffer has our alpha, we simply draw the sprite with the mask applied. */
        Gdx.gl.glColorMask(true, true, true, true);

        /* Change the blending function so the rendered pixels alpha blend with our alpha map. */
        spriteBatch.setBlendFunction(GL20.GL_DST_ALPHA, GL20.GL_ONE_MINUS_DST_ALPHA);

        /* Draw our sprite to be masked. */
        maskedSprite.draw(spriteBatch);

        /* Remember to flush before changing GL states again. */
        spriteBatch.flush();
    }

    private void drawOriginals() {
        /* Switch to the default blend function */
        spriteBatch.setBlendFunction(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);

        /* Draw the source images separately */
        spriteBatch.draw(mask, 0, 256);
        spriteBatch.draw(maskedSprite, 256, 256);
        spriteBatch.draw(alphaInvertedMaskedSprite, 512, 256);
    }


    @Override
    public void renderTestScreen(float dt) {
        ScreenUtils.clear(Color.BLACK);

        spriteBatch.begin();

        drawMasks();
        drawMasked();
        drawOriginals();

        spriteBatch.end();
    }

    @Override
    public void disposeTestScreen() {
        spriteBatch.dispose();
        mask.getTexture().dispose();
        maskedSprite.getTexture().dispose();
        alphaInvertedMaskedSprite.getTexture().dispose();

    }
}
