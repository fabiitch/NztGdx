package com.nzt.gdx.screen;

import com.nzt.gdx.archi.AbstractMain;
import com.nzt.gdx.logger.tag.LogTagBase;
import com.nzt.gdx.logger.tag.TagLogger;

/**
 * Base screen with log on screenAction
 * See LogTagBase for logs.
 * @author fabiitch
 *
 */
public abstract class BaseScreen extends AbstractScreen<AbstractMain> {

	public BaseScreen(AbstractMain main) {
		super(main);
	}

	@Override
	public void show() {
		TagLogger.log(LogTagBase.SCREEN_ACTIONS, this.getClass().getSimpleName(), "show()");
	}

	@Override
	public void resize(int width, int height) {
		TagLogger.log(LogTagBase.SCREEN_ACTIONS, this.getClass().getSimpleName(),
				"resize(" + width + ", " + height + ")");
	}

	@Override
	public void pause() {
		TagLogger.log(LogTagBase.SCREEN_ACTIONS, this.getClass().getSimpleName(), "pause()");
	}

	@Override
	public void resume() {
		TagLogger.log(LogTagBase.SCREEN_ACTIONS, this.getClass().getSimpleName(), "resume()");
	}

	@Override
	public void hide() {
		TagLogger.log(LogTagBase.SCREEN_ACTIONS, this.getClass().getSimpleName(), "hide()");
	}

	@Override
	public void dispose() {
		TagLogger.log(LogTagBase.SCREEN_ACTIONS, this.getClass().getSimpleName(), "dispose()");
	}

}