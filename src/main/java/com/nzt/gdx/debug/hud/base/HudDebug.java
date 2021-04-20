package com.nzt.gdx.debug.hud.base;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Array;
import com.nzt.gdx.debug.hud.HudDebugPosition;
import com.nzt.gdx.debug.utils.DebugDisplayUtils;

public class HudDebug {
    public static HudDebug instance;
    private static Array<HudDebugItem> arrayBeforeInit;

    private HudDebugContainer container;

    public HudDebug(Stage stage, Skin skin) {
        this.container = new HudDebugContainer(stage, skin);
        HudDebug.instance = this;

        if (arrayBeforeInit != null) {
            for (HudDebugItem item : arrayBeforeInit) {
                this.container.addItem(item);
            }
            HudDebug.arrayBeforeInit.clear();
            HudDebug.arrayBeforeInit = null;
        }
    }

    public static boolean exist(String label) {
        if (instance == null) {
            for (HudDebugItem item : arrayBeforeInit)
                if (label.equals(item.name))
                    return true;
            return false;
        } else {
            return instance.container.exist(label);
        }
    }

    public static void remove(String label) {
        if (instance == null) {
            HudDebugItem toRemove = null;
            for (HudDebugItem item : arrayBeforeInit) {
                if (label.equals(item.name)) {
                    arrayBeforeInit.removeValue(toRemove, true);
                    break;
                }
            }
        } else {
            instance.container.remove(label);
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
            addInitList(name, value, color, HudDebugPosition.TOP_LEFT);
        } else {
            instance.container.addTopLeft(name, value, color);
        }
    }

    public static void addTopLeft(String name, Object value) {
        addTopLeft(name, value, Color.WHITE);
    }

    public static void addTopMiddle(String name, Object value, Color color) {
        if (instance == null) {
            addInitList(name, value, color, HudDebugPosition.TOP_MIDDLE);
        } else {
            instance.container.addTopMiddle(name, value, color);
        }
    }

    public static void addTopMiddle(String name, Object value) {
        addTopMiddle(name, value, Color.WHITE);
    }

    public static void addTopRight(String name, Object value, Color color) {
        if (instance == null) {
            addInitList(name, value, color, HudDebugPosition.TOP_RIGHT);
        } else {
            instance.container.addTopRight(name, value, color);
        }
    }

    public static void addTopRight(String name, Object value) {
        addTopRight(name, value, Color.WHITE);
    }

    public static void addBotLeft(String name, Object value, Color color) {
        if (instance == null) {
            addInitList(name, value, color, HudDebugPosition.BOT_LEFT);
        } else {
            instance.container.addBotLeft(name, value, color);
        }
    }

    public static void addBotLeft(String name, Object value) {
        addBotLeft(name, value, Color.WHITE);
    }

    public static void addBotMiddle(String name, Object value, Color color) {
        if (instance == null) {
            addInitList(name, value, color, HudDebugPosition.BOT_MIDDLE);
        } else {
            instance.container.addBotMiddle(name, value, color);
        }
    }

    public static void addBotMiddle(String name, Object value) {
        addBotMiddle(name, value, Color.WHITE);
    }

    public static void addBotRight(String name, Object value, Color color) {
        if (instance == null) {
            addInitList(name, value, color, HudDebugPosition.BOT_RIGHT);
        } else {
            instance.container.addBotRight(name, value, color);
        }
    }

    public static void addBotRight(String name, Object value) {
        addBotRight(name, value, Color.WHITE);
    }

    public static void addLeftMiddle(String name, Object value, Color color) {
        if (instance == null) {
            addInitList(name, value, color, HudDebugPosition.LEFT_MIDDLE);
        } else {
            instance.container.addLeftMiddle(name, value, color);
        }
    }

    public static void addLeftMiddle(String name, Object value) {
        addLeftMiddle(name, value, Color.WHITE);
    }

    public static void addRightMiddle(String name, Object value, Color color) {
        if (instance == null) {
            addInitList(name, value, color, HudDebugPosition.RIGHT_MIDDLE);
        } else {
            instance.container.addRightMiddle(name, value, color);
        }
    }

    public static void addRightMiddle(String name, Object value) {
        addRightMiddle(name, value, Color.WHITE);
    }

    public static void changeColor(String name, Color color) {
        if (instance == null) {
            HudDebugUtils.changeColorBeforeInit(name, color, arrayBeforeInit);
        } else {
            instance.container.changeColor(name, color);
        }
    }

    public static void addItem(int position, String name, Object value) {
        addItem(position, name, value, Color.WHITE);
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
            case HudDebugPosition.TOP_LEFT:
                HudDebug.addTopLeft(name, value, color);
                break;
            case HudDebugPosition.TOP_MIDDLE:
                HudDebug.addTopMiddle(name, value, color);
                break;
            case HudDebugPosition.TOP_RIGHT:
                HudDebug.addTopRight(name, value, color);
                break;
            case HudDebugPosition.BOT_LEFT:
                HudDebug.addBotLeft(name, value, color);
                break;
            case HudDebugPosition.BOT_MIDDLE:
                HudDebug.addBotMiddle(name, value, color);
                break;
            case HudDebugPosition.BOT_RIGHT:
                HudDebug.addBotRight(name, value, color);
                break;
            case HudDebugPosition.LEFT_MIDDLE:
                HudDebug.addLeftMiddle(name, value, color);
                break;
            case HudDebugPosition.RIGHT_MIDDLE:
                HudDebug.addRightMiddle(name, value, color);
                break;
        }
    }

    public void add(int position, String name, Object value) {
        this.add(position, name, value, Color.WHITE);
    }
}
