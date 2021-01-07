package com.nzt.gdx.screen;

import com.nzt.gdx.archi.AbstractMain;
import com.nzt.gdx.logger.tag.LogTagsBase;
import com.nzt.gdx.logger.tag.TagLogger;

/**
 * Base screen with log on screenAction
 * See LogTagBase for logs.
 *
 * @author fabiitch
 */
public abstract class BaseScreen<M extends AbstractMain> extends AbstractScreen<M> {

    public BaseScreen(M main) {
        super(main);
    }

    @Override
    public void show() {
        TagLogger.log(LogTagsBase.SCREEN_ACTIONS, this.getClass().getSimpleName(), "show()");
        doShow();
    }

    @Override
    public void resize(int width, int height) {
        TagLogger.log(LogTagsBase.SCREEN_ACTIONS, this.getClass().getSimpleName(),
                "resize(" + width + ", " + height + ")");
        doResize(width, height);
    }

    @Override
    public void pause() {
        TagLogger.log(LogTagsBase.SCREEN_ACTIONS, this.getClass().getSimpleName(), "pause()");
        doPause();
    }

    @Override
    public void resume() {
        TagLogger.log(LogTagsBase.SCREEN_ACTIONS, this.getClass().getSimpleName(), "resume()");
        doResume();
    }

    @Override
    public void hide() {
        TagLogger.log(LogTagsBase.SCREEN_ACTIONS, this.getClass().getSimpleName(), "hide()");
        doHide();
    }

    @Override
    public void dispose() {
        TagLogger.log(LogTagsBase.SCREEN_ACTIONS, this.getClass().getSimpleName(), "dispose()");
        doDispose();
    }

}