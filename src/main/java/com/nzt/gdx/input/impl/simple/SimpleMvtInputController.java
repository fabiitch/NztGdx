package com.nzt.gdx.input.impl.simple;

import com.badlogic.gdx.Input;
import com.nzt.gdx.input.base.BaseInputHandler;

//TODO a voir si on met pas ds test
public abstract class SimpleMvtInputController extends BaseInputHandler {

    public abstract void up();

    public abstract void down();

    public abstract void left();

    public abstract void right();

    @Override
    public boolean doKeyDown(int keycode) {
        if (keycode == Input.Keys.Z || keycode == Input.Keys.W || keycode == Input.Keys.UP) {
            up();
        } else if (keycode == Input.Keys.A || keycode == Input.Keys.Q || keycode == Input.Keys.LEFT) {
            left();
        } else if (keycode == Input.Keys.S || keycode == Input.Keys.DOWN) {
            down();
        } else if (keycode == Input.Keys.D || keycode == Input.Keys.RIGHT) {
            right();
        }
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
