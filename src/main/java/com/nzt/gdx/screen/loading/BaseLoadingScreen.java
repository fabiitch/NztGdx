package com.nzt.gdx.screen.loading;

import com.nzt.gdx.archi.AbstractMain;
import com.nzt.gdx.assets.IntAssetsManager;
import com.nzt.gdx.screen.BaseScreen;
import com.nzt.gdx.screen.manager.AbstractScreenManager.AfterLoading;

/**
 * Loading screen, 2 param mintime to display it,  
 * 
 * @author fabiitch
 *
 */
public abstract class BaseLoadingScreen extends BaseScreen {
	protected IntAssetsManager assetsManager;
	protected AfterLoading afterLoading;
	private float minDisplayTime;
	private float timeCounter = 0;

	public BaseLoadingScreen(AbstractMain main, AfterLoading afterloading, float minDisplayTime) {
		super(main);
		this.afterLoading = afterloading;
		this.minDisplayTime = minDisplayTime;
	}

	public BaseLoadingScreen(AbstractMain main, AfterLoading afterloading, float minDisplayTime,
			IntAssetsManager assetsManager) {
		this(main, afterloading, minDisplayTime);
		this.assetsManager = assetsManager;
	}

	/**
	 * min 0 , max 1, min between minDisplayTime and assetsManager.getProgress() 
	 * 
	 * @param delta
	 * @return
	 */
	private float getProgress(float delta) {
		timeCounter += delta;
		float progress = timeCounter / minDisplayTime;
		if (timeCounter >= minDisplayTime) {
			progress = 1;
		}

		if (assetsManager != null) {
			float progressAssets = assetsManager.getProgress() / 100;
			if (progressAssets < 1) {
				progress = progressAssets < progress ? progressAssets : progress;
			}
		}
		return progress;
	}

	/**
	 * override to render your screen
	 * @param delta
	 * @param progress
	 */
	public abstract void renderScreen(float delta, float progress);

	/**
	 * method called by gdx, calcul time and render loadingscreen
	 */
	@Override
	protected void renderScreen(float delta) {
		float progress = getProgress(delta);
		if (progress == 1) {
			afterLoading.doAfterLoading();
		}else {
			renderScreen(delta, progress);
		}

	}


}