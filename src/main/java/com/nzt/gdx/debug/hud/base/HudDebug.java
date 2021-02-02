package com.nzt.gdx.debug.hud.base;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.nzt.gdx.debug.utils.DebugDisplayUtils;
import com.nzt.gdx.debug.hud.HudDebugPosition;

public class HudDebug {
	public static HudDebug instance;
	private static Array<HudDebugItem> arrayBeforeInit;

	private HudDebugContainer container;

	public HudDebug(Stage stage) {
		this.container = new HudDebugContainer(stage);
		HudDebug.instance = this;

		if (arrayBeforeInit != null) {
			for (HudDebugItem item : arrayBeforeInit) {
				this.container.addItem(item);
			}
			HudDebug.arrayBeforeInit.clear();
			HudDebug.arrayBeforeInit = null;
		}
	}

	public static void update(String name, Object value) {
		if (instance != null)
			instance.container.update(name, value);
	}

	private static void addInitList(String name, Object value, Color color, int position) {
		if (arrayBeforeInit == null)
			arrayBeforeInit = new Array<>();

		arrayBeforeInit.add(new HudDebugItem(name, DebugDisplayUtils.printValue(value), color, position));
	}

	public static void addTopLeft(String name, Object value, Color color) {
		if (instance == null) {
			addInitList(name, value, color, HudDebugPosition.topLeft);
		} else {
			instance.container.addTopLeft(name, value, color);
		}
	}

	public static void addTopLeft(String name, Object value) {
		addTopLeft(name, value, Color.WHITE);
	}

	public static void addTopMiddle(String name, Object value, Color color) {
		if (instance == null) {
			addInitList(name, value, color, HudDebugPosition.topMiddle);
		} else {
			instance.container.addTopMiddle(name, value, color);
		}
	}

	public static void addTopMiddle(String name, Object value) {
		addTopMiddle(name, value, Color.WHITE);
	}

	public static void addTopRight(String name, Object value, Color color) {
		if (instance == null) {
			addInitList(name, value, color, HudDebugPosition.topRight);
		} else {
			instance.container.addTopRight(name, value, color);
		}
	}

	public static void addTopRight(String name, Object value) {
		addTopRight(name, value, Color.WHITE);
	}

	public static void addBotLeft(String name, Object value, Color color) {
		if (instance == null) {
			addInitList(name, value, color, HudDebugPosition.botLeft);
		} else {
			instance.container.addBotLeft(name, value, color);
		}
	}

	public static void addBotLeft(String name, Object value) {
		addBotLeft(name, value, Color.WHITE);
	}

	public static void addBotMiddle(String name, Object value, Color color) {
		if (instance == null) {
			addInitList(name, value, color, HudDebugPosition.botMiddle);
		} else {
			instance.container.addBotMiddle(name, value, color);
		}
	}

	public static void addBotMiddle(String name, Object value) {
		addBotMiddle(name, value, Color.WHITE);
	}

	public static void addBotRight(String name, Object value, Color color) {
		if (instance == null) {
			addInitList(name, value, color, HudDebugPosition.botRight);
		} else {
			instance.container.addBotRight(name, value, color);
		}
	}

	public static void addBotRight(String name, Object value) {
		addBotRight(name, value, Color.WHITE);
	}

	public static void addLeftMiddle(String name, Object value, Color color) {
		if (instance == null) {
			addInitList(name, value, color, HudDebugPosition.leftMiddle);
		} else {
			instance.container.addLeftMiddle(name, value, color);
		}
	}

	public static void addLeftMiddle(String name, Object value) {
		addLeftMiddle(name, value, Color.WHITE);
	}

	public static void addRightMiddle(String name, Object value, Color color) {
		if (instance == null) {
			addInitList(name, value, color, HudDebugPosition.rightMiddle);
		} else {
			instance.container.addRightMiddle(name, value, color);
		}
	}

	public static void addRightMiddle(String name, Object value) {
		addRightMiddle(name, value, Color.WHITE);
	}

	public static void addItem(int position, String name, Object value, Color color) {
		if (instance == null) {
			addInitList(name, value, color, position);
		} else {
			instance.add(position, name, value, color);
		}
	}

	public void add(int position, String name, Object value, Color color) {
		switch (position) {
		case HudDebugPosition.topLeft:
			HudDebug.addTopLeft(name, value, color);
			break;
		case HudDebugPosition.topMiddle:
			HudDebug.addTopMiddle(name, value, color);
			break;
		case HudDebugPosition.topRight:
			HudDebug.addTopRight(name, value, color);
			break;
		case HudDebugPosition.botLeft:
			HudDebug.addBotLeft(name, value, color);
			break;
		case HudDebugPosition.botMiddle:
			HudDebug.addBotMiddle(name, value, color);
			break;
		case HudDebugPosition.botRight:
			HudDebug.addBotRight(name, value, color);
			break;
		case HudDebugPosition.leftMiddle:
			HudDebug.addLeftMiddle(name, value, color);
			break;
		case HudDebugPosition.rightMiddle:
			HudDebug.addRightMiddle(name, value, color);
			break;
		}
	}

	public void add(int position, String name, Object value) {
		this.add(position, name, value, Color.WHITE);
	}
}
