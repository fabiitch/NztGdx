package com.nzt.gdx.logger;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.nzt.gdx.logger.tag.TagLogger;

public class LoggerUtils {
    public static <E extends Enum<E>> void startBlock(int logLevel, E tag, String nameBlock) {
        if (logLevel == Application.LOG_ERROR) {
            startBlockError(tag);
        } else if (logLevel == Application.LOG_INFO) {
            startBlockLog(tag);
        } else if (logLevel == Application.LOG_DEBUG) {
            startBlockDebug(tag);
        }
    }

    public static <E extends Enum<E>> void endBlock(int logLevel, E tag) {
        if (logLevel == Application.LOG_ERROR) {
            endBlockError(tag);
        } else if (logLevel == Application.LOG_INFO) {
            endBlockLog(tag);
        } else if (logLevel == Application.LOG_DEBUG) {
            endBlockDebug(tag);
        }
    }

    public static <E extends Enum<E>> void startBlockDebug(E tag) {
        if (TagLogger.isTagActive(tag))
            Gdx.app.debug(tag.name(), "Start =======================");
    }

    public static <E extends Enum<E>> void startBlockLog(E tag) {
        if (TagLogger.isTagActive(tag))
            Gdx.app.log(tag.name(), "Start =======================");
    }

    public static <E extends Enum<E>> void startBlockError(E tag) {
        if (TagLogger.isTagActive(tag))
            Gdx.app.error(tag.name(), "Start =======================");
    }

    public static <E extends Enum<E>> void endBlockDebug(E tag) {
        if (TagLogger.isTagActive(tag))
            Gdx.app.debug(tag.name(), "End =======================");
    }

    public static <E extends Enum<E>> void endBlockLog(E tag) {
        if (TagLogger.isTagActive(tag))
            Gdx.app.log(tag.name(), "End =======================");
    }

    public static <E extends Enum<E>> void endBlockError(E tag) {
        if (TagLogger.isTagActive(tag))
            Gdx.app.error(tag.name(), "End =======================");
    }

}
