package com.nzt.gdx.input.impl.simple;

import com.nzt.gdx.input.base.BaseInputHandler;

//TODO a voir si on met pas ds test
public abstract class SimpleKeyInputHandler extends BaseInputHandler {
    @Override
    public boolean doKeyDown(int keycode) {
        return false;
    }

    @Override
    public boolean doKeyUp(int keycode) {
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
