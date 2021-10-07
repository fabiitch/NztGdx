package com.nzt.gdx.test.trials.st.graphics.masking;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.nzt.gdx.test.trials.tester.archi.mains.FastTesterMain;
import com.nzt.gdx.test.trials.tester.archi.screens.TestScreen;
import com.nzt.gdx.test.trials.tester.selector.TestScreenList;

/**
 * https://github.com/libgdx/libgdx/wiki/Masking#5-masking-using-pixmaps-any-shape
 */
@TestScreenList(group = "graphics.masking")
public class STMasking5Pixmaps extends TestScreen {
    private ShapeRenderer shapeRenderer;
    private SpriteBatch spriteBatch;
    private Texture masked, original;
    private Pixmap pixmap;
    private final int size = 256;

    public STMasking5Pixmaps(FastTesterMain main) {
        super(main, true);
        infoMsg("https://github.com/libgdx/libgdx/wiki/Masking#5-masking-using-pixmaps-any-shape");


        //Step 1 - Preparations
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setAutoShapeType(true);
        Gdx.gl20.glLineWidth(2);

        /* Needed to render our textures, a ShapeRenderer won't work with this technique. */
        spriteBatch = new SpriteBatch();

        /* The path to the image to mask. */

        FileHandle imagePath = Gdx.files.internal("graphics/masking/weirdShape.png");
        /* Load the pixels of our image into a Pixmap. */
        pixmap = new Pixmap(imagePath);


        /* Have an unaltered version for comparison. */
        original = new Texture(imagePath);

        /* Apply the mask to our Pixmap. */
        pixmap = applyMask(pixmap);

        /* Load the pixel information of the Pixmap into a Texture for drawing. */
        masked = new Texture(pixmap);

    }

    /**
     * Step 2 - Applying the mask
     */
    private Pixmap applyMask(Pixmap source) {
        /* Create a Pixmap to store the mask information, at the end it will
         * contain the result. */
        Pixmap result = new Pixmap(source.getWidth(), source.getHeight(), Pixmap.Format.RGBA8888);

        /* This setting lets us overwrite the pixels' transparency. */
        result.setBlending(Pixmap.Blending.None);

        /* Ignore RGB values unless you want funky results, alpha is for the mask. */
        result.setColor(new Color(1f, 1f, 1f, 1f));

        /* Draw a circle to our mask, any shape is possible since
         * you can draw individual pixels to the Pixmap. */
        result.fillCircle(size / 2, size / 2, size / 2);

        /* Draw a rectangle with half alpha to our mask, this will turn
         * a corner of the original image transparent. */
        result.setColor(1f, 1f, 1f, 0.5f);
        result.fillRectangle(size / 2, size / 2, size / 2, size / 2);

        /* We can also define the mask by loading an image:
         * result = new Pixmap(new FileHandle("image.png")); */

        /* Decide the color of each pixel using the AND bitwise operator. */
        for (int x = 0; x < result.getWidth(); x++) {
            for (int y = 0; y < result.getHeight(); y++) {
                result.drawPixel(x, y, source.getPixel(x, y) & result.getPixel(x, y));
            }
        }

        return result;
    }

    /**
     * Step 3 - Drawing the original and masked images
     */
    private void drawImages() {
        /* Draw the original image in blue first to see transparency taking place. */
        spriteBatch.setColor(Color.BLUE);
        spriteBatch.draw(original, 0, 0, size, size);

        /* Draw the masked image in red on top. */
        spriteBatch.setColor(Color.RED);
        spriteBatch.draw(masked, 0, 0, size, size);
    }

    /**
     * Step 4 - Drawing the contours of the mask for debugging purposes
     */
    private void drawContours() {
        /* Draw the contour of the circle and rectangle used as masks. */
        shapeRenderer.setColor(Color.CYAN);
        shapeRenderer.circle(size / 2f, size / 2f, size / 2f);
        shapeRenderer.rect(size / 2f, 0, size / 2f, size / 2f);
    }

    @Override
    public String getTestExplication() {
        return "Masking using Pixmaps (Any shape)";
    }

    @Override
    public void renderTestScreen(float dt) {
        ScreenUtils.clear(Color.BLACK);

        spriteBatch.begin();
        drawImages();
        spriteBatch.end();

        shapeRenderer.begin();
        drawContours();
        shapeRenderer.end();
    }

    @Override
    public void disposeTestScreen() {
        spriteBatch.dispose();
        shapeRenderer.dispose();
        masked.dispose();
        original.dispose();
        pixmap.dispose();
    }
}
