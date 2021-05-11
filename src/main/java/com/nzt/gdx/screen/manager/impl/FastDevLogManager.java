package com.nzt.gdx.screen.manager.impl;

import com.badlogic.gdx.Application;
import com.nzt.gdx.logger.config.InputLoggerConfig;
import com.nzt.gdx.screen.manager.AbstractLogManager;

public class FastDevLogManager extends AbstractLogManager {
    public FastDevLogManager() {
        super(Application.LOG_DEBUG);
    }

    @Override
    public void configureTags() {

    }

    @Override
    public InputLoggerConfig configureInputLog() {
        return null;
    }
}
