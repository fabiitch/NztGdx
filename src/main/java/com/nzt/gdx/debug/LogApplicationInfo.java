package com.nzt.gdx.debug;

import com.badlogic.gdx.Gdx;
import com.nzt.gdx.logger.tag.LogTagsBase;
import com.nzt.gdx.logger.tag.TagLogger;

/**
 * Log les info de l'appli
 * @author fabiitch
 *
 */
public class LogApplicationInfo {

	public static void logInit() {
		TagLogger.error(LogTagsBase.INIT, "LogLevel", "" + Gdx.app.getLogLevel());
		TagLogger.error(LogTagsBase.INIT, "App type", "" + Gdx.app.getType());
		TagLogger.error(LogTagsBase.INIT, "Android/Ios version", "" + Gdx.app.getVersion());
		TagLogger.error(LogTagsBase.INIT, "Java Heap", "" + Gdx.app.getJavaHeap());
		TagLogger.error(LogTagsBase.INIT, "Java Native Heap", "" + Gdx.app.getNativeHeap());
	}
}
