package com.nzt.gdx.debug.hud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.nzt.gdx.debug.hud.base.HudDebug;

public class HudDebugApplicationInfo {

	public HudDebugApplicationInfo(int positionOnStage, Color color) {
		HudDebug.addItem("FPS", Gdx.graphics.getFramesPerSecond(), positionOnStage, color);
		HudDebug.addItem("DT", 0, positionOnStage, color);
		HudDebug.addItem("NativeHeap", Gdx.app.getNativeHeap(), positionOnStage, color);
		HudDebug.addItem("JavaHeap", Gdx.app.getJavaHeap(), positionOnStage, color);
	}

	public HudDebugApplicationInfo() {
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
