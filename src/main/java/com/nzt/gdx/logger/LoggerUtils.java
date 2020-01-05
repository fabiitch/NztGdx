package com.nzt.gdx.logger;

import com.badlogic.gdx.Gdx;

//TODO pourri
public class LoggerUtils {
	public static void debugBlock(String blockName, String... objectToLogs) {
		Gdx.app.debug(blockName, "Start == " + blockName);
		for (int i = 0, n = objectToLogs.length; i < n; i += 2) {
			Gdx.app.debug(objectToLogs[i], objectToLogs[i + 1]);
		}
		Gdx.app.debug(blockName, "End   == " + blockName);
	}

	public static void logBlock(String blockName, String... objectToLogs) {
		Gdx.app.log(blockName, "Start == " + blockName);
		for (int i = 0, n = objectToLogs.length; i < n; i += 2) {
			Gdx.app.log(objectToLogs[i], objectToLogs[i + 1]);
		}
		Gdx.app.log(blockName, "End   == " + blockName);
	}

	public static void errorBlock(String blockName, String... objectToLogs) {
		Gdx.app.error(blockName, "Start == " + blockName);
		for (int i = 0, n = objectToLogs.length; i < n; i += 2) {
			Gdx.app.error(objectToLogs[i], objectToLogs[i + 1]);
		}
		Gdx.app.error(blockName, "End   == " + blockName);
	}

	public static void logWithSeparator(String tag, String message) {
		logSeparator();
		Gdx.app.log(tag, message);
		logSeparator();
	}

	public static void logSeparator() {
		Gdx.app.log("==================", "==================");
	}

	public static void logSeparator(int number) {
		for (int i = 0; i < number; i++) {
			Gdx.app.log("==================", "==================");
		}
	}
}
