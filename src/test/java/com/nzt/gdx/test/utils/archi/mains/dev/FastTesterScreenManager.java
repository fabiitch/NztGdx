package com.nzt.gdx.test.utils.archi.mains.dev;

import com.nzt.gdx.main.AbstractMain;
import com.nzt.gdx.screen.BaseScreen;
import com.nzt.gdx.screen.manager.impl.FastDevScreenManager;

/**
 * Fast Screen manager for test
 */
public class FastTesterScreenManager extends FastDevScreenManager {

    private final BaseScreen<AbstractMain> screenToSet;

    public FastTesterScreenManager(BaseScreen<AbstractMain> screen) {
        this.screenToSet = screen;
    }

    @Override
    protected void afterSplashScreen() {
        setScreen(screenToSet);
    }

}
