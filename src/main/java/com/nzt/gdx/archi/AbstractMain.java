package com.nzt.gdx.archi;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.nzt.gdx.assets.AbstractAssetsManager;
import com.nzt.gdx.net.AutoProxy;

public abstract class AbstractMain extends Game {
	public SpriteBatch sb;
	public ShapeRenderer shapeRenderer;
	public ModelBatch modelBatch;
	public AbstractAssetsManager assetsManager;

	public abstract void doCreate();
	
	public abstract AbstractAssetsManager createAssetsManager();
	
	@Override
	public void create() {
		this.sb = new SpriteBatch();
		this.shapeRenderer = new ShapeRenderer();
		this.shapeRenderer.setAutoShapeType(true);
		this.modelBatch = new ModelBatch();
		// this.modelBatch = new ModelBatch(new DepthShaderProvider()); // effet rigolo
		
		this.assetsManager = createAssetsManager();
		AutoProxy.init();
		doCreate();
		
	}

	@Override
	public void render() {
		super.render();
	}

	@Override
	public void dispose() {
		this.sb.dispose();
		this.shapeRenderer.dispose();
		this.modelBatch.dispose();
	}

	@Override
	public void resize(int w, int h) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
