package com.nzt.gdx.screen;

import com.nzt.gdx.main.AbstractMain;

/**
 * simple screen , dont need to implements all methods of screen
 * Similaire a ScreenAdapter mais pour NzT
 *
 * @param <M>
 */
public abstract class SimpleScreen<M extends AbstractMain> extends BaseScreen<M> {

    public SimpleScreen(M main) {
        super(main);
    }

    @Override
    public void doShow() {

    }

    @Override
    public void doResize(int width, int height) {
    }

    @Override
    public void doPause() {

    }

    @Override
    public void doResume() {

    }

    @Override
    public void doHide() {

    }

}
