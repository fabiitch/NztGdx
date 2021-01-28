package com.nzt.gdx.debug.hud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.nzt.gdx.debug.hud.base.HudDebug;

public class HudGlobalInfo {

	public HudGlobalInfo(Color color, int positionHud) {
		HudDebug.addItem(positionHud, "FPS", Gdx.graphics.getFramesPerSecond(), color);
		HudDebug.addItem(positionHud, "DT", 0, color);
		HudDebug.addItem(positionHud, "NativeHeap", Gdx.app.getNativeHeap(), color);
		HudDebug.addItem(positionHud, "JavaHeap", Gdx.app.getJavaHeap(), color);
	}

	public HudGlobalInfo() {
		this(Color.WHITE, HudDebugPosition.topLeft);
	}

	public void update(float dt) {
		HudDebug.update("FPS", Gdx.graphics.getFramesPerSecond());
		HudDebug.update("DT", dt);
		HudDebug.update("NativeHeap", Gdx.app.getNativeHeap());
		HudDebug.update("JavaHeap", Gdx.app.getJavaHeap());
	}
}
