package com.nzt.gdx.utils.logger;

public enum LogTagBase {
	PERFORMANCE, SYSTEMS, INPUT, CONTACT, BODY_CREATION;

	public static void desactiveBasesTags() {

		for (LogTagBase tag : LogTagBase.values()) {
			TagLogger.desactiveTag(tag);
		}
	}

}
