package com.nzt.gdx.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.utils.PerformanceCounter;
import com.nzt.gdx.archi.AbstractMain;
import com.nzt.gdx.graphics.renderers.NzShapeRenderer;
import com.nzt.gdx.logger.tag.LogTagsBase;
import com.nzt.gdx.logger.tag.TagLogger;

/**
 * Abstract screen for {@link #AbstractScreen(AbstractMain)} Wrapper for access
 * main, render object
 * <p>
 * See {@link BaseScreen} for next implementation
 *
 * @param <M>
 * @author fabiitch
 */
public abstract class AbstractScreen<M extends AbstractMain> implements Screen {

    protected M main;
    protected SpriteBatch spriteBatch;
    protected NzShapeRenderer shapeRenderer;
    protected ModelBatch modelBatch;
    protected int countForPerformanceLog =0;

    public AbstractScreen(M main) {
        this.main = main;
        this.spriteBatch = main.sb;
        this.shapeRenderer = main.shapeRenderer;
        this.modelBatch = main.modelBatch;
    }

    private final void clearScreen() {
        // clear screen
        Gdx.gl.glClearColor(0, 0, 0, 0);
        // Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

    }

    private final void showFPS(float dt) {
        Gdx.graphics.setTitle("FPS : " + Gdx.graphics.getFramesPerSecond() + " | delta=" + dt);
	}

    public abstract void doShow() ;

    @Override
    public void render(float dt) {
        logScreenPerf(dt);
        clearScreen();
        showFPS(dt);
        renderScreen(dt);
    }

    protected abstract void renderScreen(float dt);

    private void logScreenPerf(float dt) {
        countForPerformanceLog++;
        if (countForPerformanceLog >= 1000) {//TODO ?? vraiement utile
            TagLogger.log(LogTagsBase.PERFORMANCE, "fps = " + Gdx.graphics.getFramesPerSecond());
            TagLogger.log(LogTagsBase.PERFORMANCE, "dt = " + dt);
            countForPerformanceLog=0;
        }
    }
}