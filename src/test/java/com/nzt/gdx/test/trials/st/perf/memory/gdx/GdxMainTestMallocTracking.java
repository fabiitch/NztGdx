package com.nzt.gdx.test.trials.st.perf.memory.gdx;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.ScreenUtils;

/**
 * Test if Gdx empty app alloc memory
 * screen should stay blue
 */
class GdxMainTestMallocTracking implements ApplicationListener {

    public static void main(String[] args) {
        LwjglApplicationConfiguration configuration = new LwjglApplicationConfiguration();
        configuration.title = "Gdx allocation Test";
        configuration.addIcon("badlogic.jpg", Files.FileType.Internal);

        configuration.useHDPI = true;
        configuration.width = 600;
        configuration.height = 400;

        configuration.foregroundFPS = 0;
        configuration.backgroundFPS = 0;
        new LwjglApplication(new GdxMainTestMallocTracking(), configuration);
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
