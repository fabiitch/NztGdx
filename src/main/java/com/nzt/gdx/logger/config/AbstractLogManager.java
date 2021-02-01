package com.nzt.gdx.logger.config;

import com.badlogic.gdx.Gdx;
import com.nzt.gdx.debug.perf.frame.PerformanceFrame;
import com.nzt.gdx.logger.tag.LogTagsBase;
import com.nzt.gdx.logger.tag.TagLogger;
import com.nzt.gdx.main.AbstractMain;

/**
 * Abstract LogManager, used in {@link AbstractMain}
 * 
 */
public abstract class AbstractLogManager {

	public static AbstractLogManager instance;

	public InputLoggerConfig inputLoggerConfig;

	// log level 0,1,2,3
	public AbstractLogManager(int logLevel) {
		Gdx.app.setLogLevel(logLevel);
		this.inputLoggerConfig = configureInputLog();
		configureTags();
		AbstractLogManager.instance = this;
	}

	public void activePerfFrame() {
		PerformanceFrame.init();
		TagLogger.activeTag(LogTagsBase.PERFORMANCE);
	}

	public abstract void configureTags();

	public abstract InputLoggerConfig configureInputLog();
}
