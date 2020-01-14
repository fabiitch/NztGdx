package com.nzt.gdx.logger.tag.count;

import java.util.HashMap;
import java.util.Map;

import com.nzt.gdx.logger.tag.TagLogger;

/**
 * Just and extends of TagLogger with a count of log use clear for delete all
 * tag
 * 
 * @author fabiitch
 *
 */
public class TagCountLogger {

	private static final Map<Enum<?>, LogCountTagValues> tagCountMap = new HashMap<Enum<?>, LogCountTagValues>();

	public static void clearTags() {
		tagCountMap.clear();
	}

	public static <E extends Enum<E>> void debug(E tag, String message) {
		LogCountTagValues logTagValues = getTag(tag);
		TagLogger.debug(tag, "count:" + logTagValues.count + " " + message);
	}

	public static <E extends Enum<E>> void log(E tag, String message) {
		LogCountTagValues logTagValues = getTag(tag);
		TagLogger.log(tag, "count:" + logTagValues.count + " " + message);
	}

	public static <E extends Enum<E>> void error(E tag, String message) {
		LogCountTagValues logTagValues = getTag(tag);
		TagLogger.error(tag, "count:" + logTagValues.count + " " + message);
	}

	public static <E extends Enum<E>> void resetTag(E tag) {
		LogCountTagValues logTagValues = getTag(tag);
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

	private static <E extends Enum<E>> LogCountTagValues getTag(E tag) {
		LogCountTagValues logTag = tagCountMap.get(tag);
		if (logTag == null) {
			logTag = new LogCountTagValues(tag);
			tagCountMap.put(tag, logTag);
		}
		logTag.count++;
		return logTag;
	}

}
