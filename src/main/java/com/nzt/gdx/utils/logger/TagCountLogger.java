package com.nzt.gdx.utils.logger;

import java.util.HashMap;

import com.badlogic.gdx.Application;

/**
 * Just and extends of TagLogger with a count of log
 * use clear for delete all tag
 * @author foccelli
 *
 */
public class TagCountLogger {

	public static HashMap<String, LogTagValues> tagCountMap = new HashMap<String, LogTagValues>();
	public static boolean bDontLog = false;

	public static void clear() {
		tagCountMap = new HashMap<String, LogTagValues>();
	}

	public static void debug(String tag, String message) {
		LogTagValues logTagValues = getTag(tag);
		TagLogger.debug(logTagValues.tag, "count:" + logTagValues.count + " " + message);
	}

	public static void log(String tag, String message) {
		LogTagValues logTagValues = getTag(tag);
		TagLogger.log(logTagValues.tag, "count:" + logTagValues.count + " " + message);
	}

	public static void error(String tag, String message) {
		LogTagValues logTagValues = getTag(tag);
		TagLogger.error(logTagValues.tag, "count:" + logTagValues.count + " " + message);
	}

	public static void resetTag(String tag) {
		LogTagValues logTagValues = getTag(tag);
		logTagValues.count = 0;
		TagLogger.log(tag, "reset tag count");
	}

	public static void activeTag(String tag) {
		TagLogger.activeTag(tag);
	}

	public static void desactiveTag(String tag) {
		TagLogger.desactiveTag(tag);
	}

	public static void activeAllTag() {
		TagLogger.activeAllTag();
	}

	public static void desactiveAllTag() {
		TagLogger.desactiveAllTag();
	}

	private static LogTagValues getTag(String tag) {
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
	public int level;

	public LogTagValues(String tag, int level) {
		this.tag = tag;
		this.count = 0;
		this.level = level;
	}

	public LogTagValues(String tag) {
		this.tag = tag;
		this.level = Application.LOG_INFO;
		this.count = 0;
	}

}
