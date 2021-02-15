package com.nzt.gdx.test.tester.archi.main;

import com.nzt.gdx.main.AbstractMain;
import com.nzt.gdx.screen.BaseScreen;
import com.nzt.gdx.screen.loading.BaseLoadingScreen;
import com.nzt.gdx.screen.manager.AbstractScreenManager;

/**
 * Fast Screen manager for test
 *
 * @author fabiitch
 */
public class FastTesterScreenManager extends AbstractScreenManager<AbstractMain> {

	private BaseScreen<AbstractMain> screenToSet;

	public FastTesterScreenManager(BaseScreen<AbstractMain> screen) {
		this.screenToSet = screen;
	}

	public BaseLoadingScreen createLoadingScreen() {
		return null;
	}

	@Override
	protected void afterSplashScreen() {
		setScreen(screenToSet);
	}

	@Override
	protected void doStartApplication() {
	}

	@Override
	protected void doPause() {
	}

	@Override
	protected void doResume() {

	}

	@Override
	protected void doResize(int width, int height) {

	}

	@Override
	protected void doDispose() {

	}

	@Override
	protected void doRender(float dt) {

	}

}
