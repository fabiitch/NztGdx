package com.nzt.gdx.test.trials.st.graphics.masking;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
import com.badlogic.gdx.utils.ScreenUtils;
import com.nzt.gdx.test.trials.tester.archi.mains.FastTesterMain;
import com.nzt.gdx.test.trials.tester.archi.screens.TestScreen;
import com.nzt.gdx.test.trials.tester.selector.TestScreenList;

/**
 * https://github.com/libgdx/libgdx/wiki/Masking
 */
@TestScreenList(group = "graphics.masking")
public class STMaskingScissorStack extends TestScreen {
    private OrthographicCamera camera;
    private ShapeRenderer shapeRenderer;
    private Rectangle scissors, clipBounds;

    public STMaskingScissorStack(FastTesterMain main) {
        super(main);    /* The ScissorStack needs a camera to transform the clipping rectangles. */
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        /* We can use a SpriteBatch or a ShapeRenderer to draw our masked elements. */
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setAutoShapeType(true);
        shapeRenderer.setProjectionMatrix(camera.combined);

        /* Increase the OpenGL line thickness for better visualization. */
        Gdx.gl.glLineWidth(2);

        /* Some rectangles the ScissorStack needs to perform the clipping, "clipBounds"
         * defines the area where the clipping will happen. */
        scissors = new Rectangle();
        clipBounds = new Rectangle(100, 100, 200, 200);
    }

    private void drawMasked() {
        /* Feed the ScissorStack and store whether it could push the scissors or not. */
        ScissorStack.calculateScissors(camera, shapeRenderer.getTransformMatrix(), clipBounds, scissors);
        boolean pop = ScissorStack.pushScissors(scissors);

        /* Draw the elements to be constrained to an area. */
        shapeRenderer.set(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.RED);
        shapeRenderer.circle(100, 100, 100);
        shapeRenderer.flush();

        /* Safety check for the situations the scissor fails to be pushed to the stack
         * (happens for example when the window is minimized on desktop). */
        if (pop) {
            ScissorStack.popScissors();
        }
    }

    private void drawContours() {
        shapeRenderer.set(ShapeRenderer.ShapeType.Line);

        /* The rectangular mask. */
        shapeRenderer.setColor(Color.CYAN);
        shapeRenderer.rect(100, 100, 200, 200);

        /* The masked circle. */
        shapeRenderer.setColor(Color.GREEN);
        shapeRenderer.circle(100, 100, 100);
    }

    @Override
    public String getTestExplication() {
        return "Masking using scissorsStack https://github.com/libgdx/libgdx/wiki/Masking";
    }

    @Override
    public void renderTestScreen(float dt) {
        ScreenUtils.clear(Color.BLACK);

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
