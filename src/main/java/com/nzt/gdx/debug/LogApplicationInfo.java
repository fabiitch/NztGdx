package com.nzt.gdx.logger;

import com.badlogic.gdx.Gdx;
import com.nzt.gdx.logger.tag.LogTagBase;
import com.nzt.gdx.logger.tag.TagLogger;

/**
 * Log les info de l'appli
 * @author fabiitch
 *
 */
public class LogApplicationInfo {

	public static void logInit() {
		TagLogger.error(LogTagBase.INIT, "LogLevel", "" + Gdx.app.getLogLevel());
		TagLogger.error(LogTagBase.INIT, "App type", "" + Gdx.app.getType());
		TagLogger.error(LogTagBase.INIT, "Android/Ios version", "" + Gdx.app.getVersion());
		TagLogger.error(LogTagBase.INIT, "Java Heap", "" + Gdx.app.getJavaHeap());
		TagLogger.error(LogTagBase.INIT, "Java Native Heap", "" + Gdx.app.getNativeHeap());
	}
}
