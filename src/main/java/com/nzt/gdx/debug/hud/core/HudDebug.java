package com.nzt.gdx.debug.hud.core;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Array;
import com.nzt.gdx.debug.hud.HudDebugPosition;
import com.nzt.gdx.debug.hud.utils.HudDebugPreInitItem;
import com.nzt.gdx.debug.utils.DebugDisplayUtils;
import com.nzt.gdx.scene2D.nz.NzStage;

public class HudDebug {
    public static HudDebug instance;
    private static Array<HudDebugPreInitItem> arrayBeforeInit;
    private final HudDebugContainer container;

    public HudDebug(Stage stage, Skin skin) {
        this.container = new HudDebugContainer(stage, skin);
        HudDebug.instance = this;

        if (arrayBeforeInit != null) {
            for (HudDebugPreInitItem item : arrayBeforeInit) {
                this.container.addItem(item);
            }
            HudDebug.arrayBeforeInit.clear();
            HudDebug.arrayBeforeInit = null;
        }
    }

    public HudDebug(Skin skin) {
        this(new NzStage(), skin);
    }

    public static void clear() {
        if (instance == null) {
            arrayBeforeInit.clear();
        } else {
            instance.container.clear();
        }
    }

    public static boolean exist(String key) {
        if (instance == null) {
            for (HudDebugPreInitItem item : arrayBeforeInit)
                if (key.equals(item.name))
                    return true;
            return false;
        } else {
            return instance.container.exist(key);
        }
    }
    public static Color getColor(String key) {
        if (instance == null) {
            for (HudDebugPreInitItem item : arrayBeforeInit)
                if (key.equals(item.name))
                    return item.color;
            return Color.WHITE;
        } else {
            return instance.container.getColor(key);
        }
    }
    public static void removeGroup(String startKey) {
        if (instance == null) {
            for (HudDebugPreInitItem item : arrayBeforeInit) {
                if (item.key.startsWith(startKey)) {
                    arrayBeforeInit.removeValue(item, true);
                    break;
                }
            }
        } else {
            instance.container.removeGroup(startKey);
        }
    }
    public static void remove(String key) {
        if (instance == null) {
            for (HudDebugPreInitItem item : arrayBeforeInit) {
                if (key.equals(item.key)) {
                    arrayBeforeInit.removeValue(item, true);
                    break;
                }
            }
        } else {
            instance.container.remove(key);
        }
    }

    public static void updateColor(String key, Color color) {
        if (instance != null)
            instance.container.updateColor(key, color);
    }

    public static void update(String key, String name, Object value) {
        if (instance != null)
            instance.container.update(key, name, value);
    }

    public static void update(String key, Object value,Color color) {
        if (instance != null)
            instance.container.update(key, value, color);
    }

    public static void update(String key, Object value) {
        if (instance != null)
            instance.container.update(key, value);
    }

    public static void update(String key, String value) {
        if (instance != null)
            instance.container.update(key, value);
    }

    private static void addInitList(String key, String name, Object value, int positionOnStage, Color color) {
        if (arrayBeforeInit == null)
            arrayBeforeInit = new Array<>();

        arrayBeforeInit.add(new HudDebugPreInitItem(key, name, DebugDisplayUtils.printValue(value), positionOnStage, color));
    }

    public static void addTopLeft(String key, String name, Object value, Color color) {
        if (instance == null) {
            addInitList(key, name, value, HudDebugPosition.TOP_LEFT, color);
        } else {
            instance.container.addTopLeft(key, name, value, color);
        }
    }

    public static void addTopLeft(String name, Object value, Color color) {
        addTopLeft(null, name, value, color);
    }

    public static void addTopLeft(String name, Object value) {
        addTopLeft(null, name, value, Color.WHITE);
    }

    public static void addTopMiddle(String key, String name, Object value, Color color) {
        if (instance == null) {
            addInitList(key, name, value, HudDebugPosition.TOP_MIDDLE, color);
        } else {
            instance.container.addTopMiddle(key, name, value, color);
        }
    }

    public static void addTopMiddle(String name, Object value, Color color) {
        addTopMiddle(null, name, value, color);
    }

    public static void addTopMiddle(String name, Object value) {
        addTopMiddle(null, name, value, Color.WHITE);
    }

    public static void addTopRight(String key, String name, Object value, Color color) {
        if (instance == null) {
            addInitList(key, name, value, HudDebugPosition.TOP_RIGHT, color);
        } else {
            instance.container.addTopRight(key, name, value, color);
        }
    }

    public static void addTopRight(String name, Object value, Color color) {
        addTopRight(null, name, value, color);
    }

    public static void addTopRight(String name, Object value) {
        addTopRight(name, value, Color.WHITE);
    }

    public static void addBotLeft(String key, String name, Object value, Color color) {
        if (instance == null) {
            addInitList(key, name, value, HudDebugPosition.BOT_LEFT, color);
        } else {
            instance.container.addBotLeft(key, name, value, color);
        }
    }

    public static void addBotLeft(String name, Object value, Color color) {
        addBotLeft(null, name, value, color);
    }

    public static void addBotLeft(String name, Object value) {
        addBotLeft(null, name, value, Color.WHITE);
    }

    public static void addBotMiddle(String key, String name, Object value, Color color) {
        if (instance == null) {
            addInitList(key, name, value, HudDebugPosition.BOT_MIDDLE, color);
        } else {
            instance.container.addBotMiddle(key, name, value, color);
        }
    }

    public static void addBotMiddle(String name, Object value, Color color) {
        addBotMiddle(null, name, value, color);
    }

    public static void addBotMiddle(String name, Object value) {
        addBotMiddle(null, name, value, Color.WHITE);
    }

    public static void addBotRight(String key, String name, Object value, Color color) {
        if (instance == null) {
            addInitList(key, name, value, HudDebugPosition.BOT_RIGHT, color);
        } else {
            instance.container.addBotRight(key, name, value, color);
        }
    }

    public static void addBotRight(String name, Object value, Color color) {
        addBotRight(null, name, value, color);
    }

    public static void addBotRight(String name, Object value) {
        addBotRight(null, name, value, Color.WHITE);
    }


    public static void addLeftMiddle(String key, String name, Object value, Color color) {
        if (instance == null) {
            addInitList(key, name, value, HudDebugPosition.LEFT_MIDDLE, color);
        } else {
            instance.container.addLeftMiddle(key, name, value, color);
        }
    }

    public static void addLeftMiddle(String name, Object value, Color color) {
        addLeftMiddle(null, name, value, color);
    }

    public static void addLeftMiddle(String name, Object value) {
        addLeftMiddle(null, name, value, Color.WHITE);
    }


    public static void addRightMiddle(String key, String name, Object value, Color color) {
        if (instance == null) {
            addInitList(key, name, value, HudDebugPosition.RIGHT_MIDDLE, color);
        } else {
            instance.container.addRightMiddle(key, name, value, color);
        }
    }

    public static void addRightMiddle(String name, Object value, Color color) {
        addRightMiddle(null, name, value, color);
    }

    public static void addRightMiddle(String name, Object value) {
        addRightMiddle(null, name, value, Color.WHITE);
    }

    public static void addItem(String name, Object value, int positionOnStage) {
        addItem(name, value, positionOnStage, Color.WHITE);
    }

    public static void addItem(String name, Object value, int positionOnStage, Color color) {
        if (instance == null) {
            addInitList(null, name, value, positionOnStage, color);
        } else {
            add(null, name, value, positionOnStage, color);
        }
    }

    public static void add(String name, Object value, int positionOnstage, Color color) {
        add(name, name, value, positionOnstage, color);
    }

    public static void add(String key, String name, Object value, int positionOnstage, Color color) {
        switch (positionOnstage) {
            case HudDebugPosition.TOP_LEFT:
                HudDebug.addTopLeft(key, name, value, color);
                break;
            case HudDebugPosition.TOP_MIDDLE:
                HudDebug.addTopMiddle(key, name, value, color);
                break;
            case HudDebugPosition.TOP_RIGHT:
                HudDebug.addTopRight(key, name, value, color);
                break;
            case HudDebugPosition.BOT_LEFT:
                HudDebug.addBotLeft(key, name, value, color);
                break;
            case HudDebugPosition.BOT_MIDDLE:
                HudDebug.addBotMiddle(key, name, value, color);
                break;
            case HudDebugPosition.BOT_RIGHT:
                HudDebug.addBotRight(key, name, value, color);
                break;
            case HudDebugPosition.LEFT_MIDDLE:
                HudDebug.addLeftMiddle(key, name, value, color);
                break;
            case HudDebugPosition.RIGHT_MIDDLE:
                HudDebug.addRightMiddle(key, name, value, color);
                break;
        }
    }
}
