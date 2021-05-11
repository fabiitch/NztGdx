package com.nzt.gdx.screen.manager.impl;

import com.badlogic.gdx.Gdx;
import com.nzt.gdx.screen.AbstractScreen;
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
    public void setScreen(AbstractScreen screen) {
        Gdx.app.error("Change Screen", screen.getClass().getSimpleName());
        this.setScreen(screen, false);
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
        System.exit(0);
    }

    @Override
    protected void doRender(float dt) {

    }
}
