package com.nzt.gdx.input.impl.simple;

import com.nzt.gdx.input.base.BaseInputHandler;
import com.nzt.gdx.logger.config.InputLoggerConfig;

//TODO a voir si on met pas ds test
public abstract class MouseInputHandler extends BaseInputHandler {
    public MouseInputHandler() {
        super();
    }

    public MouseInputHandler(InputLoggerConfig loggerConfig) {
        super(loggerConfig);
    }

    @Override
    public boolean doKeyDown(int keycode) {
        return false;
    }

    @Override
    public boolean doKeyUp(int keycode) {
        return false;
    }

    @Override
    public boolean doKeyTyped(char character) {
        return false;
    }

    @Override
    public boolean doTouchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean doMouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean doScrolled(float amountX, float amountY) {
        return false;
    }
}
