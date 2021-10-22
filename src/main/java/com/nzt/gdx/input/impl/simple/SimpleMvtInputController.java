package com.nzt.gdx.input.impl.simple;

import com.badlogic.gdx.Input;
import com.nzt.gdx.input.base.BaseInputHandler;
import com.nzt.gdx.logger.config.InputLoggerConfig;

//TODO a voir si on met pas ds test
public abstract class SimpleMvtInputController extends BaseInputHandler {

    public SimpleMvtInputController() {
    }

    public SimpleMvtInputController(InputLoggerConfig loggerConfig) {
        super(loggerConfig);
    }

    public abstract void up(boolean pressed);

    public abstract void down(boolean pressed);

    public abstract void left(boolean pressed);

    public abstract void right(boolean pressed);

    @Override
    public boolean doKeyDown(int keycode) {
        if (keycode == Input.Keys.Z || keycode == Input.Keys.W || keycode == Input.Keys.UP) {
            up(true);
        } else if (keycode == Input.Keys.A || keycode == Input.Keys.Q || keycode == Input.Keys.LEFT) {
            left(true);
        } else if (keycode == Input.Keys.S || keycode == Input.Keys.DOWN) {
            down(true);
        } else if (keycode == Input.Keys.D || keycode == Input.Keys.RIGHT) {
            right(true);
        }
        return false;
    }

    @Override
    public boolean doKeyUp(int keycode) {
        if (keycode == Input.Keys.Z || keycode == Input.Keys.W || keycode == Input.Keys.UP) {
            up(false);
        } else if (keycode == Input.Keys.A || keycode == Input.Keys.Q || keycode == Input.Keys.LEFT) {
            left(false);
        } else if (keycode == Input.Keys.S || keycode == Input.Keys.DOWN) {
            down(false);
        } else if (keycode == Input.Keys.D || keycode == Input.Keys.RIGHT) {
            right(false);
        }
        return false;
    }

    @Override
    public boolean doKeyTyped(char character) {
        return false;
    }

    @Override
    public boolean doTouchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean doTouchUp(int screenX, int screenY, int pointer, int button) {
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
