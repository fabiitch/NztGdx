package com.nzt.gdx.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.nzt.gdx.archi.AbstractMain;
import com.nzt.gdx.graphics.NzShapeRenderer;

/**
 * Abstract screen for {@link #AbstractScreen(AbstractMain)} Wrapper for acces
 * main, render object
 * <p>
 * See {@link #BaseScreen} for next implementation
 *
 * @param <M>
 * @author fabiitch
 */
public abstract class AbstractScreen<M extends AbstractMain> implements Screen {

    protected M main;
    protected SpriteBatch sb;
    protected NzShapeRenderer shapeRenderer;
    protected ModelBatch mb;

    public AbstractScreen(M main) {
        this.main = main;
        this.sb = main.sb;
        this.shapeRenderer = main.shapeRenderer;
        this.mb = main.modelBatch;
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

    @Override
    public void render(float dt) {
        clearScreen();
        showFPS(dt);
        renderScreen(dt);
    }

    protected abstract void renderScreen(float dt);
}