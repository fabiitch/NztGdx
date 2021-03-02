package com.nzt.gdx.screen.manager.impl;

import com.nzt.gdx.screen.loading.BaseLoadingScreen;
import com.nzt.gdx.screen.manager.AbstractScreenManager;

public abstract class FastDevScreenManager extends AbstractScreenManager {

    @Override
    public BaseLoadingScreen createLoadingScreen() {
        return null;
    }

    @Override
    protected void doStartApplication() {

    }

    @Override
    protected void doPause() {

    }

    @Override
    protected void doResume() {

    }

    @Override
    protected void doResize(int width, int height) {

    }

    @Override
    protected void doDispose() {

    }

    @Override
    protected void doRender(float dt) {

    }
}
