package com.nzt.gdx.logger.config;

import com.badlogic.gdx.Gdx;
import com.nzt.gdx.main.AbstractMain;

/**
 * Abstract LogManager, used in {@link AbstractMain}
 * @param <M>
 */
public abstract class AbstractLogManager<M extends AbstractMain> {

    public InputLoggerConfig inputLoggerConfig;

    //log level 0,1,2,3
    public AbstractLogManager(int logLevel) {
        Gdx.app.setLogLevel(logLevel);
        this.inputLoggerConfig = configureInputLog();
        configureTags();
    }

    public abstract void configureTags();

    public abstract InputLoggerConfig configureInputLog();
}
