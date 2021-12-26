package com.nzt.gdx.logger.tag;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;
import com.nzt.gdx.logger.TagLoggerUtils;
import com.nzt.gdx.logger.utils.NzLoggable;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * wrapper class for active/desactive tag on logger a tag is active by default
 * the log/debug/error effective if gdx.log.level is correct
 */

//TODO tres important vérifié les nb d'instance d'enum
//TODO a revoir pour le fameux final sur loglevel
//TODO com.badlogic.gdx.ApplicationLogger  doit extends sa
public class TagLogger {

    private final static Map<Enum<?>, Boolean> tagMap = new HashMap<Enum<?>, Boolean>();
    public static boolean DONT_LOG = false;

    private TagLogger() {
    }

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

    public static <E extends Enum<E>> void logWithLevel(int logLevel, E tag, String message) {
        if (logLevel == Application.LOG_ERROR) {
            error(tag, message);
        } else if (logLevel == Application.LOG_INFO) {
            info(tag, message);
        } else if (logLevel == Application.LOG_DEBUG) {
            debug(tag, message);
        }
    }

    public static <E extends Enum<E>> void logWithLevel(int logLevel, E tag, String tagToDisplay, String message) {
        if (logLevel >= Application.LOG_ERROR) {
            error(tag, tagToDisplay, message);
        } else if (logLevel >= Application.LOG_INFO) {
            info(tag, tagToDisplay, message);
        } else if (logLevel >= Application.LOG_DEBUG) {
            debug(tag, tagToDisplay, message);
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
            TagLoggerUtils.debugStart(tag.name(), msg);
            for (int i = 0, n = objectToLogs.length; i < n; i++) {
                Gdx.app.debug(objectToLogs[i].gdxLogTag(), objectToLogs[i].gdxLogValue());
            }
            TagLoggerUtils.debugEnd(tag.name(), msg);
        }
    }

    // ============= info
    public static <E extends Enum<E>> void info(E tag, String tagToDisplay, String message) {
        if (!DONT_LOG && getTag(tag))
            Gdx.app.log(tagToDisplay, message);
    }

    public static <E extends Enum<E>> void info(E tag, String message) {
        if (!DONT_LOG && getTag(tag))
            Gdx.app.log(tag.name(), message);
    }

    public static <E extends Enum<E>> void infoBlock(E tag, String msg, NzLoggable objectToLog) {
        if (!DONT_LOG && getTag(tag)) {
            TagLoggerUtils.infoStart(tag.name(), msg);
            Gdx.app.log(objectToLog.gdxLogTag(), objectToLog.gdxLogValue());
            TagLoggerUtils.infoEnd(tag.name(), msg);
        }
    }

    public static <E extends Enum<E>> void infoBlock(E tag, String msg, NzLoggable... objectToLogs) {
        if (!DONT_LOG && getTag(tag)) {
            TagLoggerUtils.infoStart(tag.name(), msg);
            for (int i = 0, n = objectToLogs.length; i < n; i++) {
                Gdx.app.log(objectToLogs[i].gdxLogTag(), objectToLogs[i].gdxLogValue());
            }
            TagLoggerUtils.infoEnd(tag.name(), msg);
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
            TagLoggerUtils.errorStart(tag.name(), msg);
            for (int i = 0, n = objectToLogs.size; i < n; i++) {
                NzLoggable nzLoggable = objectToLogs.get(i);
                Gdx.app.error(nzLoggable.gdxLogTag(), nzLoggable.gdxLogValue());
            }
            TagLoggerUtils.errorEnd(tag.name(), msg);
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
