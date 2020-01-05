package com.nzt.gdx.logger.tag;

/**
 * All Base tag for {@link TagLogger}
 * Don't need enum for taglogger, but easyly to use enum
 * create an enum in your game for tag 
 * @author fabiitch
 *
 */
public enum LogTagBase {
	INIT, NET, PERFORMANCE, SYSTEMS, INPUT, B2D_CONTACT, B2D_CREATION, SCREEN_ACTIONS;

	// SCREEN_ACTIONS is all except render(show, resize, pause, resume, hide)

	public static void desactiveBasesTags() {
		for (LogTagBase tag : LogTagBase.values()) {
			TagLogger.desactiveTag(tag);
		}
	}

}
