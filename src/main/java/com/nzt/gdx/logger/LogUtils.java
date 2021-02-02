package com.nzt.gdx.logger;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;

/**
 * utils pout log, aucun check avec le tag logger n'est fait
 */
public class LogUtils {

    public static void logStart(int logLevel, String tag, String nameBlock) {
        if (logLevel >= Application.LOG_ERROR) {
            errorStart(tag, nameBlock);
        } else if (logLevel >= Application.LOG_INFO) {
            infoStart(tag, nameBlock);
        } else if (logLevel >= Application.LOG_DEBUG) {
            debugStart(tag, nameBlock);
        }
    }

    public static void logEnd(int logLevel, String tag, String nameBlock) {
        if (logLevel >= Application.LOG_ERROR) {
            errorEnd(tag, nameBlock);
        } else if (logLevel >= Application.LOG_INFO) {
            infoEnd(tag, nameBlock);
        } else if (logLevel >= Application.LOG_DEBUG) {
            debugEnd(tag, nameBlock);
        }
    }

    public static void infoStart(String tag, String nameBlock) {
        Gdx.app.log(tag, "== Start " + nameBlock + "==");
    }

    public static void infoEnd(String tag, String nameBlock) {
        Gdx.app.log(tag, "== End " + nameBlock + "==");
    }

    public static void debugStart(String tag, String nameBlock) {
        Gdx.app.debug(tag, "== Start " + nameBlock + "==");
    }

    public static void debugEnd(String tag, String nameBlock) {
        Gdx.app.debug(tag, "== End " + nameBlock + "==");
    }

    public static void errorStart(String tag, String nameBlock) {
        Gdx.app.error(tag, "== Start " + nameBlock + "==");
    }

    public static void errorEnd(String tag, String nameBlock) {
        Gdx.app.error(tag, "== End " + nameBlock + "==");
    }
}
