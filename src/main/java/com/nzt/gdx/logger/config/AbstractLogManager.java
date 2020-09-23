package com.nzt.gdx.logger.config;

import com.badlogic.gdx.Gdx;
import com.nzt.gdx.archi.AbstractMain;

public abstract class AbstractLogManager<M extends AbstractMain> {

	public InputLoggerConfig inputLoggerConfig;

	public AbstractLogManager(int logLevel) {
		Gdx.app.setLogLevel(logLevel);
		this.inputLoggerConfig = configureInputLog();
	}

	public abstract void configureTags();

	public abstract InputLoggerConfig configureInputLog();
}
