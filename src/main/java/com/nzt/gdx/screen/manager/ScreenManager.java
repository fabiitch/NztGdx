package com.nzt.gdx.screen.manager;

import com.badlogic.gdx.Screen;
import com.nzt.gdx.main.AbstractMain;
import com.nzt.gdx.screen.AbstractScreen;

public interface ScreenManager<M extends AbstractMain, S extends AbstractScreen<M>> {

    void startApplication(M main);

    void pause();

    void resume();

    void dispose();

    void resize(int width, int height);

    void render(float dt);

    void setScreen(S screen);
}
