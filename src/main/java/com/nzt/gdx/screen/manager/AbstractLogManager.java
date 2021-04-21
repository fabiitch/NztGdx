package com.nzt.gdx.screen.manager;

import com.badlogic.gdx.Gdx;
import com.nzt.gdx.debug.gl.NzGLProfiler;
import com.nzt.gdx.logger.config.InputLoggerConfig;
import com.nzt.gdx.logger.tag.LogTagsBase;
import com.nzt.gdx.logger.tag.TagLogger;
import com.nzt.gdx.main.AbstractMain;

/**
 * Abstract LogManager, used in {@link AbstractMain}
 */
public abstract class AbstractLogManager {

    public static AbstractLogManager instance;
    public InputLoggerConfig inputLoggerConfig;
    public NzGLProfiler nzGlProfiler;
    public int logLevel;

    // log level 0,1,2,3
    public AbstractLogManager(int logLevel) {
        this.logLevel = logLevel;
        Gdx.app.setLogLevel(logLevel);
        this.inputLoggerConfig = configureInputLog();
        configureTags();
        AbstractLogManager.instance = this;
        this.nzGlProfiler = new NzGLProfiler(null);
    }

    public void setLogLevel(int logLevel) {
        this.logLevel = logLevel;
        Gdx.app.setLogLevel(logLevel);
    }

    public void activeGlProfiler() {
        nzGlProfiler.active();
        TagLogger.activeTag(LogTagsBase.OPEN_GL_PROFILER);
    }

    public void activePerfFrame() {
        TagLogger.activeTag(LogTagsBase.PERFORMANCE);
    }

    public abstract void configureTags();

    public abstract InputLoggerConfig configureInputLog();
}
