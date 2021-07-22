package com.nzt.gdx.test.trials.tester.archi.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.nzt.gdx.debug.gl.NzGLProfiler;
import com.nzt.gdx.debug.hud.HudDebugPosition;
import com.nzt.gdx.debug.hud.core.HudDebug;
import com.nzt.gdx.scene2D.nz.NzStage;
import com.nzt.gdx.test.trials.st.scene2D.Scene2DTestConstants;
import com.nzt.gdx.test.trials.tester.archi.main.FastTesterMain;

/**
 * Test Screen with hudDebug
 * And GLProfile (not enabled by default)
 */
public abstract class TestScreen extends SimpleTestScreen {
    protected NzStage nzStage;
    protected Skin skin;
    private final HudDebug debugHud;
    protected NzGLProfiler glProfiler;

    public TestScreen(FastTesterMain main) {
        super(main);
        this.nzStage = new NzStage();
        this.skin = new Skin(Gdx.files.internal(Scene2DTestConstants.UI_SKIN));
        this.debugHud = new HudDebug(nzStage, skin);
        this.glProfiler = main.logManager.nzGlProfiler;
        glProfiler.setScreen(this);
        addInfoTestMsg();
    }

    protected void addInfoTestMsg(){
        if (getExplication() != null) {
            HudDebug.addTopLeft("ST Target", getExplication());
            HudDebug.addTopLeft("--------", "--------");
        }
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

    public abstract String getExplication();

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
        HudDebug.addTopRight("Not", "Impl", Color.RED);
        HudDebug.addTopMiddle("Not", "Impl", Color.RED);
        HudDebug.addTopLeft("Not", "Impl", Color.RED);
        HudDebug.addBotRight("Not", "Impl", Color.RED);
        HudDebug.addBotLeft("Not", "Impl", Color.RED);
        HudDebug.addBotMiddle("Not", "Impl", Color.RED);
        HudDebug.addRightMiddle("Not", "Impl", Color.RED);
        HudDebug.addLeftMiddle("Not", "Impl", Color.RED);
    }

    protected void setMsg(String msg) {
        glProfiler.removeHudDebug();
        HudDebug.addTopRight(msg, msg, Color.RED);
        HudDebug.addTopMiddle(msg, msg, Color.RED);
        HudDebug.addTopLeft(msg, msg, Color.RED);
        HudDebug.addBotRight(msg, msg, Color.RED);
        HudDebug.addBotLeft(msg, msg, Color.RED);
        HudDebug.addBotMiddle(msg, msg, Color.RED);
        HudDebug.addRightMiddle(msg, msg, Color.RED);
        HudDebug.addLeftMiddle(msg, msg, Color.RED);
    }

    protected void setMsgWIP() {
        glProfiler.removeHudDebug();
        HudDebug.addTopRight("WIP", "WIP", Color.RED);
        HudDebug.addTopMiddle("WIP", "WIP", Color.RED);
        HudDebug.addTopLeft("WIP", "WIP", Color.RED);
        HudDebug.addBotRight("WIP", "WIP", Color.RED);
        HudDebug.addBotLeft("WIP", "WIP", Color.RED);
        HudDebug.addBotMiddle("WIP", "WIP", Color.RED);
        HudDebug.addRightMiddle("WIP", "WIP", Color.RED);
        HudDebug.addLeftMiddle("WIP", "WIP", Color.RED);
    }
}
