package com.nzt.gdx.test.trials.tester.archi.main;

import com.badlogic.gdx.Gdx;
import com.nzt.gdx.main.AbstractMain;
import com.nzt.gdx.screen.AbstractScreen;
import com.nzt.gdx.screen.BaseScreen;
import com.nzt.gdx.screen.manager.impl.FastDevScreenManager;

/**
 * Fast Screen manager for test
 */
public class FastTesterScreenManager extends FastDevScreenManager {

    private BaseScreen<AbstractMain> screenToSet;

    public FastTesterScreenManager(BaseScreen<AbstractMain> screen) {
        this.screenToSet = screen;
    }

    @Override
    protected void afterSplashScreen() {
        setScreen(screenToSet);
    }


    @Override
    public void setScreen(AbstractScreen screen) {
        Gdx.app.error("Change Screen", screen.getClass().getSimpleName());
        super.setScreen(screen);
    }


}
