package com.nzt.gdx.debug;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.profiling.GLProfiler;
import com.nzt.gdx.logger.LogUtils;
import com.nzt.gdx.logger.tag.LogTagsBase;
import com.nzt.gdx.logger.tag.TagLogger;
import com.nzt.gdx.screen.AbstractScreen;


//TODO boolean en constant pour enlevé les if a la compil
public class NzGLProfiler {
    private GLProfiler profiler;
    private String screenName;

    private static boolean logOneShot = false;

    public static void logOneShot(){
        logOneShot = true;
    }

    public NzGLProfiler(AbstractScreen screen) {
        setScreen(screen);
        this.profiler = new GLProfiler(Gdx.graphics);
    }

    public void setScreen(AbstractScreen screen) {
        this.screenName = screen != null ? screen.getClass().getSimpleName() : "No screen";
    }

    public void active() {
        profiler.enable();
    }

    public void desactive() {
        profiler.disable();
    }

    public void endFrame() {
        if (profiler.isEnabled()) {
            if (logOneShot) {
                logOneShot = false;
            } else if (TagLogger.isTagActive(LogTagsBase.OPEN_GL_PROFILER)) {
                log();
            }
            profiler.reset();
        }
    }

    public void log() {
        LogUtils.debugStart(LogTagsBase.B2D_INFO.name(), "NzGlProfiler " + screenName);
        Gdx.app.debug("Listener", profiler.getListener().getClass().getSimpleName());
        Gdx.app.debug("getCalls", profiler.getCalls() + "");
        Gdx.app.debug("getDrawCalls", profiler.getCalls() + "");
        Gdx.app.debug("getShaderSwitches", profiler.getShaderSwitches() + "");
        Gdx.app.debug("getTextureBindings", profiler.getTextureBindings() + "");
        Gdx.app.debug("getVertexCount", profiler.getVertexCount() + "");
        Gdx.app.debug("getDrawCalls", profiler.getCalls() + "");
        LogUtils.debugEnd(LogTagsBase.B2D_INFO.name(), "NzGlProfiler " + screenName);
    }
}