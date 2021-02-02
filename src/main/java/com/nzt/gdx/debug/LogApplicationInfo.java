package com.nzt.gdx.debug;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.nzt.gdx.logger.LoggerTagBlockUtils;
import com.nzt.gdx.logger.tag.LogTagsBase;
import com.nzt.gdx.logger.tag.TagLogger;

/**
 * Log les info de l'appli
 *
 * @author fabiitch
 */
public class LogApplicationInfo {

    public static void logInit(int logLevel) {
        LoggerTagBlockUtils.startBlock(logLevel, LogTagsBase.INIT, "Application Info");
        TagLogger.logWithLevel(logLevel, LogTagsBase.INIT, "LogLevel", "" + Gdx.app.getLogLevel());
        TagLogger.logWithLevel(logLevel, LogTagsBase.INIT, "App type", "" + Gdx.app.getType());
        TagLogger.logWithLevel(logLevel, LogTagsBase.INIT, "Android/Ios version", "" + Gdx.app.getVersion());
        TagLogger.logWithLevel(logLevel, LogTagsBase.INIT, "Java Heap", "" + Gdx.app.getJavaHeap());
        TagLogger.logWithLevel(logLevel, LogTagsBase.INIT, "Java Native Heap", "" + Gdx.app.getNativeHeap());
        LoggerTagBlockUtils.endBlock(logLevel, LogTagsBase.INIT, "Application Info");
    }

    public static void logGraphics(int logLevel) {
        LoggerTagBlockUtils.startBlock(logLevel, LogTagsBase.INIT, "Graphics Info");
        TagLogger.logWithLevel(logLevel, LogTagsBase.INIT, "getWidth", "" + Gdx.graphics.getWidth());
        TagLogger.logWithLevel(logLevel, LogTagsBase.INIT, "getHeight", "" + Gdx.graphics.getHeight());

        TagLogger.logWithLevel(logLevel, LogTagsBase.INIT, "getBackBufferWidth", "" + Gdx.graphics.getBackBufferWidth());
        TagLogger.logWithLevel(logLevel, LogTagsBase.INIT, "getBackBufferHeight", "" + Gdx.graphics.getBackBufferHeight());

        TagLogger.logWithLevel(logLevel, LogTagsBase.INIT, "getDensity", "" + Gdx.graphics.getDensity());

        TagLogger.logWithLevel(logLevel, LogTagsBase.INIT, "getFramesPerSecond", "" + Gdx.graphics.getFramesPerSecond());
        TagLogger.logWithLevel(logLevel, LogTagsBase.INIT, "getDeltaTime", "" + Gdx.graphics.getDeltaTime());

        TagLogger.logWithLevel(logLevel, LogTagsBase.INIT, "getGLVersion", "" + Gdx.graphics.getGLVersion().getDebugVersionString());
        if (Gdx.graphics.getGL20() != null)
            TagLogger.logWithLevel(logLevel, LogTagsBase.INIT, "getGL20", "" + Gdx.graphics.getGL20().getClass().getSimpleName());
        else
            TagLogger.logWithLevel(logLevel, LogTagsBase.INIT, "getGL20", "No GL20");
        if (Gdx.graphics.getGL30() != null)
            TagLogger.logWithLevel(logLevel, LogTagsBase.INIT, "getGL30", "" + Gdx.graphics.getGL30().getClass().getSimpleName());
        else
            TagLogger.logWithLevel(logLevel, LogTagsBase.INIT, "getGL30", "No GL30");

        TagLogger.logWithLevel(logLevel, LogTagsBase.INIT, "getType", "" + Gdx.graphics.getType().name());

        TagLogger.logWithLevel(logLevel, LogTagsBase.INIT, "getBufferFormat", "" + Gdx.graphics.getBufferFormat().toString());
        TagLogger.logWithLevel(logLevel, LogTagsBase.INIT, "getDisplayMode", "" + Gdx.graphics.getDisplayMode().toString());


        TagLogger.logWithLevel(logLevel, LogTagsBase.INIT, "getPpcX", "" + Gdx.graphics.getPpcX());
        TagLogger.logWithLevel(logLevel, LogTagsBase.INIT, "getPpcY", "" + Gdx.graphics.getPpcY());
        TagLogger.logWithLevel(logLevel, LogTagsBase.INIT, "getPpiX", "" + Gdx.graphics.getPpiX());
        TagLogger.logWithLevel(logLevel, LogTagsBase.INIT, "getPpiY", "" + Gdx.graphics.getPpiY());

        TagLogger.logWithLevel(logLevel, LogTagsBase.INIT, "getSafeInsetBottom", "" + Gdx.graphics.getSafeInsetBottom());
        TagLogger.logWithLevel(logLevel, LogTagsBase.INIT, "getSafeInsetTop", "" + Gdx.graphics.getSafeInsetTop());
        TagLogger.logWithLevel(logLevel, LogTagsBase.INIT, "getSafeInsetLeft", "" + Gdx.graphics.getSafeInsetLeft());
        TagLogger.logWithLevel(logLevel, LogTagsBase.INIT, "getSafeInsetRight", "" + Gdx.graphics.getSafeInsetRight());

        Graphics.Monitor[] monitors = Gdx.graphics.getMonitors();
        int monitorCount = 1;
        for (Graphics.Monitor monitor : monitors) {
            TagLogger.logWithLevel(logLevel, LogTagsBase.INIT, "Monitor " + monitorCount, "Name=" + monitor.name + " virtualX= " + monitor.virtualX + " virtualY= " + monitor.virtualY);
            monitorCount++;
        }
        LoggerTagBlockUtils.endBlock(logLevel, LogTagsBase.INIT, "Graphics Info");
    }
}
