package com.nzt.gdx.screen;

import com.nzt.gdx.main.AbstractMain;
import com.nzt.gdx.logger.tag.LogTagsBase;
import com.nzt.gdx.logger.tag.TagLogger;

/**
 * Base screen with log on screenAction
 * See LogTagBase for logs.
 */
public abstract class BaseScreen<M extends AbstractMain> extends AbstractScreen<M> {

    public BaseScreen(M main) {
        super(main);
    }

    @Override
    public final void show() {
        TagLogger.info(LogTagsBase.SCREEN_ACTIONS, this.getClass().getSimpleName(), "show()");
        doShow();
    }

    @Override
    public final void resize(int width, int height) {
        TagLogger.info(LogTagsBase.SCREEN_ACTIONS, this.getClass().getSimpleName(),
                "resize(" + width + ", " + height + ")");
        doResize(width, height);
    }

    @Override
    public final void pause() {
        TagLogger.info(LogTagsBase.SCREEN_ACTIONS, this.getClass().getSimpleName(), "pause()");
        doPause();
    }

    @Override
    public final void resume() {
        TagLogger.info(LogTagsBase.SCREEN_ACTIONS, this.getClass().getSimpleName(), "resume()");
        doResume();
    }

    @Override
    public final void hide() {
        TagLogger.info(LogTagsBase.SCREEN_ACTIONS, this.getClass().getSimpleName(), "hide()");
        doHide();
    }


    @Override
    public final void dispose() {
        TagLogger.info(LogTagsBase.SCREEN_ACTIONS, this.getClass().getSimpleName(), "dispose()");
        doDispose();
    }
}