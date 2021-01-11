package com.nzt.gdx.debug.hud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.nzt.gdx.debug.hud.base.HudDebug;

public class HudGlobalInfo {

    public HudGlobalInfo(Color color) {
        HudDebug.instance.addBotLeft("FPS", Gdx.graphics.getFramesPerSecond(), color);
        HudDebug.instance.addTopLeft("DT", 0, color);
        HudDebug.instance.addTopLeft("NativeHeap", Gdx.app.getNativeHeap(), color);
        HudDebug.instance.addTopLeft("JavaHeap", Gdx.app.getJavaHeap(), color);
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
