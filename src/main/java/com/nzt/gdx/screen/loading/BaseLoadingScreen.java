package com.nzt.gdx.screen.loading;

import com.nzt.gdx.archi.AbstractMain;
import com.nzt.gdx.assets.IntAssetsManager;
import com.nzt.gdx.screen.SimpleScreen;
import com.nzt.gdx.screen.manager.AbstractScreenManager.IntAfterLoading;

/**
 * Loading screen, 2 param mintime to display it,
 *
 * @author fabiitch
 */
public abstract class BaseLoadingScreen<M extends AbstractMain> extends SimpleScreen<M> {
    protected IntAssetsManager assetsManager;
    protected IntAfterLoading afterLoading;
    private float minDisplayTime;
    private float timeCounter = 0;

    public float progressPercentage = 0;

    public BaseLoadingScreen(M main, float minDisplayTime) {
        super(main);
        this.minDisplayTime = minDisplayTime;
    }

    public BaseLoadingScreen(M main, float minDisplayTime, IntAssetsManager assetsManager) {
        this(main, minDisplayTime);
        this.assetsManager = assetsManager;
    }

    public BaseLoadingScreen(M main, IntAfterLoading afterloading, float minDisplayTime) {
        super(main);
        this.afterLoading = afterloading;
        this.minDisplayTime = minDisplayTime;
    }

    public void resetProgress() {
        timeCounter = 0;
    }

    /**
     * min 0 , max 1, min between minDisplayTime and assetsManager.getProgress()
     *
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
                progress = Math.min(progressAssets, progress);
            }
        }
        return progress;
    }

    public abstract void renderScreen(float delta, float progress);

    @Override
    protected void renderScreen(float delta) {
        float progress = getProgress(delta);
        this.progressPercentage = progress * 100;
        if (progress == 1) {
            afterLoading.doAfterLoading();
        } else {
            renderScreen(delta, progress);
        }
    }


    public void setAfterLoading(IntAfterLoading afterLoading) {
        this.afterLoading = afterLoading;
    }

    public void setAssetsManager(IntAssetsManager assetsManager) {
        this.assetsManager = assetsManager;
    }


    public void setMinDisplayTime(float minDisplayTime) {
        this.minDisplayTime = minDisplayTime;
    }
}