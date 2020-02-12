package com.nzt.gdx.logger.tag;

import com.badlogic.gdx.utils.Array;

/**
 * All Base tag for {@link TagLogger} Don't need enum for taglogger, but easyly
 * to use enum create an enum in your game for tag
 * 
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

	public static void desactiveBasesTagsExcept(LogTagBase... tags) {
		Array<LogTagBase> array = new Array<LogTagBase>(tags);
		for (LogTagBase tag : LogTagBase.values()) {
			if (tags != null && !array.contains(tag, true))
				TagLogger.desactiveTag(tag);
		}
	}

	public static void desactive(LogTagBase... tags) {
		for (LogTagBase tag : tags) {
			TagLogger.desactiveTag(tag);
		}
	}
}
