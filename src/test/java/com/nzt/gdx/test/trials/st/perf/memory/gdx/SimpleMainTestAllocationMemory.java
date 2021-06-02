package com.nzt.gdx.test.trials.st.perf.memory.gdx;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

/**
 * Test if Gdx empty app alloc memory
 * normalement screen stay blue
 */
class SimpleMainTestAllocationMemory implements ApplicationListener {

    public static void main(String[] args) {
        LwjglApplicationConfiguration configuration = new LwjglApplicationConfiguration();
        configuration.title = "Gdx allocation Test";
        configuration.addIcon("badlogic.jpg", Files.FileType.Internal);

        configuration.useHDPI = true;
        configuration.width = 600;
        configuration.height = 400;

        configuration.foregroundFPS = 0;
        configuration.backgroundFPS = 0;
        new LwjglApplication(new SimpleMainTestAllocationMemory(), configuration);
    }

    private long memoryStart;
    @Override
    public void render() {
        Vector2 v = new Vector2();
        v.set(1,2);
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
