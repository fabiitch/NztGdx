package com.nzt.gdx.debug.hud.base;

import com.badlogic.gdx.graphics.Color;
import com.nzt.gdx.debug.hud.HudDebugPosition;

/**
 * Used in HudDebug before init();
 */
class PreInitItem {
//	public String key; // key in map for HudDebug.update(key,value)
	public String name; // name displayed
	public String value;
	public Color color;
	public int positionOnStage;

//	public PreInitItem(String key, String name, String value, int positionOnStage, Color color) {
//		this.key = key;
//		this.name = name;
//		this.value = value;
//		this.color = color;
//		this.positionOnStage = positionOnStage;
//	}

	public PreInitItem(String name, String value, int positionOnStage, Color color) {
		this.name = name;
		this.value = value;
		this.color = color;
		this.positionOnStage = positionOnStage;
	}

	public PreInitItem(String name, String value) {
		this(name, value, HudDebugPosition.TOP_LEFT, Color.WHITE);
	}
}
