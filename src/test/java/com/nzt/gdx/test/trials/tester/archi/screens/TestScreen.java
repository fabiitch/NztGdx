package com.nzt.gdx.test.trials.tester.archi.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.nzt.gdx.debug.gl.NzGLProfiler;
import com.nzt.gdx.debug.hud.HudDebugPosition;
import com.nzt.gdx.debug.hud.core.HudDebug;
import com.nzt.gdx.debug.perf.DT_Tracker;
import com.nzt.gdx.debug.perf.HudDebugPerformanceFrame;
import com.nzt.gdx.scene2D.nz.NzStage;
import com.nzt.gdx.test.trials.st.scene2D.Scene2DTestConstants;
import com.nzt.gdx.test.trials.tester.archi.mains.FastTesterMain;

/**
 * Test Screen with hudDebug
 * And GLProfile (not enabled by default)
 */
public abstract class TestScreen extends SimpleTestScreen {
    protected NzStage nzStage;
    protected Skin skin;
    private final HudDebug hudDebug;
    protected NzGLProfiler glProfiler;
    protected DT_Tracker dt_tracker;
    private HudDebugPerformanceFrame hudDebugPerformanceFrame;

    public TestScreen(FastTesterMain main) {
        super(main);
        this.nzStage = new NzStage();
        this.skin = new Skin(Gdx.files.internal(Scene2DTestConstants.UI_SKIN));
        this.hudDebug = new HudDebug(nzStage, skin);
        this.glProfiler = main.logManager.nzGlProfiler;
        this.glProfiler.setScreen(this);
        this.hudDebugPerformanceFrame = new HudDebugPerformanceFrame(HudDebugPosition.BOT_RIGHT, Color.WHITE, false);
        this.addInfoTestMsg();
        this.dt_tracker = new DT_Tracker(HudDebugPosition.TOP_LEFT, Color.WHITE, 60, 120);
    }

    protected TestScreen(FastTesterMain main, HudDebugPerformanceFrame hudDebugPerformanceFrame) {
        super(main);
        this.nzStage = new NzStage();
        this.skin = new Skin(Gdx.files.internal(Scene2DTestConstants.UI_SKIN));
        this.hudDebug = new HudDebug(nzStage, skin);
        this.glProfiler = main.logManager.nzGlProfiler;
        this.glProfiler.setScreen(this);
        this.hudDebugPerformanceFrame = hudDebugPerformanceFrame;
        this.addInfoTestMsg();
        this.dt_tracker = new DT_Tracker(HudDebugPosition.TOP_LEFT, Color.WHITE, 60, 120);
    }

    /**
     * Dont use with this param in screen
     * use super(main,true)
     */
    protected TestScreen(FastTesterMain main, boolean enableGlProfiler) {
        this(main);
        if (enableGlProfiler) {
            glProfiler.setScreen(this);
            addHudToGlProfiler();
        }
    }

    protected void addInfoTestMsg() {
        if (getTestExplication() != null) {
            HudDebug.addTopLeft("ST Target", getTestExplication(), Color.RED);
            HudDebug.addTopLeft("-------", "-------");
        }
    }

    protected void debugMsg(String key, Object value, Color color) {
        if (HudDebug.exist(key)) {
            HudDebug.update(key, value);
            if (!HudDebug.getColor(key).equals(color))
                HudDebug.updateColor(key, color);
        } else
            HudDebug.addBotLeft(key, value, color);
    }

    protected void debugMsg(String key, Object value) {
        debugMsg(key, value, Color.WHITE);
    }

    protected void infoMsg(String s) {
        HudDebug.addTopLeft(s, "");
    }

    protected void infoMsg(String s, Color color) {
        HudDebug.addTopLeft(s, "", color);
    }

    protected void infoMsg(String key, String value) {
        HudDebug.addTopLeft(key, value);
    }

    protected void infoMsg(String key, String value, Color color) {
        HudDebug.addTopLeft(key, value, color);
    }


    public abstract String getTestExplication();

    //TODO ???
    public void addHudToGlProfiler() {
        glProfiler.initHudDebug(HudDebugPosition.BOT_RIGHT, Color.WHITE);
    }

    public abstract void renderTestScreen(float dt);

    @Override
    protected final void renderScreen(float dt) {
        renderTestScreen(dt);
        nzStage.act();
        nzStage.draw();
        glProfiler.updateHudDebug();
        dt_tracker.update();
        hudDebugPerformanceFrame.update(dt);
    }

    public abstract void disposeTestScreen();

    @Override
    public final void doDispose() {
        nzStage.dispose();
        skin.dispose();
        disposeTestScreen();
    }

    public void log(String log) {
        Gdx.app.log(this.getClass().getSimpleName(), log);
    }

    public void error(String error) {
        Gdx.app.error(this.getClass().getSimpleName(), error);
    }

    protected void setMsgNotImpl() {
        glProfiler.removeHudDebug();
        setMsg("Not Impl");
    }

    protected void setMsgWIP() {
        glProfiler.removeHudDebug();
        setMsg("WIP");
    }

    protected void setMsg(String msg) {
        glProfiler.removeHudDebug();
        HudDebug.addTopRight(msg, msg, Color.RED);
        HudDebug.addTopMiddle(msg, msg, Color.RED);
        HudDebug.addTopLeft(msg, msg, Color.RED);
        HudDebug.addBotRight(msg, msg, Color.RED);
        HudDebug.addBotLeft(msg, msg, Color.RED);
        HudDebug.addBotMiddle(msg, msg, Color.RED);
        HudDebug.addMiddleRight(msg, msg, Color.RED);
        HudDebug.addMiddleLeft(msg, msg, Color.RED);
    }

    public Vector2 v(float x, float y) {
        return new Vector2(x, y);
    }

    public Vector3 v(float x, float y, float z) {
        return new Vector3(x, y, z);
    }
}
