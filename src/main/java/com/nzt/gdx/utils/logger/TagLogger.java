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

	public static Map<Enum<?>, Boolean> tagMap = new HashMap<Enum<?>, Boolean>();
	public static boolean DONT_LOG = false;

	public static void clear() {
		tagMap = new HashMap<Enum<?>, Boolean>();
	}

	public static <E extends Enum<E>> void debug(E tag, String message) {
		if (!DONT_LOG && getTag(tag))
			Gdx.app.debug(tag.name(), message);
	}

	public static <E extends Enum<E>> void log(E tag, String message) {
		if (!DONT_LOG && getTag(tag))
			Gdx.app.log(tag.name(), message);
	}

	public static <E extends Enum<E>> void error(E tag, String message) {
		if (!DONT_LOG && getTag(tag))
			Gdx.app.error(tag.name(), message);
	}

	public static <E extends Enum<E>> void activeTag(E tag) {
		tagMap.put(tag, true);
	}

	public static <E extends Enum<E>> void desactiveTag(E tag) {
		tagMap.put(tag, false);
	}

	public static <E extends Enum<?>> void activeAllTag(Class<E> enumTag) {
		for (E o : enumTag.getEnumConstants()) {
			tagMap.put(o, true);
		}
	}

	public static <E extends Enum<?>> void desactiveAllTag(Class<E> enumTag) {
		for (E o : enumTag.getEnumConstants()) {
			tagMap.put(o, false);
		}
	}

	private static <E extends Enum<E>> Boolean getTag(E tag) {
		Boolean activeTag = tagMap.get(tag);
		if (activeTag == null) {
			activeTag(tag);
			return true;
		}
		return activeTag;
	}

}
