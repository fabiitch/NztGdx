package com.nzt.gdx.input.impl.simple;

import com.nzt.gdx.logger.config.InputLoggerConfig;

public abstract class SimpleClickInputHandler extends MouseInputHandler {

    public SimpleClickInputHandler() {
        super();
    }

    public SimpleClickInputHandler(InputLoggerConfig loggerConfig) {
        super(loggerConfig);
    }

    public abstract boolean click(int screenX, int screenY, int pointer, int button);

    @Override
    public boolean doTouchDown(int screenX, int screenY, int pointer, int button) {
        return click(screenX, screenY, pointer, button);
    }

    @Override
    public boolean doTouchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }
}
