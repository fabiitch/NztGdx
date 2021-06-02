package com.nzt.gdx.test.trials.st.utils.perf.memory.gdx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.nzt.gdx.test.trials.tester.archi.main.FastTesterMain;
import com.nzt.gdx.test.trials.tester.archi.main.StarterTestConfig;
import com.nzt.gdx.utils.GdxUtils;

public class SimpleScreen implements Screen {

    private final long memoryStart;
    private final BitmapFont font;
    private final SpriteBatch spriteBatch;
    final static String MEMORY_GROW = "Memory Grow";

    public static void main(String[] args) {
        StarterTestConfig.startLwjgl(new FastTesterMain(SimpleScreen.class),400,200);
    }

    public SimpleScreen() {
        font = new BitmapFont();
        spriteBatch = new SpriteBatch();
        this.memoryStart = Gdx.app.getJavaHeap();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.BLUE);
        if (Gdx.app.getJavaHeap() > memoryStart) {
            spriteBatch.begin();
            font.draw(spriteBatch, MEMORY_GROW,
                    GdxUtils.getScreenCenterX(), GdxUtils.getScreenCenterY());
            spriteBatch.end();
        }
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
    public void hide() {

    }

    @Override
    public void dispose() {
        font.dispose();
    }
}
