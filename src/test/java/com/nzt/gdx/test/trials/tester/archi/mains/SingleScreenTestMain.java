package com.nzt.gdx.test.trials.tester.archi.mains;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

/**
 * ESCAPE for exit
 * ENTER for replay
 */
public class SingleScreenTestMain extends FastTesterMain {
    public SingleScreenTestMain(Class screenClass) {
        super(screenClass);
    }

    @Override
    public void doCreate() {
        Gdx.app.setLogLevel(Application.LOG_DEBUG);
        Gdx.app.log("SingleScreenTestMain", "Initialisation with SingleScreenTestMain");
        Gdx.app.log("=============", "================");
        logManager.activeGlProfiler();
    }

    @Override
    public void render() {
        super.render();
        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            Gdx.app.log("Test Exit", "Escape pressed");
            System.exit(0);
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
            Gdx.app.log("Test Reset", "Enter pressed");
            screenManager.setScreen(returnScreenToLaunch());
        }

    }
}