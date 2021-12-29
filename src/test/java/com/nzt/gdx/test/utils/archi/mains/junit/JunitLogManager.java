package com.nzt.gdx.test.utils.archi.mains.junit;

import com.badlogic.gdx.Application;
import com.nzt.gdx.logger.config.InputLoggerConfig;
import com.nzt.gdx.screen.manager.AbstractLogManager;

public class JunitLogManager extends AbstractLogManager {
    public JunitLogManager() {
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
