package com.nzt.gdx.debug.hud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.nzt.gdx.debug.hud.base.HudDebug;

public class HudGlobalInfo {

    public HudGlobalInfo(Color color) {
        HudDebug.addBotLeft("FPS", Gdx.graphics.getFramesPerSecond(), color);
        HudDebug.addTopLeft("DT", 0, color);
        HudDebug.addTopLeft("NativeHeap", Gdx.app.getNativeHeap(), color);
        HudDebug.addTopLeft("JavaHeap", Gdx.app.getJavaHeap(), color);
    }

    public HudGlobalInfo() {
        this(Color.WHITE);
    }

    public void update(float dt) {
        HudDebug.update("FPS", Gdx.graphics.getFramesPerSecond());
        HudDebug.update("DT", dt);
        HudDebug.update("NativeHeap", Gdx.app.getNativeHeap());
        HudDebug.update("JavaHeap", Gdx.app.getJavaHeap());
    }
}
