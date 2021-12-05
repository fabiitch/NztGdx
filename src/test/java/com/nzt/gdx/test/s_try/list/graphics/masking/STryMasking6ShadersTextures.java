package com.nzt.gdx.test.s_try.list.graphics.masking;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.nzt.gdx.test.utils.archi.mains.mains.FastTesterMain;
import com.nzt.gdx.test.utils.archi.screens.ScreenTry;
import com.nzt.gdx.test.utils.screen_selector.TestScreen;

/**
 * https://github.com/libgdx/libgdx/wiki/Masking#6-masking-using-shaders-and-textures-any-shape
 */
@TestScreen(group = "graphics.masking")
public class STryMasking6ShadersTextures extends ScreenTry {
    @Override
    public String getTestExplication() {
        return "Masking using Shaders and Textures (Any shape)";
    }


    private final int size = 300;
    private Texture texture;
    private SpriteBatch spriteBatch1, spriteBatch2;
    private ShapeRenderer shapeRenderer;

    private Pixmap pixmapMask;
    private Texture pixmapTex;
    private ShaderProgram shaderProgram;

    public STryMasking6ShadersTextures(FastTesterMain main) {
        super(main, true);

        //Step 1 - Preparations
        /* We'll be using a pixmap to define the mask this time. */
        defineMask();

        /* Some regular textures to draw on the screen. */
        texture = new Texture("graphics/masking/6/weirdShape.png");
        texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        setupShader();

        /* An unmodified SpriteBatch to draw the original image as reference
         * we could also change the shader of spriteBatch1 back to the default. */
        spriteBatch2 = new SpriteBatch();

        /* Construct a simple ShapeRenderer to draw reference contours. */
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setAutoShapeType(true);
        Gdx.gl.glLineWidth(2);
    }

    /**
     * Step 2 - Defining our mask
     */
    private void defineMask() {
        /* The fragment shader simply multiplies the fragment's usual alpha with
         * our mask alpha, since we only care about the alpha channel, the Alpha
         * Pixmap format is just what we need. */
         pixmapMask = new Pixmap(size, size, Pixmap.Format.Alpha);
        /* Pixmap blending can result in some funky looking lines when
         * drawing. You may need to disable it. */
        pixmapMask.setBlending(Pixmap.Blending.None);

        /* The default color of a newly created Pixmap has an alpha value of 0
         * play with different alpha values for different levels of transparency. */
        pixmapMask.setColor(0, 0, 0, 1);

        /* This setting will let us see some portions of the masked image. */
        pixmapMask.fillCircle(size / 2, size / 4, size / 4);
        pixmapMask.setColor(0, 0, 0, 0.25f);
        pixmapMask.fillRectangle(size / 4, size / 2, size / 2, size / 2);

        /* Create a Texture based on the pixmapMask.
         * IMPORTANT: How we create the texture doesn't matter, this technique
         * also allows, for example, to create it out of any supported format image */
         pixmapTex = new Texture(pixmapMask);

        /* Bind the mask texture to TEXTURE<N> (TEXTURE1 for our purposes),
         * which also sets the currently active texture unit. */
        pixmapTex.bind(1);

        /* However SpriteBatch will auto-bind to the current active texture,
         * so we must now reset it to TEXTURE0 or else our mask will be
         * overwritten. */
        Gdx.gl.glActiveTexture(GL20.GL_TEXTURE0);
    }

    /**
     * Step 3 - Setting up the shader
     */
    private void setupShader() {
        /* It's nicer to keep shader programs as text files in the assets
         * directory rather than dealing with horrid Java string formatting. */
        FileHandle vertexShader = Gdx.files.internal("graphics/masking/6/vertex.glsl");
        FileHandle fragmentShader = Gdx.files.internal("graphics/masking/6/fragment.glsl");

        /* Bonus: you can set `pedantic = false` while tinkering with your
         * shaders. This will stop it from crashing if you have unused variables
         * and so on. */
        ShaderProgram.pedantic = false;

        /* Construct our shader program. Spit out a log and quit if the shaders
         * fail to compile. */
        shaderProgram = new ShaderProgram(vertexShader, fragmentShader);
        if (!shaderProgram.isCompiled()) {
            Gdx.app.log("Shader", shaderProgram.getLog());
            Gdx.app.exit();
        }

        /* Tell our shader that u_texture will be in the TEXTURE0 spot and
         * u_mask will be in the TEXTURE1 spot. We can set these now since
         * they'll never change; we don't have to send them every render frame. */
        shaderProgram.bind();
        shaderProgram.setUniformi("u_texture", 0);
        shaderProgram.setUniformi("u_mask", 1);

        /* Construct a simple SpriteBatch using our shader program. */
        spriteBatch1 = new SpriteBatch();
        spriteBatch1.setShader(shaderProgram);
    }

    /**
     * Step 4 - Drawing the contours of the mask for debugging purposes
     */
    private void drawContours() {
        /* Draw the contour of the masks. */
        shapeRenderer.setColor(Color.CYAN);
        shapeRenderer.rect(size / 4f, 0f, size / 2f, size / 2f);
        shapeRenderer.circle(size / 2f, size * 0.75f, size / 4f);
    }

    @Override
    public void renderTestScreen(float dt) {
        ScreenUtils.clear(Color.BLACK);

        /* Draw our masked image. */
        spriteBatch1.begin();
        spriteBatch1.setColor(Color.RED);
        spriteBatch1.draw(texture, 0, 0, size, size);
        spriteBatch1.end();

        /* Draw the original image unmasked for comparison. */
        spriteBatch2.begin();
        spriteBatch2.draw(texture, 0, size, size, size);
        spriteBatch2.end();

        shapeRenderer.begin();
        drawContours();
        shapeRenderer.end();
    }

    @Override
    public void disposeTestScreen() {
        shapeRenderer.dispose();
        spriteBatch1.dispose();
        spriteBatch2.dispose();
        texture.dispose();

        pixmapMask.dispose();
        pixmapTex.dispose();
        shaderProgram.dispose();
    }
}
