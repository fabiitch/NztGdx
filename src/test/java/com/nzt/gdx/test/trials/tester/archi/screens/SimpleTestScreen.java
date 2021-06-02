package com.nzt.gdx.test.trials.tester.archi.screens;

import com.badlogic.gdx.Gdx;
import com.nzt.gdx.screen.SimpleScreen;
import com.nzt.gdx.test.trials.tester.archi.main.FastTesterMain;

public abstract class SimpleTestScreen extends SimpleScreen<FastTesterMain> {

    private final static String FPS = "  FPS : ";
    private final String className = this.getClass().getSimpleName();

    public SimpleTestScreen(FastTesterMain main) {
        super(main);
    }

    @Override
    public void setTitle(float dt) {
        Gdx.graphics.setTitle(className + FPS + Gdx.graphics.getFramesPerSecond());
    }

    public void log(String log) {
        Gdx.app.log(this.getClass().getSimpleName(), log);
    }

    public void error(String error) {
        Gdx.app.error(this.getClass().getSimpleName(), error);
    }
}
