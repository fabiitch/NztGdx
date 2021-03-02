package com.nzt.gdx.screen.manager.impl;

import com.nzt.gdx.logger.config.InputLoggerConfig;
import com.nzt.gdx.screen.manager.AbstractLogManager;

public class FastDevLogManager extends AbstractLogManager {
    public FastDevLogManager() {
        super(3);
    }

    @Override
    public void configureTags() {

    }

    @Override
    public InputLoggerConfig configureInputLog() {
        return null;
    }
}
