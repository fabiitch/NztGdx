package com.nzt.gdx.screen.manager;

import com.nzt.gdx.archi.AbstractMain;
import com.nzt.gdx.assets.AbstractAssetsManager;
import com.nzt.gdx.screen.BaseScreen;
import com.nzt.gdx.screen.loading.BaseLoadingScreen;
import com.nzt.gdx.screen.loading.SimpleProgressBarScreen;

public abstract class AbstractScreenManager<M extends AbstractMain> {
	protected M mainClass;

	protected BaseScreen<M> currentScreen;
	protected BaseLoadingScreen<M> loadingScreen;
	public AbstractAssetsManager assetsManager;

	public float minDisplayTime;

	protected abstract void afterSplashScreen();

	public AbstractScreenManager(float minDisplayTime) {
		super();
		this.minDisplayTime = minDisplayTime;
		loadingScreen = createLoadingScreen();
		if (loadingScreen == null) {
			loadingScreen = new SimpleProgressBarScreen<M>(mainClass, this.minDisplayTime, assetsManager);
		}
	}

	public AbstractScreenManager() {
		this(0.2f);
	}

	public abstract BaseLoadingScreen<M> createLoadingScreen();

	public void startApplication(M mainClass) {
		this.mainClass = mainClass;
		this.assetsManager = mainClass.assetsManager;
		doStartApplication();
		IntAfterLoading afterloading = new IntAfterLoading() {
			@Override
			public void doAfterLoading() {
				afterSplashScreen();
				loadingScreen.dispose();
			}
		};
		this.loadingScreen.setAfterLoading(afterloading);
		setScreen(loadingScreen);
	}

	void setLoadingScreen(BaseLoadingScreen<M> newLoadingScreen) {
		this.loadingScreen = newLoadingScreen;
	}

	public void setScreenWithLoadingTransition(final BaseScreen<M> screen, float minTimeDisplay) {
		IntAfterLoading afterloading = new IntAfterLoading() {
			@Override
			public void doAfterLoading() {
				setScreen(screen);
			}
		};
		this.loadingScreen.setAfterLoading(afterloading);
		setScreen(loadingScreen);
	}

	public void setScreenWithLoadingTransition(final BaseScreen<M> screen) {
		IntAfterLoading afterloading = new IntAfterLoading() {
			@Override
			public void doAfterLoading() {
				setScreen(screen);
			}
		};
		loadingScreen = new SimpleProgressBarScreen<M>(mainClass, afterloading, minDisplayTime, assetsManager);
		setScreen(loadingScreen);
	}

	public void setScreen(BaseScreen<M> screen) {
		if (currentScreen != null) {
			currentScreen.dispose();
			currentScreen = null;
		}
		mainClass.setScreen(screen);
		currentScreen = screen;
	}

	protected abstract void doStartApplication();

	// ===================== screen implements
	public void pause() {
		currentScreen.pause();
		doPause();
	}

	protected abstract void doPause();

	public void resume() {
		currentScreen.resume();
		doResume();
	}

	protected abstract void doResume();

	public void resize(int width, int height) {
		currentScreen.resize(width, height);
		doResize(width, height);
	}

	protected abstract void doResize(int width, int height);

	public void dispose() {
		currentScreen.dispose();
		doDispose();
	}

	// =============
	protected abstract void doDispose();

	public interface IntAfterLoading {
		void doAfterLoading();
	}
}
