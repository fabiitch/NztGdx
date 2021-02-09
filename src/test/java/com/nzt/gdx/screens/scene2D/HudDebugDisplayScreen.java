package com.nzt.gdx.screens.scene2D;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.nzt.gdx.main.AbstractMain;
import com.nzt.gdx.screen.SimpleScreen;
import com.nzt.gdx.debug.hud.base.HudDebug;
import com.nzt.gdx.tester.main.FastTesterMain;
import com.nzt.gdx.tester.main.StarterTestConfig;

public class HudDebugDisplayScreen extends SimpleScreen {

    public static void main(String args[]) {
//        StarterTestConfig.startLwjgl(new FastTesterMain(HudDebugDisplayScreen.class), 800, 400);
    }

    private Stage stage;
    private HudDebug debugHud;

    public HudDebugDisplayScreen(AbstractMain main) {
        super(main);
        stage = new Stage();
        this.debugHud = new HudDebug(stage);
    }

    @Override
    public void doShow() {
        for (int i = 0; i < 5; i++) {
            HudDebug.instance.addTopLeft("addTopLeft " + i, Gdx.app.getJavaHeap(), Color.RED);
        }
        for (int i = 0; i < 5; i++) {
            HudDebug.instance.addTopMiddle("addTopMiddle " + i, Gdx.app.getJavaHeap(), Color.WHITE);
        }
        for (int i = 0; i < 5; i++) {
            HudDebug.instance.addTopRight("addTopRight " + i, Gdx.app.getJavaHeap(), Color.YELLOW);
        }
        for (int i = 0; i < 5; i++) {
            HudDebug.instance.addBotLeft("addBotLeft " + i, Gdx.app.getJavaHeap(), Color.GOLD);
        }
        for (int i = 0; i < 5; i++) {
            HudDebug.instance.addBotMiddle("addBotMiddle " + i, Gdx.app.getJavaHeap(), Color.GREEN);
        }
        for (int i = 0; i < 5; i++) {
            HudDebug.instance.addBotRight("addBotRight" + i, Gdx.app.getJavaHeap(), Color.BROWN);
        }
        for (int i = 0; i < 5; i++) {
            HudDebug.instance.addRightMiddle("addRightMiddle" + i, Gdx.app.getJavaHeap(), Color.GRAY);
        }
        for (int i = 0; i < 5; i++) {
            HudDebug.instance.addLeftMiddle("addLeftMiddle" + i, Gdx.app.getJavaHeap(), Color.CYAN);
        }
    }

    @Override
    protected void renderScreen(float dt) {
        stage.act();
        stage.draw();
    }
}
