package com.nzt.gdx.test.trials.st.t3d;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.nzt.gdx.test.trials.tester.archi.main.FastTesterMain;
import com.nzt.gdx.test.trials.tester.archi.screens.TestScreen;

public abstract class BaseST3D extends TestScreen {
    public BaseST3D(FastTesterMain main) {
        super(main);
        addHudToGlProfiler();
    }

    public String getExplication() {
        return null;
    }

    @Override
    public void clearScreen() {
        Gdx.gl.glClearColor(1, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
    }
}
