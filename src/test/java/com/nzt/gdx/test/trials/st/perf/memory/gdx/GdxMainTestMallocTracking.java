package com.nzt.gdx.test.trials.st.perf.memory.gdx;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.ScreenUtils;

/**
 * Test if Gdx empty app alloc memory
 * screen should stay blue
 */
class GdxMainTestMallocTracking implements ApplicationListener {

    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration configuration = new Lwjgl3ApplicationConfiguration();
        configuration.setTitle("Tester Lwjgl3");
        configuration.setWindowedMode(600, 400);
        configuration.setWindowIcon("icons/libgdx128.png", "icons/libgdx64.png", "icons/libgdx32.png", "icons/libgdx16.png");
        new Lwjgl3Application(new GdxMainTestMallocTracking(), configuration);
    }

    private long memoryStart;
    @Override
    public void render() {
        if (Gdx.app.getJavaHeap() > memoryStart) {
            ScreenUtils.clear(Color.RED);
        } else {
            ScreenUtils.clear(Color.BLUE);
        }
    }

    @Override
    public void create() {
        this.memoryStart = Gdx.app.getJavaHeap();
    }

    @Override
    public void resize(int width, int height) {

    }


    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
        System.exit(0);

    }
}
