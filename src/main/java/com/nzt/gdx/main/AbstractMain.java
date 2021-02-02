package com.nzt.gdx.main;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.nzt.gdx.assets.AbstractAssetsManager;
import com.nzt.gdx.debug.LogApplicationInfo;
import com.nzt.gdx.graphics.renderers.NzShapeRenderer;
import com.nzt.gdx.logger.config.AbstractLogManager;
import com.nzt.gdx.net.AutoProxy;
import com.nzt.gdx.screen.manager.AbstractScreenManager;

/**
 * Base main, extends to your main SpriteBatch, ShapeRenderer and ModelBatch
 * preinit (reimplement createRenderObjects for change it)
 */
public abstract class AbstractMain implements ApplicationListener {
    public SpriteBatch sb;
    public NzShapeRenderer shapeRenderer;
    public ModelBatch modelBatch;

    public AbstractAssetsManager assetsManager;
    public AbstractScreenManager screenManager;
    public AbstractLogManager logManager;

    public abstract void doCreate();

    public abstract AbstractScreenManager createScreenManager();

    public abstract AbstractAssetsManager createAssetsManager();

    public abstract AbstractLogManager createLogManager();

    public abstract void doExit();

    public void exit() {
        this.sb.dispose();
        this.shapeRenderer.dispose();
        this.modelBatch.dispose();
    }

    @Override
    public void create() {
        createRenderObjects();
        this.assetsManager = createAssetsManager();
        this.screenManager = createScreenManager();
        this.logManager = createLogManager();
        LogApplicationInfo.logInit(logManager.logLevel);
        LogApplicationInfo.logGraphics(logManager.logLevel);
        AutoProxy.init();
        doCreate();
        screenManager.startApplication(this);
    }

    public void createRenderObjects() {
        this.sb = new SpriteBatch();
        sb.enableBlending();
        this.shapeRenderer = new NzShapeRenderer();
        this.shapeRenderer.setAutoShapeType(true);
        this.modelBatch = new ModelBatch();
        // this.modelBatch = new ModelBatch(new DepthShaderProvider()); // effet rigolo
    }

    @Override
    public void render() {
        screenManager.render(Gdx.graphics.getDeltaTime());
    }

    @Override
    public void dispose() {
        this.screenManager.dispose();
    }


    @Override
    public void resize(int width, int height) {
        screenManager.resize(width, height);
    }

    @Override
    public void pause() {
        screenManager.pause();
    }

    @Override
    public void resume() {
        screenManager.resume();
    }
}
