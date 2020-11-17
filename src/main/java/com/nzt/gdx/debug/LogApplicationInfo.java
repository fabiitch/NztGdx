package com.nzt.gdx.debug;

import com.badlogic.gdx.Gdx;
import com.nzt.gdx.logger.LoggerBlock;
import com.nzt.gdx.logger.LoggerUtils;
import com.nzt.gdx.logger.tag.LogTagsBase;
import com.nzt.gdx.logger.tag.TagLogger;

/**
 * Log les info de l'appli
 *
 * @author fabiitch
 */
public class LogApplicationInfo {

    public static void logInit() {
        LoggerBlock.startBlockError(LogTagsBase.INIT.name() + " Application Info");
        TagLogger.error(LogTagsBase.INIT, "LogLevel", "" + Gdx.app.getLogLevel());
        TagLogger.error(LogTagsBase.INIT, "App type", "" + Gdx.app.getType());
        TagLogger.error(LogTagsBase.INIT, "Android/Ios version", "" + Gdx.app.getVersion());
        TagLogger.error(LogTagsBase.INIT, "Java Heap", "" + Gdx.app.getJavaHeap());
        TagLogger.error(LogTagsBase.INIT, "Java Native Heap", "" + Gdx.app.getNativeHeap());
        LoggerBlock.endBlockError(LogTagsBase.INIT.name() + " Application Info");
    }

    //TODO voir aussi avec NET pour groupé
    public static void logGraphics() {
        LoggerBlock.startBlockError(LogTagsBase.INIT.name() + " Graphics Info");
        TagLogger.error(LogTagsBase.INIT, "getWidth", "" + Gdx.graphics.getWidth());
        TagLogger.error(LogTagsBase.INIT, "getHeight", "" + Gdx.graphics.getHeight());

        TagLogger.error(LogTagsBase.INIT, "getBackBufferWidth", "" + Gdx.graphics.getBackBufferWidth());
        TagLogger.error(LogTagsBase.INIT, "getBackBufferHeight", "" + Gdx.graphics.getBackBufferHeight());

        TagLogger.error(LogTagsBase.INIT, "getDensity", "" + Gdx.graphics.getDensity());

        TagLogger.error(LogTagsBase.INIT, "getFramesPerSecond", "" + Gdx.graphics.getFramesPerSecond());
        TagLogger.error(LogTagsBase.INIT, "getDeltaTime", "" + Gdx.graphics.getDeltaTime());

        TagLogger.error(LogTagsBase.INIT, "getGLVersion", "" + Gdx.graphics.getGLVersion().getDebugVersionString());
        if (Gdx.graphics.getGL20() != null)
            TagLogger.error(LogTagsBase.INIT, "getGL20", "" + Gdx.graphics.getGL20().getClass().getSimpleName());
        else
            TagLogger.error(LogTagsBase.INIT, "getGL20", "No GL20");
        if (Gdx.graphics.getGL30() != null)
            TagLogger.error(LogTagsBase.INIT, "getGL30", "" + Gdx.graphics.getGL30().getClass().getSimpleName());
        else
            TagLogger.error(LogTagsBase.INIT, "getGL30", "No GL30");

        TagLogger.error(LogTagsBase.INIT, "getType", "" + Gdx.graphics.getType().name());

        TagLogger.error(LogTagsBase.INIT, "getBufferFormat", "" + Gdx.graphics.getBufferFormat().toString());
        TagLogger.error(LogTagsBase.INIT, "getDisplayMode", "" + Gdx.graphics.getDisplayMode().toString());


        TagLogger.error(LogTagsBase.INIT, "getPpcX", "" + Gdx.graphics.getPpcX());
        TagLogger.error(LogTagsBase.INIT, "getPpcY", "" + Gdx.graphics.getPpcY());
        TagLogger.error(LogTagsBase.INIT, "getPpiX", "" + Gdx.graphics.getPpiX());
        TagLogger.error(LogTagsBase.INIT, "getPpiY", "" + Gdx.graphics.getPpiY());

        TagLogger.error(LogTagsBase.INIT, "getSafeInsetBottom", "" + Gdx.graphics.getSafeInsetBottom());
        TagLogger.error(LogTagsBase.INIT, "getSafeInsetTop", "" + Gdx.graphics.getSafeInsetTop());
        TagLogger.error(LogTagsBase.INIT, "getSafeInsetLeft", "" + Gdx.graphics.getSafeInsetLeft());
        TagLogger.error(LogTagsBase.INIT, "getSafeInsetRight", "" + Gdx.graphics.getSafeInsetRight());
        LoggerBlock.endBlockError(LogTagsBase.INIT.name() + " Graphics Info");
    }
}
