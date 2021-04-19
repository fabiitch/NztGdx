package com.nzt.gdx.debug.hud.base;

import com.badlogic.gdx.graphics.Color;

/**
 * Used in HudDebug before init();
 */
class HudDebugItem {
	public String name;
	public String value;
	public Color color;
	public int position;

	public HudDebugItem(String name, String value, Color color, int position) {
		this.name = name;
		this.value = value;
		this.color = color;
		this.position = position;
	}

	public HudDebugItem(String name, String value, int position) {
		this.name = name;
		this.value = value;
		this.position = position;
	}

	public HudDebugItem(String name, String value) {
		this.name = name;
		this.value = value;
	}
}
