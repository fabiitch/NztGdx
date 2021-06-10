package com.nzt.gdx.debug.hud.core;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Array;
import com.nzt.gdx.debug.hud.HudDebugPosition;
import com.nzt.gdx.debug.hud.actors.HudDebugActor;
import com.nzt.gdx.debug.hud.utils.HudDebugPreInitItem;

public class HudDebug {
    public static HudDebug instance;
    private static Array<HudDebugPreInitItem> arrayBeforeInit;
    public static Skin skin;

    private final HudDebugContainer container;

    public static void dispose(){
        HudDebug.skin.dispose();
    }

    public HudDebug(Stage stage, Skin skin) {
        this.container = new HudDebugContainer(stage);
        HudDebug.skin = skin;
        HudDebug.instance = this;

        if (arrayBeforeInit != null) {
            for (HudDebugPreInitItem item : arrayBeforeInit) {
                this.container.addItem(item);
            }
            HudDebug.arrayBeforeInit.clear();
            HudDebug.arrayBeforeInit = null;
        }
    }

    public static HudDebugActor get(String key) {
        if (instance == null) {
            return null;
        } else {
            return instance.container.get(key);
        }
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
                if (key.equals(item.key))
                    return true;
            return false;
        } else {
            return instance.container.exist(key);
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

    private static void addInitList(String key, int positionOnStage, Actor actor) {
        if (arrayBeforeInit == null)
            arrayBeforeInit = new Array<>();
        arrayBeforeInit.add(new HudDebugPreInitItem(key, positionOnStage, actor));
    }

    public static void addTopLeft(String key, Actor actor) {
        if (instance == null) {
            addInitList(key, HudDebugPosition.TOP_LEFT, actor);
        } else {
            instance.container.addActor(key, HudDebugPosition.TOP_LEFT, actor);
        }
    }

    public static void addTopMiddle(String key, Actor actor) {
        if (instance == null) {
            addInitList(key, HudDebugPosition.TOP_MIDDLE, actor);
        } else {
            instance.container.addActor(key, HudDebugPosition.TOP_MIDDLE, actor);
        }
    }

    public static void addTopRight(String key, Actor actor) {
        if (instance == null) {
            addInitList(key, HudDebugPosition.TOP_RIGHT, actor);
        } else {
            instance.container.addActor(key, HudDebugPosition.TOP_RIGHT, actor);
        }
    }

    public static void addBotLeft(String key, Actor actor) {
        if (instance == null) {
            addInitList(key, HudDebugPosition.BOT_LEFT, actor);
        } else {
            instance.container.addActor(key, HudDebugPosition.BOT_LEFT, actor);
        }
    }

    public static void addBotMiddle(String key, Actor actor) {
        if (instance == null) {
            addInitList(key, HudDebugPosition.BOT_MIDDLE, actor);
        } else {
            instance.container.addActor(key, HudDebugPosition.BOT_MIDDLE, actor);
        }
    }

    public static void addBotRight(String key, Actor actor) {
        if (instance == null) {
            addInitList(key, HudDebugPosition.BOT_RIGHT, actor);
        } else {
            instance.container.addActor(key, HudDebugPosition.BOT_RIGHT, actor);
        }
    }

    public static void addLeftMiddle(String key, Actor actor) {
        if (instance == null) {
            addInitList(key, HudDebugPosition.LEFT_MIDDLE, actor);
        } else {
            instance.container.addActor(key, HudDebugPosition.LEFT_MIDDLE, actor);
        }
    }

    public static void addRightMiddle(String key, Actor actor) {
        if (instance == null) {
            addInitList(key, HudDebugPosition.RIGHT_MIDDLE, actor);
        } else {
            instance.container.addActor(key, HudDebugPosition.RIGHT_MIDDLE, actor);
        }
    }

    public static void add(String key, int positionOnstage, Actor actor) {
        switch (positionOnstage) {
            case HudDebugPosition.TOP_LEFT:
                HudDebug.addTopLeft(key, actor);
                break;
            case HudDebugPosition.TOP_MIDDLE:
                HudDebug.addTopMiddle(key, actor);
                break;
            case HudDebugPosition.TOP_RIGHT:
                HudDebug.addTopRight(key, actor);
                break;
            case HudDebugPosition.BOT_LEFT:
                HudDebug.addBotLeft(key, actor);
                break;
            case HudDebugPosition.BOT_MIDDLE:
                HudDebug.addBotMiddle(key, actor);
                break;
            case HudDebugPosition.BOT_RIGHT:
                HudDebug.addBotRight(key, actor);
                break;
            case HudDebugPosition.LEFT_MIDDLE:
                HudDebug.addLeftMiddle(key, actor);
                break;
            case HudDebugPosition.RIGHT_MIDDLE:
                HudDebug.addRightMiddle(key, actor);
                break;
        }
    }
}
