package com.nzt.gdx.main;

import com.nzt.gdx.screen.manager.AbstractAssetsManager;
import com.nzt.gdx.screen.manager.AbstractLogManager;
import com.nzt.gdx.screen.manager.AbstractScreenManager;

public class HeadlessMain extends AbstractMain{
    @Override
    public void doCreate() {

    }

    @Override
    public AbstractScreenManager createScreenManager() {
        return null;
    }

    @Override
    public AbstractAssetsManager createAssetsManager() {
        return null;
    }

    @Override
    public AbstractLogManager createLogManager() {
        return null;
    }

    @Override
    public void doExit() {

    }
}
