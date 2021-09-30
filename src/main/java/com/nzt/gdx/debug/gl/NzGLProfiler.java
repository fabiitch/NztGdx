package com.nzt.gdx.debug.gl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.profiling.GLProfiler;
import com.nzt.gdx.debug.hud.core.HudDebug;
import com.nzt.gdx.logger.TagLoggerUtils;
import com.nzt.gdx.logger.tag.LogTagsBase;
import com.nzt.gdx.screen.AbstractScreen;

//TODO boolean en constant pour enlevé les if a la compil
//TODO voir si on fait pas un singleton private
public class NzGLProfiler {
    private final GLProfiler profiler;
    private String screenName;

    private static boolean logOneShot = false;

    public static void logOneShot() {
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

    public void reset() {
        if (profiler.isEnabled()) {
            if (logOneShot) {
                logOneShot = false;
            }
            profiler.reset();
        }
    }

    public void log() {
        TagLoggerUtils.debugStart(LogTagsBase.OPEN_GL_PROFILER.name(), "NzGlProfiler " + screenName);
        Gdx.app.debug("GlListener enabled", profiler.isEnabled() + "");
        Gdx.app.debug("getCalls", profiler.getCalls() + "");
        Gdx.app.debug("getDrawCalls", profiler.getDrawCalls() + "");
        Gdx.app.debug("getShaderSwitches", profiler.getShaderSwitches() + "");
        Gdx.app.debug("getTextureBindings", profiler.getTextureBindings() + "");
        Gdx.app.debug("getVertexCountAverage", profiler.getVertexCount().average + "");
        Gdx.app.debug("getDrawCalls", profiler.getCalls() + "");
        TagLoggerUtils.debugEnd(LogTagsBase.OPEN_GL_PROFILER.name(), "NzGlProfiler " + screenName);
    }

    public void initHudDebug(int positionOnStage, Color color) {
        HudDebug.addItem("GlListener enabled", profiler.isEnabled() + "", positionOnStage, color);
        HudDebug.addItem("getCalls", 100000, positionOnStage, color);
        HudDebug.addItem("getDrawCalls", 100000, positionOnStage, color);
        HudDebug.addItem("getShaderSwitches", 100000, positionOnStage, color);
        HudDebug.addItem("getTextureBindings", 100000, positionOnStage, color);
        HudDebug.addItem("getVertexCountAverage", 100000, positionOnStage, color);
    }

    public void updateHudDebug() {
        if (!profiler.isEnabled())
            return;
        HudDebug.update("GlListener enabled", profiler.isEnabled() + "");
        HudDebug.update("getCalls", profiler.getCalls());
        HudDebug.update("getDrawCalls", profiler.getDrawCalls());
        HudDebug.update("getShaderSwitches", profiler.getShaderSwitches());
        HudDebug.update("getTextureBindings", profiler.getTextureBindings());
        HudDebug.update("getVertexCountAverage", profiler.getVertexCount().average);
    }

    public void removeHudDebug() {
        HudDebug.remove("GlListener enabled");
        HudDebug.remove("getCalls");
        HudDebug.remove("getDrawCalls");
        HudDebug.remove("getShaderSwitches");
        HudDebug.remove("getTextureBindings");
        HudDebug.remove("getVertexCountAverage");
    }
}
