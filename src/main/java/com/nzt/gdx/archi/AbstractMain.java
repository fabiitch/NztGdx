package com.nzt.gdx.archi;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.nzt.gdx.assets.AbstractAssetsManager;
import com.nzt.gdx.graphics.renderers.NzShapeRenderer;
import com.nzt.gdx.logger.LogApplicationInfo;
import com.nzt.gdx.logger.config.AbstractLogManager;
import com.nzt.gdx.net.AutoProxy;
import com.nzt.gdx.screen.manager.AbstractScreenManager;

/**
 * Base main, extends to your main SpriteBatch, ShapeRenderer and ModelBatch
 * preinit (reimplement createRenderObjects for change it)
 * 
 * @author fabiitch
 *
 */
public abstract class AbstractMain extends Game {
	public AbstractLogManager<AbstractMain> logManager;
	public SpriteBatch sb;
	public NzShapeRenderer shapeRenderer;
	public ModelBatch modelBatch;

	public AbstractAssetsManager assetsManager;
	public AbstractScreenManager<AbstractMain> screenManager;

	public abstract void doCreate();

	public abstract AbstractScreenManager<AbstractMain> createScreenManager();

	public abstract AbstractAssetsManager createAssetsManager();

	public abstract AbstractLogManager<AbstractMain> createLoggerConfig();

	@Override
	public void create() {
		createRenderObjects();
		this.assetsManager = createAssetsManager();
		this.screenManager = createScreenManager();
		LogApplicationInfo.logInit();
		AutoProxy.init();
		doCreate();
		screenManager.startApplication(this);
	}

	public void createRenderObjects() {
		this.sb = new SpriteBatch();
		this.shapeRenderer = new NzShapeRenderer();
		this.shapeRenderer.setAutoShapeType(true);
		this.modelBatch = new ModelBatch();
		// this.modelBatch = new ModelBatch(new DepthShaderProvider()); // effet rigolo

	}

	@Override
	public void render() {
		super.render();
	}

	@Override
	public void dispose() {
		super.dispose();
		this.screenManager.dispose();
		this.sb.dispose();
		this.shapeRenderer.dispose();
		this.modelBatch.dispose();
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
