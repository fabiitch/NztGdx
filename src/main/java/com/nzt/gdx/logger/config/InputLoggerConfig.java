package com.nzt.gdx.logger.config;

public class InputLoggerConfig {

	public boolean logKeyDown, logKeyUp, logKeyTyped, logTouchDown, logTouchUp, logTouchDragged, logMouseMoved,
			logScrolled;

	public InputLoggerConfig() {
		//all is false
	}

	public InputLoggerConfig(boolean logKey, boolean logTouch, boolean logTouchOrMouseMoved, boolean logScroll) {

		this.logKeyDown = logKey;
		this.logKeyUp = logKey;
		this.logKeyTyped = logKey;

		this.logTouchDown = logTouch;
		this.logTouchUp = logTouch;

		this.logTouchDragged = logTouchOrMouseMoved;
		this.logMouseMoved = logTouchOrMouseMoved;

		this.logScrolled = logScroll;
	}

	public InputLoggerConfig(boolean logKeyDown, boolean logKeyUp, boolean logKeyTyped, boolean logTouchDown,
			boolean logTouchUp, boolean logTouchDragged, boolean logMouseMoved, boolean logScrolled) {
		super();
		this.logKeyDown = logKeyDown;
		this.logKeyUp = logKeyUp;
		this.logKeyTyped = logKeyTyped;
		this.logTouchDown = logTouchDown;
		this.logTouchUp = logTouchUp;
		this.logTouchDragged = logTouchDragged;
		this.logMouseMoved = logMouseMoved;
		this.logScrolled = logScrolled;
	}

}
