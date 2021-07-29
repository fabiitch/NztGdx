package com.nzt.gdx.input.impl.simple;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.logger.config.InputLoggerConfig;

public abstract class SimpleClickInputHandler extends MouseInputHandler {

    public final static int LEFT_CLICK = 0;
    public final static int RIGHT_CLICK = 1;
    public final static int WHEEL_CLICK = 2;

    public SimpleClickInputHandler() {
        super();
    }

    public Vector2 getClickPos(int screenX, int screenY, Vector2 clickPos) {
        return clickPos.set(screenX, Gdx.graphics.getHeight() - screenY);
    }

    public Vector2 getClickPos(int screenX, int screenY) {
        return new Vector2(screenX, Gdx.graphics.getHeight() - screenY);
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
