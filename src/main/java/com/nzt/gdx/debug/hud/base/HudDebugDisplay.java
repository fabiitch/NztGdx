package com.nzt.gdx.debug.hud.base;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.nzt.gdx.debug.DebugDisplayUtils;

public class HudDebugDisplay {
    public static HudDebugDisplay instance;
    private static Array<HudDebugItem> arrayBeforeInit;

    private HudDebugContainer container;

    public HudDebugDisplay(Stage stage) {
        this.container = new HudDebugContainer(stage);
        this.instance = this;

        if (arrayBeforeInit != null) {
            for (HudDebugItem item : arrayBeforeInit) {
                this.container.addItem(item);
            }
            this.arrayBeforeInit.clear();
            this.arrayBeforeInit = null;
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
            addInitList(name, value, color, PositionHudDebug.topLeft);
        } else {
            instance.container.addTopLeft(name, value, color);
        }
    }

    public static void addTopLeft(String name, Object value) {
        addTopLeft(name, value, Color.WHITE);
    }

    public static void addTopMiddle(String name, Object value, Color color) {
        if (instance == null) {
            addInitList(name, value, color, PositionHudDebug.topMiddle);
        } else {
            instance.container.addTopMiddle(name, value, color);
        }
    }

    public static void addTopMiddle(String name, Object value) {
        addTopMiddle(name, value, Color.WHITE);
    }

    public static void addTopRight(String name, Object value, Color color) {
        if (instance == null) {
            addInitList(name, value, color, PositionHudDebug.topRight);
        } else {
            instance.container.addTopRight(name, value, color);
        }
    }

    public static void addTopRight(String name, Object value) {
        addTopRight(name, value, Color.WHITE);
    }

    public static void addBotLeft(String name, Object value, Color color) {
        if (instance == null) {
            addInitList(name, value, color, PositionHudDebug.botLeft);
        } else {
            instance.container.addBotLeft(name, value, color);
        }
    }

    public static void addBotLeft(String name, Object value) {
        addBotLeft(name, value, Color.WHITE);
    }

    public static void addBotMiddle(String name, Object value, Color color) {
        if (instance == null) {
            addInitList(name, value, color, PositionHudDebug.botMiddle);
        } else {
            instance.container.addBotMiddle(name, value, color);
        }
    }

    public static void addBotMiddle(String name, Object value) {
        addBotMiddle(name, value, Color.WHITE);
    }


    public static void addBotRight(String name, Object value, Color color) {
        if (instance == null) {
            addInitList(name, value, color, PositionHudDebug.botRight);
        } else {
            instance.container.addBotRight(name, value, color);
        }
    }

    public static void addBotRight(String name, Object value) {
        addBotRight(name, value, Color.WHITE);
    }


    public static void addLeftMiddle(String name, Object value, Color color) {
        if (instance == null) {
            addInitList(name, value, color, PositionHudDebug.leftMiddle);
        } else {
            instance.container.addLeftMiddle(name, value, color);
        }
    }

    public static void addLeftMiddle(String name, Object value) {
        addLeftMiddle(name, value, Color.WHITE);
    }

    public static void addRightMiddle(String name, Object value, Color color) {
        if (instance == null) {
            addInitList(name, value, color, PositionHudDebug.rightMiddle);
        } else {
            instance.container.addRightMiddle(name, value, color);
        }
    }

    public static void addRightMiddle(String name, Object value) {
        addRightMiddle(name, value, Color.WHITE);
    }

    public void add(int position, String name, Object value, Color color) {
        switch (position) {
            case PositionHudDebug.topLeft:
                this.addTopLeft(name, value, color);
                break;
            case PositionHudDebug.topMiddle:
                this.addTopMiddle(name, value, color);
                break;
            case PositionHudDebug.topRight:
                this.addTopRight(name, value, color);
                break;
            case PositionHudDebug.botLeft:
                this.addBotLeft(name, value, color);
                break;
            case PositionHudDebug.botMiddle:
                this.addBotMiddle(name, value, color);
                break;
            case PositionHudDebug.botRight:
                this.addBotRight(name, value, color);
                break;
            case PositionHudDebug.leftMiddle:
                this.addLeftMiddle(name, value, color);
                break;
            case PositionHudDebug.rightMiddle:
                this.addRightMiddle(name, value, color);
                break;
        }
    }

    public void add(int position, String name, Object value) {
        this.add(position, name, value, Color.WHITE);
    }
}
