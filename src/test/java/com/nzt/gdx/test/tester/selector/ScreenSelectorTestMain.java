package com.nzt.gdx.test.tester.selector;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.nzt.gdx.assets.AbstractAssetsManager;
import com.nzt.gdx.logger.config.AbstractLogManager;
import com.nzt.gdx.test.tester.archi.main.FastTesterLogManager;
import com.nzt.gdx.test.tester.archi.main.FastTesterMain;
import com.nzt.gdx.test.tester.archi.main.FastTesterScreenManager;

public class ScreenSelectorTestMain extends FastTesterMain {

	public ScreenSelectorTestMain(Class screenClass) {
		super(screenClass);
	}

	private SelectorScreenTest selectorScreenTest;

	@Override
	public void doCreate() {
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		Gdx.app.log("ScreenSelectorTestMain", "Initialisation faster tester");
	}

	@Override
	public FastTesterScreenManager createScreenManager() {
		selectorScreenTest = new SelectorScreenTest(this);
		return new FastTesterScreenManager(selectorScreenTest);
	}

	@Override
	public void render() {
		super.render();
		if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE) && screenManager.currentScreen != selectorScreenTest) {
			selectorScreenTest = new SelectorScreenTest(this);
			screenManager.setScreen(selectorScreenTest);
		}
	}

	@Override
	public AbstractAssetsManager createAssetsManager() {
		return null;
	}

	@Override
	public AbstractLogManager createLogManager() {
		return FastTesterLogManager.instance;
	}

	@Override
	public void doExit() {

	}

}
