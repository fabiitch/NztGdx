package com.nzt.gdx.test.utils.archi.mains.junit;

import com.badlogic.gdx.Gdx;
import com.nzt.gdx.main.AbstractMain;
import com.nzt.gdx.screen.AbstractScreen;
import com.nzt.gdx.screen.manager.ScreenManager;

public class JunitScreenManager implements ScreenManager {
    @Override
    public void startApplication(AbstractMain main) {
        Gdx.app.debug("Junit", "Start");
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void render(float dt) {

    }

    @Override
    public void setScreen(AbstractScreen screen) {

    }
}
