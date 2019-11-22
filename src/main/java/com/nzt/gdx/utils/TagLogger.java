package com.nzt.gdx.utils;

import java.util.HashMap;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;

public class TagLogger {

	public static TagLogger use = new TagLogger();
	private HashMap<String, LogTagValues> tagMap;
	public static boolean bDontLog = false;

	private TagLogger() {
		tagMap = new HashMap<String, LogTagValues>();
	}

	public void log(String tag, String message) {
		LogTagValues logTagValues = getTag(tag);
		log(message, logTagValues);
	}

	public void createTag(String tag) {
		tagMap.put(tag, new LogTagValues(tag));
	}

	public void createTag(String tag, int level) {
		tagMap.put(tag, new LogTagValues(tag, level));
	}

	public void resetTag(String tag) {
		LogTagValues logTagValues = getTag(tag);
		logTagValues.count = 0;
		log("reset tag", logTagValues);
	}

	public void activeTag(String tag) {
		LogTagValues logTagValues = tagMap.get(tag);
		if (logTagValues != null)
			logTagValues.bactive = true;
	}

	public void desactiveTag(String tag) {
		LogTagValues logTagValues = tagMap.get(tag);
		if (logTagValues != null)
			logTagValues.bactive = false;
	}

	public void activeAllTag() {
		for (LogTagValues logTagValues : tagMap.values()) {
			logTagValues.bactive = true;
		}
	}

	public void desactiveAllTag() {
		for (LogTagValues logTagValues : tagMap.values()) {
			logTagValues.bactive = false;
		}
	}

	private LogTagValues getTag(String tag) {
		LogTagValues logTag = tagMap.get(tag);
		if (logTag == null) {
			logTag = new LogTagValues(tag);
			tagMap.put(tag, logTag);
		}
		return logTag;
	}

	private void log(String message, LogTagValues logTagValues) {
		if (!bDontLog) {
			switch (logTagValues.level) {
			case Application.LOG_NONE:

				break;
			case Application.LOG_ERROR:
				Gdx.app.error(logTagValues.tag + " " + logTagValues.count, message);
				break;
			case Application.LOG_INFO:
				Gdx.app.log(logTagValues.tag + " " + logTagValues.count, message);
				break;
			case Application.LOG_DEBUG:
				Gdx.app.debug(logTagValues.tag + " " + logTagValues.count, message);
				break;

			default:
				break;
			}
			logTagValues.count++;
		}
	}
}

class LogTagValues {

	public String tag;
	public int count;
	public int level;
	public boolean bactive;

	public LogTagValues(String tag, int level) {
		this.tag = tag;
		this.count = 0;
		this.level = level;
		this.bactive = true;
	}

	public LogTagValues(String tag) {
		this.tag = tag;
		this.level = Application.LOG_INFO;
		this.count = 0;
		this.bactive = true;
	}

}
