package com.nzt.gdx.input.base;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Input.Keys;
import com.nzt.gdx.debug.B2DDebug;
import com.nzt.gdx.logger.config.InputLoggerConfig;
import com.nzt.gdx.logger.debug.PoolsDebug;
import com.nzt.gdx.logger.tag.LogTagBase;
import com.nzt.gdx.logger.tag.TagLogger;

/**
 * Simple InputProcessor with TagLogger on events, see {@link LogTagBase#INPUT}
 * and {@link TagLogger}
 * 
 * @author fabiitch
 *
 */
public abstract class BaseInputHandler implements InputProcessor {
	public final boolean FORCE_MOBILE = false;
	public InputLoggerConfig loggerConfig;

	public BaseInputHandler() {
		this.loggerConfig = new InputLoggerConfig();
	}

	public BaseInputHandler(InputLoggerConfig loggerConfig) {
		this.loggerConfig = loggerConfig;
	}

	@Override
	public boolean keyDown(int keycode) {
		if (loggerConfig.logKeyDown)
			TagLogger.log(LogTagBase.INPUT, "keyDown", "keycode:" + keycode);

		if (keycode == Keys.P) {
			B2DDebug.logInfo();
			return true;
		}
		else if (keycode == Keys.O) {
			PoolsDebug.debugPools();
			return true;
		}else if (keycode == Keys.O) {
			PoolsDebug.debugPools();
			return true;
		}
		return doKeyDown(keycode);
	}

	public abstract boolean doKeyDown(int keycode);

	@Override
	public boolean keyUp(int keycode) {
		if (loggerConfig.logKeyUp)
			TagLogger.log(LogTagBase.INPUT, "keyUp", "keycode: " + keycode);
		return doKeyUp(keycode);
	}

	public abstract boolean doKeyUp(int keycode);

	@Override
	public boolean keyTyped(char character) {
		if (loggerConfig.logKeyTyped)
			TagLogger.log(LogTagBase.INPUT, "keyTyped", "character: " + character);
		return doKeyTyped(character);
	}

	public abstract boolean doKeyTyped(char character);

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		if (loggerConfig.logTouchDown)
			TagLogger.log(LogTagBase.INPUT, "touchDown",
					"screenX: " + screenX + " / screenY:" + screenY + " /�pointer:" + pointer + " /�button:" + button);
		return doTouchDown(screenX, screenY, pointer, button);
	}

	public abstract boolean doTouchDown(int screenX, int screenY, int pointer, int button);

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		if (loggerConfig.logTouchUp)
			TagLogger.log(LogTagBase.INPUT, "touchUp",
					"screenX: " + screenX + " / screenY:" + screenY + " /�pointer:" + pointer + " /�button:" + button);
		return doTouchUp(screenX, screenY, pointer, button);
	}

	public abstract boolean doTouchUp(int screenX, int screenY, int pointer, int button);

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		if (loggerConfig.logTouchDragged)
			TagLogger.log(LogTagBase.INPUT, "touchDragged",
					"screenX: " + screenX + " / screenY:" + screenY + " /�pointer:" + pointer);
		return doTouchDragged(screenX, screenY, pointer);
	}

	public abstract boolean doTouchDragged(int screenX, int screenY, int pointer);

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		if (loggerConfig.logMouseMoved)
			TagLogger.log(LogTagBase.INPUT, "mouseMoved", "screenX: " + screenX + " / screenY:" + screenY);
		return doMouseMoved(screenX, screenY);
	}

	public abstract boolean doMouseMoved(int screenX, int screenY);

	@Override
	public boolean scrolled(int amount) {
		if (loggerConfig.logScrolled)
			TagLogger.log(LogTagBase.INPUT, "scrolled", "amount:" + amount);
		return doScrolled(amount);
	}

	public abstract boolean doScrolled(int amount);
}
