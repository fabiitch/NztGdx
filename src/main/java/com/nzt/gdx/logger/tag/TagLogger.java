package com.nzt.gdx.logger.tag;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;
import com.nzt.gdx.logger.utils.NzLoggable;

/**
 * wrapper class for active/desactive tag on logger a tag is active by default
 * (firstlog) and log/warn/error/debug effective if gdx.log.level is correct
 *
 * @author fabiitch
 */

//TODO voit avec l'interface ApplicationLogger si on peut pas simplement redéfinir
//TODO voir si  autorisé des tag selon le log level (utile ?)
public class TagLogger {

	private final static Map<Enum<?>, Boolean> tagMap = new HashMap<Enum<?>, Boolean>();
	public static boolean DONT_LOG = false;

	public static void clearTags() {
		tagMap.clear();
	}

	public static Set<Enum<?>> getTags() {
		return tagMap.keySet();
	}

	// ============= active/desactive
	public static <E extends Enum<E>> void activeTag(E... tags) {
		for (E tag : tags)
			tagMap.put(tag, true);
	}

	public static <E extends Enum<?>> void activeAllTag(Class<E> enumTag) {
		for (E o : enumTag.getEnumConstants()) {
			tagMap.put(o, true);
		}
	}

	public static <E extends Enum<E>> void desactiveTag(E... tags) {
		for (E tag : tags)
			tagMap.put(tag, false);
	}

	public static <E extends Enum<E>> void desactiveAllExcept(E... tags) {
		for (Map.Entry<Enum<?>, Boolean> enumBooleanEntry : tagMap.entrySet()) {
			enumBooleanEntry.setValue(false);
		}
		for (E tag : tags)
			tagMap.put(tag, true);
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

	public static <E extends Enum<E>> void debugBlock(E tag, String msg, NzLoggable... objectToLogs) {
		if (!DONT_LOG && getTag(tag)) {
			Gdx.app.debug(tag.name(), "= Start : " + msg);
			for (int i = 0, n = objectToLogs.length; i < n; i++) {
				Gdx.app.debug(objectToLogs[i].gdxLogTag(), objectToLogs[i].gdxLogValue());
			}
			Gdx.app.debug(tag.name(), "= End : " + msg);
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

	public static <E extends Enum<E>> void logBlock(E tag, String msg, NzLoggable... objectToLogs) { // TODO vraiment
																										// utlisable ?
		if (!DONT_LOG && getTag(tag)) {
			Gdx.app.log(tag.name(), "= Start : " + msg);
			for (int i = 0, n = objectToLogs.length; i < n; i++) {
				Gdx.app.log(objectToLogs[i].gdxLogTag(), objectToLogs[i].gdxLogValue());
			}
			Gdx.app.log(tag.name(), "= End : " + msg);
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

	public static <E extends Enum<E>> void errorBlock(E tag, String msg, Array<NzLoggable> objectToLogs) {
		if (!DONT_LOG && getTag(tag)) {
			Gdx.app.error(tag.name(), "= Start : " + msg);
			for (int i = 0, n = objectToLogs.size; i < n; i++) {
				NzLoggable nzLoggable = objectToLogs.get(i);
				Gdx.app.error(nzLoggable.gdxLogTag(), nzLoggable.gdxLogValue());
			}
			Gdx.app.error(tag.name(), "= End : " + msg);
		}
	}

	public static <E extends Enum<E>> boolean isTagActive(E tag) {
		Boolean activeTag = tagMap.get(tag);
		return activeTag != null ? activeTag : false;
	}

	/**
	 * give tags, if not exist , create it
	 *
	 * @param <E>
	 * @param tag
	 * @return
	 */
	private static <E extends Enum<E>> Boolean getTag(E tag) {
		Boolean activeTag = tagMap.get(tag);
		if (activeTag == null) {
			activeTag(tag);
			return true;
		}
		return activeTag;
	}

}
