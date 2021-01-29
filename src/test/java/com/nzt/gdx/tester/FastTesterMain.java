package com.nzt.gdx.tester;

import java.lang.reflect.Constructor;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.nzt.gdx.assets.AbstractAssetsManager;
import com.nzt.gdx.logger.config.AbstractLogManager;
import com.nzt.gdx.main.AbstractMain;
import com.nzt.gdx.screen.BaseScreen;
import com.nzt.gdx.screen.manager.AbstractScreenManager;
import com.nzt.gdx.tester.screen.HudDebugDisplayScreen;

/**
 * WIP, test class for launch fast iteration dev on lib change
 * returnScreenToLaunch for test your screen
 *
 * @author fabiitch
 */
public class FastTesterMain extends AbstractMain {

	// To start
	public static void main(String args[]) {
		Class screentestClass = HudDebugDisplayScreen.class;
		StarterConfigTest.startLwjgl(new FastTesterMain(screentestClass));
	}

	Class screenClass;

	public FastTesterMain(Class screenClass) {
		this.screenClass = screenClass;
	}

	private BaseScreen returnScreenToLaunch() {
		try {
			Constructor cons = screenClass.getConstructor(AbstractMain.class);
			Object newInstance = cons.newInstance((AbstractMain) this);
			return (BaseScreen) newInstance;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void doCreate() {
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		Gdx.app.log("FastTester", "Initialisation faster tester");
	}

	@Override
	public AbstractScreenManager createScreenManager() {
		return new FastTesterScreenManager(returnScreenToLaunch());
	}

	@Override
	public AbstractAssetsManager createAssetsManager() {
		return null;
	}

	@Override
	public AbstractLogManager createLogManager() {
		return null;
	}

	@Override
	public void doExit() {

	}

}
