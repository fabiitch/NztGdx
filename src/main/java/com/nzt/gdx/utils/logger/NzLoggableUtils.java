package com.nzt.gdx.utils.logger;

public class NzLoggableUtils {

	public static NzLoggable create(final String tag, final String value) {
		return new NzLoggableSimple(tag, value);
	}

	public static NzLoggable create(Object object) {
		return new NzLoggableSimple(object.getClass().getSimpleName(), object.toString());
	}
}
