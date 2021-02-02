package com.nzt.gdx.logger;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.nzt.gdx.logger.tag.TagLogger;

public class LoggerTagBlockUtils {
    public static <E extends Enum<E>> void startBlock(int logLevel, E tag, String nameBlock) {
        if (logLevel >= Application.LOG_ERROR) {
            startBlockError(tag, nameBlock);
        } else if (logLevel >= Application.LOG_INFO) {
            startBlockInfo(tag, nameBlock);
        } else if (logLevel >= Application.LOG_DEBUG) {
            startBlockDebug(tag, nameBlock);
        }
    }

    public static <E extends Enum<E>> void endBlock(int logLevel, E tag, String nameBlock) {
        if (logLevel >= Application.LOG_ERROR) {
            endBlockError(tag, nameBlock);
        } else if (logLevel >= Application.LOG_INFO) {
            endBlockInfo(tag, nameBlock);
        } else if (logLevel >= Application.LOG_DEBUG) {
            endBlockDebug(tag, nameBlock);
        }
    }

    public static <E extends Enum<E>> void startBlockDebug(E tag, String nameBlock) {
        if (TagLogger.isTagActive(tag))
            Gdx.app.debug(tag.name(), "== Start " + nameBlock + "==");
    }

    public static <E extends Enum<E>> void endBlockDebug(E tag, String nameBlock) {
        if (TagLogger.isTagActive(tag))
            Gdx.app.debug(tag.name(), "== End " + nameBlock + "==");
    }

    public static <E extends Enum<E>> void startBlockInfo(E tag, String nameBlock) {
        if (TagLogger.isTagActive(tag))
            Gdx.app.log(tag.name(), "== Start " + nameBlock + "==");
    }

    public static <E extends Enum<E>> void endBlockInfo(E tag, String nameBlock) {
        if (TagLogger.isTagActive(tag))
            Gdx.app.log(tag.name(), "== End " + nameBlock + "==");
    }

    public static <E extends Enum<E>> void startBlockError(E tag, String nameBlock) {
        if (TagLogger.isTagActive(tag))
            Gdx.app.error(tag.name(), "== Start " + nameBlock + "==");
    }

    public static <E extends Enum<E>> void endBlockError(E tag, String nameBlock) {
        if (TagLogger.isTagActive(tag))
            Gdx.app.error(tag.name(), "== End " + nameBlock + "==");
    }

}
