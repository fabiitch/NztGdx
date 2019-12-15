package com.nzt.gdx.archi;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.nzt.gdx.assets.AbstractAssetsManager;
import com.nzt.gdx.net.AutoProxy;
import com.nzt.gdx.screen.manager.AbstractScreenManager;

public abstract class AbstractMain extends Game {
	public SpriteBatch sb;
	public ShapeRenderer shapeRenderer;
	public ModelBatch modelBatch;
	public AbstractAssetsManager assetsManager;
	public AbstractScreenManager screenManager;
	 
	public abstract void doCreate();

	public abstract AbstractScreenManager createScreenManager();

	public abstract AbstractAssetsManager createAssetsManager();

	@Override
	public void create() {
		this.sb = new SpriteBatch();
		this.shapeRenderer = new ShapeRenderer();
		this.shapeRenderer.setAutoShapeType(true);
		this.modelBatch = new ModelBatch();
		// this.modelBatch = new ModelBatch(new DepthShaderProvider()); // effet rigolo

		this.assetsManager = createAssetsManager();
		this.screenManager = createScreenManager();
		AutoProxy.init();
		doCreate();
		screenManager.startApplication(this);
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
