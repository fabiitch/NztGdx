package com.nzt.gdx.debug.hud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.nzt.gdx.debug.hud.base.HudDebug;

public class HudDebugApplicationInfo {

    public HudDebugApplicationInfo(int positionOnStage, Color color) {
        HudDebug.addItem("FPS", Gdx.graphics.getFramesPerSecond(), positionOnStage, color);
        HudDebug.addItem("DT", 0, positionOnStage, color);
        HudDebug.addItem("JavaHeap", Gdx.app.getJavaHeap() / (1024L * 1024L) + " MB", positionOnStage, color);
        HudDebug.addItem("NativeHeap", Gdx.app.getNativeHeap() / (1024L * 1024L) + " MB", positionOnStage, color);
        HudDebug.addItem("NbThread", "" + Thread.activeCount(), positionOnStage, color);
        HudDebug.addItem("CurrentThread", Thread.currentThread().getName(), positionOnStage, color);
    }

    public HudDebugApplicationInfo() {
        this(HudDebugPosition.TOP_LEFT, Color.WHITE);
    }

    public void update(float dt) {
        HudDebug.update("FPS", Gdx.graphics.getFramesPerSecond());
        HudDebug.update("DT", dt);
        HudDebug.update("JavaHeap", Gdx.app.getJavaHeap() / (1024L * 1024L) + " MB");
        HudDebug.update("NativeHeap", Gdx.app.getNativeHeap() / (1024L * 1024L) + " MB");

        HudDebug.update("NbThread", "" + Thread.activeCount());
        HudDebug.update("CurrentThread", Thread.currentThread().getName());
    }

    public void changeColor(Color color) {
        HudDebug.changeColor("FPS", color);
        HudDebug.changeColor("DT", color);
        HudDebug.changeColor("NativeHeap", color);
        HudDebug.changeColor("JavaHeap", color);
        HudDebug.changeColor("NbThread", color);
        HudDebug.changeColor("CurrentThread", color);
    }

    public void removeFromHudDebug() {
        HudDebug.remove("FPS");
        HudDebug.remove("DT");
        HudDebug.remove("NativeHeap");
        HudDebug.remove("JavaHeap");
        HudDebug.remove("NbThread");
        HudDebug.remove("CurrentThread");
    }
}
