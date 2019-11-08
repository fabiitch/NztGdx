package com.nzt.gdx.archi;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public abstract class AbstractMain extends Game {
	public SpriteBatch sb;
	public ShapeRenderer shapeRenderer;
	public ModelBatch modelBatch;


	@Override
	public void create() {
		this.sb = new SpriteBatch();
		this.shapeRenderer = new ShapeRenderer();
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
