package com.nzt.gdx.test.tester.archi.main;

import java.lang.reflect.Constructor;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.nzt.gdx.assets.AbstractAssetsManager;
import com.nzt.gdx.logger.config.AbstractLogManager;
import com.nzt.gdx.main.AbstractMain;
import com.nzt.gdx.screen.BaseScreen;

/**
 * WIP, test class for launch fast iteration dev on lib change
 * returnScreenToLaunch for test your screen
 *
 * @author fabiitch
 */
public class FastTesterMain extends AbstractMain {

	Class screenClass;

	public FastTesterMain(Class screenClass) {
		this.screenClass = screenClass;
	}

	private BaseScreen returnScreenToLaunch() {
		try {
			Constructor cons = screenClass.getConstructor(FastTesterMain.class);
			Object newInstance = cons.newInstance(this);
			return (BaseScreen) newInstance;
		} catch (Exception e) {
			System.out.println("Cant instance class " + screenClass);
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
	public FastTesterScreenManager createScreenManager() {
		return new FastTesterScreenManager(returnScreenToLaunch());
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