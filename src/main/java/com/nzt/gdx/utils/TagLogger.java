package com.nzt.gdx.utils;

import java.util.HashMap;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;

public class TagLogger {

	public static TagLogger use = new TagLogger();
	private HashMap<String, LogTagValues> tagMap;
	public static boolean bLog = false;

	private TagLogger() {
		tagMap = new HashMap<String, LogTagValues>();
	}

	public void createTag(String tag) {

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

	public void activeAllTag(String tag) {
		for (LogTagValues logTagValues : tagMap.values()) {
			logTagValues.bactive = true;
		}
	}
	public void desactiveAllTag(String tag) {
		for (LogTagValues logTagValues : tagMap.values()) {
			logTagValues.bactive = false;
		}
	}

	public void stopLog() {
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		for (LogTagValues logTag : tagMap.values()) {
			logTag.bactive = false;
		}
	}

	public void logOnTag(String tag, String message) {
		LogTagValues logTagValues = getTag(tag);
		if (logTagValues == null) {

		}
	}

	public void resetTag(String tag) {
		LogTagValues logTag = getTag(tag);
		counterMap.put(tag, logTag);
		if (logTag.bactive && bLog) {
			System.err.println("GetOrderOf : " + tag + ": reset");
		}

	}

	public void activeTag(String tag, boolean active) {
		LogTagValues logTag = getTag(tag);
		logTag.bactive = false;
	}

	private LogTagValues getTag(String tag) {
		LogTagValues logTag = counterMap.get(tag);
		if (logTag == null) {
			logTag = new LogTagValues(tag);
			counterMap.put(tag, logTag);
		}
		return logTag;
	}
}

class LogTagValues {

	public String tag;
	public int count;
	public int level;
	public boolean bactive;

	public LogTagValues(String tag) {
		this.tag = tag;
		this.count = 0;
		this.level = 0;
		this.bactive = true;
	}

	public LogTagValues(String tag, boolean active) {
		this.tag = tag;
		this.count = 0;
		this.bactive = active;
	}

}
