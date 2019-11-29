package com.nzt.gdx.utils.logger;

import java.util.HashMap;

/**
 * Just and extends of TagLogger with a count of log use clear for delete all
 * tag
 * 
 * @author foccelli
 *
 */
public class TagCountLogger {

	public static HashMap<Enum<?>, LogTagValues> tagCountMap = new HashMap<Enum<?>, LogTagValues>();

	public static void clear() {
		tagCountMap = new HashMap<Enum<?>, LogTagValues>();
	}

	public static <E extends Enum<E>> void debug(E tag, String message) {
		LogTagValues logTagValues = getTag(tag);
		TagLogger.debug(tag, "count:" + logTagValues.count + " " + message);
	}

	public static <E extends Enum<E>> void log(E tag, String message) {
		LogTagValues logTagValues = getTag(tag);
		TagLogger.log(tag, "count:" + logTagValues.count + " " + message);
	}

	public static <E extends Enum<E>> void error(E tag, String message) {
		LogTagValues logTagValues = getTag(tag);
		TagLogger.error(tag, "count:" + logTagValues.count + " " + message);
	}

	public static <E extends Enum<E>> void resetTag(E tag) {
		LogTagValues logTagValues = getTag(tag);
		logTagValues.count = 0;
		TagLogger.log(tag, "reset tag count");
	}

	public static <E extends Enum<E>> void activeTag(E tag) {
		TagLogger.activeTag(tag);
	}

	public static <E extends Enum<E>> void desactiveTag(E tag) {
		TagLogger.desactiveTag(tag);
	}

	public static <E extends Enum<E>> void activeAllTag(Class<E> enumTag) {
		TagLogger.activeAllTag(enumTag);
	}

	public static <E extends Enum<?>> void desactiveAllTag(Class<E> enumTag) {
		TagLogger.desactiveAllTag(enumTag);
	}

	private static <E extends Enum<E>> LogTagValues getTag(E tag) {
		LogTagValues logTag = tagCountMap.get(tag);
		if (logTag == null) {
			logTag = new LogTagValues(tag);
			tagCountMap.put(tag, logTag);
		}
		logTag.count++;
		return logTag;
	}

}

class LogTagValues {

	public String tag;
	public int count;

	public <E extends Enum<E>> LogTagValues(E tag) {
		this.tag = tag.name();
		this.count = 0;
	}

}
