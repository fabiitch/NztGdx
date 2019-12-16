package com.nzt.gdx.tester;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.nzt.gdx.archi.AbstractMain;
import com.nzt.gdx.assets.AbstractAssetsManager;
import com.nzt.gdx.screen.manager.AbstractScreenManager;

/**
 * WIP, test class for launch fast iteration dev on lib
 * @author fabiitch
 *
 */
public class Tester extends AbstractMain {

	@Override
	public void doCreate() {

	}

	@Override
	public AbstractScreenManager createScreenManager() {
		return null;
	}

	@Override
	public AbstractAssetsManager createAssetsManager() {
		return null;
	}

	public static void main(String args[]) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "toto";
		config.addIcon("badlogic.jpg", Files.FileType.Internal);
		config.useHDPI = true;

		config.foregroundFPS = 0;
		config.backgroundFPS = 0;
		new LwjglApplication(new Tester(), config);
	}
}
