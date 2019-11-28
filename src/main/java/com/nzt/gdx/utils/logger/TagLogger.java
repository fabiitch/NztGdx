package com.nzt.gdx.utils.logger;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.Gdx;

/**
 * wrapper class for active/desactive tag on logger a tag is active by default
 * (firstlog) and log/warn/error/debug effective if gdx.log.level is correct
 * 
 * @author fabiitch
 *
 */
public class TagLogger {

	public static Map<String, Boolean> tagMap = new HashMap<String, Boolean>();

	public static void clear() {
		tagMap = new HashMap<String, Boolean>();
	}

	public static void debug(String tag, String message) {
		if (getTag(tag))
			Gdx.app.debug(tag, message);
	}

	public static void log(String tag, String message) {
		if (getTag(tag))
			Gdx.app.log(tag, message);
	}

	public static void error(String tag, String message) {
		if (getTag(tag))
			Gdx.app.error(tag, message);
	}

	public static void activeTag(String tag) {
		tagMap.put(tag, true);
	}

	public static void desactiveTag(String tag) {
		tagMap.put(tag, false);
	}

	public static void activeAllTag() {
		for (String key : tagMap.keySet()) {
			tagMap.put(key, true);
		}
	}

	public static void desactiveAllTag() {
		for (String key : tagMap.keySet()) {
			tagMap.put(key, false);
		}
	}

	private static Boolean getTag(String tag) {
		Boolean activeTag = tagMap.get(tag);
		if (activeTag == null) {
			activeTag(tag);
			return true;
		}
		return activeTag;
	}
}
