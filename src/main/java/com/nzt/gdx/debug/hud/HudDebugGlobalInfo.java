package com.nzt.gdx.debug.hud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.nzt.gdx.debug.hud.base.HudDebug;

public class HudDebugGlobalInfo {

	public HudDebugGlobalInfo(int positionHud, Color color) {
		HudDebug.addItem(positionHud, "FPS", Gdx.graphics.getFramesPerSecond(), color);
		HudDebug.addItem(positionHud, "DT", 0, color);
		HudDebug.addItem(positionHud, "NativeHeap", Gdx.app.getNativeHeap(), color);
		HudDebug.addItem(positionHud, "JavaHeap", Gdx.app.getJavaHeap(), color);
	}

	public HudDebugGlobalInfo() {
		this(HudDebugPosition.TOP_LEFT, Color.WHITE);
	}

	public void update(float dt) {
		HudDebug.update("FPS", Gdx.graphics.getFramesPerSecond());
		HudDebug.update("DT", dt);
		HudDebug.update("NativeHeap", Gdx.app.getNativeHeap());
		HudDebug.update("JavaHeap", Gdx.app.getJavaHeap());
	}

	public void changeColor(Color color) {
		HudDebug.changeColor("FPS", color);
		HudDebug.changeColor("DT", color);
		HudDebug.changeColor("NativeHeap", color);
		HudDebug.changeColor("JavaHeap", color);

	}

	public void removeFromHudDebug() {
		HudDebug.remove("FPS");
		HudDebug.remove("DT");
		HudDebug.remove("NativeHeap");
		HudDebug.remove("JavaHeap");

	}
}
