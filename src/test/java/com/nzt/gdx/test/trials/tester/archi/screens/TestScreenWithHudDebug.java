package com.nzt.gdx.test.trials.tester.archi.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.nzt.gdx.debug.gl.NzGLProfiler;
import com.nzt.gdx.debug.hud.HudDebugPosition;
import com.nzt.gdx.debug.hud.base.HudDebug;
import com.nzt.gdx.scene2D.nz.NzStage;
import com.nzt.gdx.test.trials.st.scene2D.Scene2DTestConstants;
import com.nzt.gdx.test.trials.tester.archi.main.FastTesterMain;

public abstract class TestScreenWithHudDebug extends SimpleTestScreen {
    protected NzStage nzStage;
    protected Skin skin;
    private HudDebug debugHud;
    protected NzGLProfiler glProfiler;

    public TestScreenWithHudDebug(FastTesterMain main) {
        super(main);
        this.nzStage = new NzStage();
        this.skin = new Skin(Gdx.files.internal(Scene2DTestConstants.UI_SKIN));
        this.debugHud = new HudDebug(nzStage, skin);
        this.glProfiler = main.logManager.nzGlProfiler;
        glProfiler.setScreen(this);
        glProfiler.initHudDebug(HudDebugPosition.BOT_RIGHT, Color.WHITE);
    }


    public abstract void renderAfterHud(float dt);

    @Override
    protected void renderScreen(float dt) {
        nzStage.act();
        nzStage.draw();
        renderAfterHud(dt);
        glProfiler.updateHudDebug();
    }

    @Override
    public void doDispose() {
        nzStage.dispose();
        skin.dispose();
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
