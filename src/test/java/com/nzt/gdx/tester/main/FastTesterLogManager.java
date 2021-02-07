package com.nzt.gdx.tester.main;

import com.badlogic.gdx.Application;
import com.nzt.gdx.logger.config.AbstractLogManager;
import com.nzt.gdx.logger.config.InputLoggerConfig;
import com.nzt.gdx.logger.tag.TagLogger;

public class FastTesterLogManager extends AbstractLogManager {
    public static FastTesterLogManager instance = new FastTesterLogManager();

    public FastTesterLogManager() {
        super(Application.LOG_DEBUG);
    }

    @Override
    public void configureTags() {
        TagLogger.DONT_LOG = true;
    }

    @Override
    public InputLoggerConfig configureInputLog() {
        InputLoggerConfig inputLoggerConfig = new InputLoggerConfig();
        return inputLoggerConfig;
    }
}
