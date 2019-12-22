package com.nzt.gdx.logger;

import com.badlogic.gdx.Gdx;

public abstract class LoggerConfig {

	public InputLoggerConfig inputLoggerConfig;

	public LoggerConfig(int logLevel) {
		Gdx.app.setLogLevel(logLevel);
	}

	public abstract void configureTags();

	public abstract InputLoggerConfig  configureInputLog();
}
