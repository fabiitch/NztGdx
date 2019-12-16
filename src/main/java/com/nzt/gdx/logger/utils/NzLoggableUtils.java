package com.nzt.gdx.logger.utils;

/**
 * Utils class for get {@link NzLoggable} 
 * Not thread safe, return same instance of NzLoggable
 * @author fabiitch
 *
 */
public class NzLoggableUtils {

	private static NzLoggableSimple temp = new NzLoggableSimple();

	public static NzLoggable create(final String tag, final String value) {
		temp.tag = tag;
		temp.value = value;
		return temp;
	}

	public static NzLoggable create(Object object) {
		temp.tag = object.getClass().getSimpleName();
		temp.value = object.toString();
		return temp;
	}
}
