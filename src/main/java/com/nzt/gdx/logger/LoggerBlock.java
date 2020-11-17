package com.nzt.gdx.logger;

import com.badlogic.gdx.Gdx;

public class LoggerBlock {

    public static void startBlockDebug(String tag) {
        Gdx.app.debug(tag, "Start =======================");
    }

    public static void startBlockLog(String tag) {
        Gdx.app.log(tag, "Start =======================");
    }

    public static void startBlockError(String tag) {
        Gdx.app.error(tag, "Start =======================");
    }

    public static void endBlockDebug(String tag) {
        Gdx.app.error(tag, "End =======================");
    }

    public static void endBlockLog(String tag) {
        Gdx.app.debug(tag, "End =======================");
    }

    public static void endBlockError(String tag) {
        Gdx.app.log(tag, "End =======================");
    }


}
