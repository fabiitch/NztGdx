package com.nzt.gdx.screen.loading;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.nzt.gdx.archi.AbstractMain;
import com.nzt.gdx.assets.IntAssetsManager;
import com.nzt.gdx.graphics.renderables.ProgressBar_SR;
import com.nzt.gdx.screen.manager.AbstractScreenManager.IntAfterLoading;

/**
 * loading screen with rectangle progress bar in middle
 * 
 * @author fabiitch
 *
 */
public class SimpleProgressBarScreen<M extends AbstractMain<?>> extends BaseLoadingScreen<M> {
	protected ProgressBar_SR doubleRectangle;

	public SimpleProgressBarScreen(M main, float minDisplayTime) {
		super(main, minDisplayTime);
		createRectangles();
	}

	public SimpleProgressBarScreen(M main, float minDisplayTime, Color colorBase, Color colorBorder) {
		super(main, minDisplayTime);
		createRectangles();
	}

	public SimpleProgressBarScreen(M main, float minDisplayTime, IntAssetsManager assetsManager) {
		super(main, minDisplayTime, assetsManager);
		createRectangles();
	}

	public SimpleProgressBarScreen(M main, IntAfterLoading afterloading, float minDisplayTime) {
		super(main, afterloading, minDisplayTime);
		createRectangles();
	}

	public SimpleProgressBarScreen(M main, IntAfterLoading afterloading, float minDisplayTime,
			IntAssetsManager assetsManager) {
		super(main, afterloading, minDisplayTime, assetsManager);
		createRectangles();
	}

	private void createRectangles() {
		float rectX = Gdx.graphics.getWidth() / 15;
		float rectY = Gdx.graphics.getHeight() / 20;
		float rectHeight = Gdx.graphics.getHeight() / 20;
		doubleRectangle = new ProgressBar_SR(rectX, rectY, Gdx.graphics.getWidth() - rectX * 2, rectHeight, Color.CYAN,
				Color.RED);
	}

	@Override
	public void renderScreen(float dt, float progress) {
		doubleRectangle.updatePercent(progress);
		shapeRenderer.begin(ShapeType.Filled);
		doubleRectangle.render(shapeRenderer);
		shapeRenderer.end();
	}

}
