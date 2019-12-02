package com.nzt.gdx.input;

import com.badlogic.gdx.InputProcessor;
import com.nzt.gdx.utils.logger.LogTagBase;
import com.nzt.gdx.utils.logger.TagLogger;

public abstract class BaseGameInputHandler implements InputProcessor {
	public final boolean FORCE_MOBILE = false;

	@Override
	public boolean keyDown(int keycode) {
		TagLogger.log(LogTagBase.INPUT, "keyDown", "keycode:" + keycode);
		return doKeyDown(keycode);
	}

	public abstract boolean doKeyDown(int keycode);

	@Override
	public boolean keyUp(int keycode) {
		TagLogger.log(LogTagBase.INPUT, "keyUp", "keycode: " + keycode);
		return doKeyUp(keycode);
	}

	public abstract boolean doKeyUp(int keycode);

	@Override
	public boolean keyTyped(char character) {
		TagLogger.log(LogTagBase.INPUT, "keyTyped", "character: " + character);
		return doKeyTyped(character);
	}

	public abstract boolean doKeyTyped(char character);

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		TagLogger.log(LogTagBase.INPUT, "touchDown",
				"screenX: " + screenX + " / screenY:" + screenY + " / pointer:" + pointer + " / button:" + button);
		return doTouchDown(screenX, screenY, pointer, button);
	}

	public abstract boolean doTouchDown(int screenX, int screenY, int pointer, int button);

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		TagLogger.log(LogTagBase.INPUT, "touchUp",
				"screenX: " + screenX + " / screenY:" + screenY + " / pointer:" + pointer + " / button:" + button);
		return doTouchUp(screenX, screenY, pointer, button);
	}

	public abstract boolean doTouchUp(int screenX, int screenY, int pointer, int button);

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		TagLogger.log(LogTagBase.INPUT, "touchDragged",
				"screenX: " + screenX + " / screenY:" + screenY + " / pointer:" + pointer);
		return doTouchDragged(screenX, screenY, pointer);
	}

	public abstract boolean doTouchDragged(int screenX, int screenY, int pointer);

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		TagLogger.log(LogTagBase.INPUT, "mouseMoved", "screenX: " + screenX + " / screenY:" + screenY);
		return doMouseMoved(screenX, screenY);
	}

	public abstract boolean doMouseMoved(int screenX, int screenY);

	@Override
	public boolean scrolled(int amount) {
		TagLogger.log(LogTagBase.INPUT, "scrolled", "amount:" + amount);
		return doScrolled(amount);
	}

	public abstract boolean doScrolled(int amount);
}
