package com.nzt.gdx.debug.gl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.profiling.GLProfiler;
import com.badlogic.gdx.physics.box2d.World;
import com.nzt.gdx.debug.hud.base.HudDebug;
import com.nzt.gdx.logger.LogUtils;
import com.nzt.gdx.logger.tag.LogTagsBase;
import com.nzt.gdx.logger.tag.TagLogger;
import com.nzt.gdx.screen.AbstractScreen;


//TODO boolean en constant pour enlevé les if a la compil
public class NzGLProfiler {
    private GLProfiler profiler;
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


    public void initHudDebug(int positionOnStage, Color color) {
        HudDebug.addItem(positionOnStage, "Listener", profiler.getListener().getClass().getSimpleName(), color);
        HudDebug.addItem(positionOnStage, "getCalls", profiler.getCalls(), color);
        HudDebug.addItem(positionOnStage, "getDrawCalls", profiler.getCalls(), color);
        HudDebug.addItem(positionOnStage, "getShaderSwitches", profiler.getShaderSwitches(), color);
        HudDebug.addItem(positionOnStage, "getTextureBindings", profiler.getTextureBindings(), color);
        HudDebug.addItem(positionOnStage, "getVertexCount", profiler.getVertexCount(), color);
        HudDebug.addItem(positionOnStage, "getDrawCalls", profiler.getCalls(), color);
    }

    public void displayHudDebug() {
        HudDebug.update("Listener", profiler.getListener().getClass().getSimpleName());
        HudDebug.update("getCalls", profiler.getCalls());
        HudDebug.update("getDrawCalls", profiler.getCalls());
        HudDebug.update("getShaderSwitches", profiler.getShaderSwitches());
        HudDebug.update("getTextureBindings", profiler.getTextureBindings());
        HudDebug.update("getVertexCount", profiler.getVertexCount());
        HudDebug.update("getDrawCalls", profiler.getCalls());
    }
}
