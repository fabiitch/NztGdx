package com.nzt.gdx.debug.hud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.nzt.gdx.debug.hud.core.HudDebug;
import com.nzt.gdx.utils.GdxUtils;

public class HudDebugApplicationInfo {

    public HudDebugApplicationInfo(int positionOnStage, Color color) {
        HudDebug.addItem("FPS", Gdx.graphics.getFramesPerSecond(), positionOnStage, color);
        HudDebug.addItem("DT", 0, positionOnStage, color);
        HudDebug.addItem("JavaHeap", GdxUtils.getHeapMb() + " MB", positionOnStage, color);
        HudDebug.addItem("NativeHeap", GdxUtils.getNativeHeapMb() + " MB", positionOnStage, color);
        HudDebug.addItem("NbThread", Thread.activeCount(), positionOnStage, color);
        HudDebug.addItem("CurrentThread", Thread.currentThread().getName(), positionOnStage, color);
    }

    public HudDebugApplicationInfo() {
        this(HudDebugPosition.TOP_LEFT, Color.WHITE);
    }

    public void update(float dt) {
        HudDebug.update("FPS", Gdx.graphics.getFramesPerSecond());
        HudDebug.update("DT", dt);
        HudDebug.update("JavaHeap", GdxUtils.getHeapMb() + " MB");
        HudDebug.update("NativeHeap", GdxUtils.getNativeHeapMb() + " MB");

        HudDebug.update("NbThread", "" + Thread.activeCount());
        HudDebug.update("CurrentThread", Thread.currentThread().getName());
    }

    public void changeColor(Color color) {
        HudDebug.updateColor("FPS", color);
        HudDebug.updateColor("DT", color);
        HudDebug.updateColor("NativeHeap", color);
        HudDebug.updateColor("JavaHeap", color);
        HudDebug.updateColor("NbThread", color);
        HudDebug.updateColor("CurrentThread", color);
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
