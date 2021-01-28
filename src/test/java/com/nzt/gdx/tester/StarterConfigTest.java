package com.nzt.gdx.tester;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.nzt.gdx.main.AbstractMain;

public class StarterConfigTest {

	public static void startLwjgl(AbstractMain main) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "toto";
		config.addIcon("badlogic.jpg", Files.FileType.Internal);
		config.useHDPI = true;

		config.foregroundFPS = 0;
		config.backgroundFPS = 0;
		new LwjglApplication(main, config);
	}

	public static void startLwjgl(AbstractMain main, int witdh, int height) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "toto";
		config.addIcon("badlogic.jpg", Files.FileType.Internal);
		config.useHDPI = true;
		config.width = witdh;
		config.height = height;

		config.foregroundFPS = 0;
		config.backgroundFPS = 0;
		new LwjglApplication(main, config);
	}
}
