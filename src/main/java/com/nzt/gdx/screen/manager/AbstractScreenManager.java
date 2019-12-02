package com.nzt.gdx.screen.manager;

import com.nzt.gdx.archi.AbstractMain;
import com.nzt.gdx.assets.AbstractAssetsManager;
import com.nzt.gdx.screen.BaseScreen;
import com.nzt.gdx.screen.loading.BaseLoadingScreen;
import com.nzt.gdx.screen.loading.SimpleProgressBarScreen;

public abstract class AbstractScreenManager<M extends AbstractMain> {

	protected BaseScreen currentScreen;
	protected M mainClass;
	protected BaseLoadingScreen<M> loadingScreen;
	public AbstractAssetsManager assetsManager;

	protected abstract void afterSplashScreen();

	public void startApplication(M mainClass) {
		this.mainClass = mainClass;
		this.assetsManager = mainClass.assetsManager;
		doStartApplication();
		AfterLoading after = new AfterLoading() {
			@Override
			public void doAfterLoading() {
				afterSplashScreen();
			}
		};
		loadingScreen = new SimpleProgressBarScreen<M>(mainClass, after, 0.5f, assetsManager);
		setScreen(loadingScreen);
	}

	public void setScreen(BaseScreen screen) {
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

	public interface AfterLoading {
		void doAfterLoading();
	}
}
