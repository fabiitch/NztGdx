package com.nzt.gdx.logger;

import com.badlogic.gdx.Gdx;

public class Logger {


    public static void startBlockDebug(String tag) {
        Gdx.app.debug(tag, "Start == " + tag);
    }

    public static void startBlockLog(String tag) {
        Gdx.app.log(tag, "Start == " + tag);
    }

    public static void startBlockError(String tag) {
        Gdx.app.error(tag, "Start == " + tag);
    }

    public static void endBlockDebug(String tag) {
        Gdx.app.error(tag, "End == " + tag);
    }

    public static void endBlockLog(String tag) {
        Gdx.app.debug(tag, "End == " + tag);
    }

    public static void endBlockError(String tag) {
        Gdx.app.log(tag, "End == " + tag);
    }


}
