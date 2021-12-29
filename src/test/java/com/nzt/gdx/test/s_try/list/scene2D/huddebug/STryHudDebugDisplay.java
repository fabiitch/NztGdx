package com.nzt.gdx.test.s_try.list.scene2D.huddebug;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.nzt.gdx.debug.hud.core.HudDebug;
import com.nzt.gdx.test.utils.archi.mains.dev.FastTesterMain;
import com.nzt.gdx.test.utils.archi.screens.ScreenTry;
import com.nzt.gdx.test.utils.screen_selector.TestScreen;

/**
 * Test HudDebug Display
 */
@TestScreen(group = "scene2D.hud debug.display")
public class STryHudDebugDisplay extends ScreenTry {

    public STryHudDebugDisplay(FastTesterMain main) {
        super(main);
        init();
    }

    public void init() {
        for (int i = 0; i < 5; i++) {
            HudDebug.addTopLeft("addTopLeft " + i, Gdx.app.getJavaHeap(), Color.RED);
        }
        for (int i = 0; i < 5; i++) {
            HudDebug.addTopMiddle("addTopMiddle " + i, Gdx.app.getJavaHeap(), Color.WHITE);
        }
        for (int i = 0; i < 5; i++) {
            HudDebug.addTopRight("addTopRight " + i, Gdx.app.getJavaHeap(), Color.YELLOW);
        }
        for (int i = 0; i < 5; i++) {
            HudDebug.addBotLeft("addBotLeft " + i, Gdx.app.getJavaHeap(), Color.GOLD);
        }
        for (int i = 0; i < 5; i++) {
            HudDebug.addBotMiddle("addBotMiddle " + i, Gdx.app.getJavaHeap(), Color.GREEN);
        }
        for (int i = 0; i < 5; i++) {
            HudDebug.addBotRight("addBotRight" + i, Gdx.app.getJavaHeap(), Color.BROWN);
        }
        for (int i = 0; i < 5; i++) {
            HudDebug.addMiddleRight("addRightMiddle" + i, Gdx.app.getJavaHeap(), Color.GRAY);
        }
        for (int i = 0; i < 5; i++) {
            HudDebug.addMiddleLeft("addLeftMiddle" + i, Gdx.app.getJavaHeap(), Color.CYAN);
        }
    }

    @Override
    public String getTestExplication() {
        return "Placement sur HudDebug";
    }

    @Override
    public void renderTestScreen(float dt) {

    }

    @Override
    public void disposeTestScreen() {

    }


}
