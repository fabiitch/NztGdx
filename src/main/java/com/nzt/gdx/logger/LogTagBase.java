package com.nzt.gdx.logger;

public enum LogTagBase {
	INIT, PROXY, PERFORMANCE, SYSTEMS, INPUT, B2D_CONTACT, B2D_CREATION, SCREEN_ACTIONS;

	// SCREEN_ACTIONS is all except render(show, resize, pause, resume, hide)

	public static void desactiveBasesTags() {

		for (LogTagBase tag : LogTagBase.values()) {
			TagLogger.desactiveTag(tag);
		}
	}

}
