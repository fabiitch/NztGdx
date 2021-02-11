package com.nzt.gdx.screen.loading;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.nzt.gdx.main.AbstractMain;
import com.nzt.gdx.assets.IntAssetsManager;
import com.nzt.gdx.graphics.renderables.SimpleNzProgressBar;

/**
 * loading screen with rectangle progress bar in middle
 * 
 * @author fabiitch
 *
 */
public class SimpleProgressBarScreen<M extends AbstractMain> extends BaseLoadingScreen<M> {
	public SimpleNzProgressBar doubleRectangle;

	public SimpleProgressBarScreen(M main, float minDisplayTime) {
		super(main, minDisplayTime);
		createRectangles();
	}

	public SimpleProgressBarScreen(M main, float minDisplayTime, IntAssetsManager assetsManager) {
		super(main, minDisplayTime, assetsManager);
		createRectangles();
	}

	private void createRectangles() {
		float rectX = Gdx.graphics.getWidth() / 15;
		float rectY = Gdx.graphics.getHeight() / 20;
		float rectHeight = Gdx.graphics.getHeight() / 20;
		doubleRectangle = new SimpleNzProgressBar(rectX, rectY, Gdx.graphics.getWidth() - rectX * 2, rectHeight, Color.CYAN,
				Color.RED);
	}

	@Override
	public void renderScreen(float dt, float progress) {
		doubleRectangle.updatePercent(progress);
		nzShapeRenderer.begin(ShapeType.Filled);
		doubleRectangle.render(nzShapeRenderer);
		nzShapeRenderer.end();
	}

}
