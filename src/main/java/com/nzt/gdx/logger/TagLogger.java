package com.nzt.gdx.logger;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.Gdx;
import com.nzt.gdx.logger.utils.NzLoggable;

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

	// ============= active/desactive
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

	// ============= debug
	public static <E extends Enum<E>> void debug(E tag, String tagToDisplay, String message) {
		if (!DONT_LOG && getTag(tag))
			Gdx.app.debug(tagToDisplay, message);
	}

	public static <E extends Enum<E>> void debug(E tag, String message) {
		if (!DONT_LOG && getTag(tag))
			Gdx.app.debug(tag.name(), message);
	}

	public static <E extends Enum<E>> void debugBlock(E tag, NzLoggable... objectToLogs) {
		if (!DONT_LOG && getTag(tag)) {
			Gdx.app.debug(tag.name(), "======== Start ============");
			for (NzLoggable loggable : objectToLogs) {
				Gdx.app.debug(loggable.gdxLogTag(), loggable.gdxLogValue());
			}
			Gdx.app.debug(tag.name(), "======== End ============");
		}
	}

	// ============= log
	public static <E extends Enum<E>> void log(E tag, String tagToDisplay, String message) {
		if (!DONT_LOG && getTag(tag))
			Gdx.app.log(tagToDisplay, message);
	}

	public static <E extends Enum<E>> void log(E tag, String message) {
		if (!DONT_LOG && getTag(tag))
			Gdx.app.log(tag.name(), message);
	}

	public static <E extends Enum<E>> void logBlock(E tag, NzLoggable... objectToLogs) {
		if (!DONT_LOG && getTag(tag)) {
			Gdx.app.log(tag.name(), "======== Start ============");
			for (NzLoggable loggable : objectToLogs) {
				Gdx.app.log(loggable.gdxLogTag(), loggable.gdxLogValue());
			}
			Gdx.app.log(tag.name(), "======== End ============");
		}
	}

	// ============= error
	public static <E extends Enum<E>> void error(E tag, String tagToDisplay, String message) {
		if (!DONT_LOG && getTag(tag))
			Gdx.app.error(tagToDisplay, message);
	}

	public static <E extends Enum<E>> void error(E tag, String message) {
		if (!DONT_LOG && getTag(tag))
			Gdx.app.error(tag.name(), message);
	}

	public static <E extends Enum<E>> void errorBlock(E tag, NzLoggable... objectToLogs) {
		if (!DONT_LOG && getTag(tag)) {
			Gdx.app.error(tag.name(), "======== Start ============");
			for (NzLoggable loggable : objectToLogs) {
				Gdx.app.error(loggable.gdxLogTag(), loggable.gdxLogValue());
			}
			Gdx.app.error(tag.name(), "======== End ============");
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
