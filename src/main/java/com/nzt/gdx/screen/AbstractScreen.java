package com.nzt.gdx.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.nzt.gdx.debug.gl.NzGLProfiler;
import com.nzt.gdx.debug.perf.PerformanceFrame;
import com.nzt.gdx.graphics.renderers.NzShapeRenderer;
import com.nzt.gdx.main.AbstractMain;

/**
 * Abstract screen for {@link #AbstractScreen(AbstractMain)} Wrapper for access
 * main, render object
 * <p>
 * See {@link BaseScreen} for next implementation
 *
 * @param <M>
 */
public abstract class AbstractScreen<M extends AbstractMain> implements Screen {

    protected M main;
    protected SpriteBatch spriteBatch;
    protected NzShapeRenderer nzShapeRenderer;
    protected ModelBatch modelBatch;

    private NzGLProfiler nzGLProfiler;

    public AbstractScreen(M main) {
        this.main = main;
        this.spriteBatch = main.sb;
        this.nzShapeRenderer = main.nzShapeRenderer;
        this.modelBatch = main.modelBatch;
        if (main.logManager != null)
            this.nzGLProfiler = main.logManager.nzGlProfiler;
        PerformanceFrame.setScreen(this);
    }

    public void clearScreen() {
        //TODO voir use screen utils
        // clear screen
        Gdx.gl.glClearColor(0, 0, 0, 0);
        // Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

    }

    public void setTitle(float dt) {
        Gdx.graphics.setTitle("FPS : " + Gdx.graphics.getFramesPerSecond() + " | DT = " + dt);
    }

    public abstract void doShow();

    public abstract void doResize(int width, int height);

    public abstract void doPause();

    public abstract void doResume();

    public abstract void doHide();

    public abstract void doDispose();

    @Override
    public void render(float dt) {
        PerformanceFrame.startFrame();
        nzGLProfiler.endFrame();
        clearScreen();
        setTitle(dt);
        renderScreen(dt);
        PerformanceFrame.endFrame();
    }

    protected abstract void renderScreen(float dt);
}
