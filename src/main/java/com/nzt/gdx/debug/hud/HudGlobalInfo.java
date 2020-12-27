package com.nzt.gdx.debug.hud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.nzt.gdx.debug.hud.base.HudDebugDisplay;

public class HudGlobalInfo {

    public HudGlobalInfo(Color color) {
        HudDebugDisplay.instance.addTopLeft("FPS", Gdx.graphics.getFramesPerSecond(), color);
        HudDebugDisplay.instance.addTopLeft("DT", 0, color);
        HudDebugDisplay.instance.addTopLeft("NativeHeap", Gdx.app.getNativeHeap(), color);
        HudDebugDisplay.instance.addTopLeft("JavaHeap", Gdx.app.getJavaHeap(), color);
    }

    public HudGlobalInfo() {
        this(Color.WHITE);
    }

    public void update(float dt) {
        HudDebugDisplay.update("FPS", Gdx.graphics.getFramesPerSecond());
        HudDebugDisplay.update("DT", dt);
        HudDebugDisplay.update("NativeHeap", Gdx.app.getNativeHeap());
        HudDebugDisplay.update("JavaHeap", Gdx.app.getJavaHeap());
    }
}
