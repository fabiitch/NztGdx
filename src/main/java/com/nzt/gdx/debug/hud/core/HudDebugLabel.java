package com.nzt.gdx.debug.hud.core;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Array;
import com.nzt.gdx.debug.hud.HudDebugPosition;
import com.nzt.gdx.debug.hud.actors.HudDebugActor;
import com.nzt.gdx.debug.hud.utils.HudDebugPreInitItem;
import com.nzt.gdx.debug.hud.utils.HudDebugUtils;
import com.nzt.gdx.debug.utils.DebugDisplayUtils;
import com.nzt.gdx.utils.GdxUtils;

/**
 * Factory and utils for label in HudDebug
 */
public class HudDebugLabel extends Label {

    private static final String SEPARATOR = " : ";

    private String name;

    public HudDebugLabel(String name, String value) {
        super(name + SEPARATOR + value, HudDebug.skin);
    }

    public HudDebugLabel(String name, String value, Color color) {
        this(name,value);
        this.setColor(color);
    }

    public void updateNameAndValue(String name, String value) {
        this.name = name;
        updateValue(value);
    }

    public void updateNameAndValue(String name, Object value) {
        this.name = name;
        updateValue(value);
    }

    public void updateValue(Object value) {
        this.setText(this.name + SEPARATOR + DebugDisplayUtils.printValue(value));
    }

    public void updateValue(String value) {
        this.setText(this.name + SEPARATOR + value);
    }

    public static HudDebugLabel createLabel(String name, String value, Color color) {
        HudDebugLabel label = new HudDebugLabel(name ,value);
        label.setColor(color);
        label.setTouchable(Touchable.disabled);
        if (GdxUtils.isMobile()) {
            label.setWidth(label.getWidth() * 2);
            label.setHeight(label.getHeight() * 2);
            label.setFontScale(2);
        }
        return label;
    }

    public static void add(String key, String name, Object value, int positionOnstage, Color color) {
        Label label = createLabel(name, DebugDisplayUtils.printValue(value), color);
        HudDebug.add(key, positionOnstage, label);
    }


    public static void update(String key, String name, Object value) {
        HudDebugActor hudDebugActor = HudDebug.get(key);
        if (hudDebugActor != null) {
            Label label = (Label) hudDebugActor.actor;
            label.setText(name + SEPARATOR + DebugDisplayUtils.printValue(value));
        }
    }

    public static void update(String key, Object value) {
        HudDebugActor hudDebugActor = HudDebug.get(key);
        if (hudDebugActor != null) {
            HudDebugLabel label = (HudDebugLabel) hudDebugActor.actor;
            label.updateValue(value);
        }
    }

    public static void update(String key, String value) {
        HudDebugActor hudDebugActor = HudDebug.get(key);
        if (hudDebugActor != null) {
            HudDebugLabel hudDebugLabel = (HudDebugLabel) hudDebugActor.actor;
            hudDebugLabel.updateValue(value);
        }
    }

    public static void addTopLeft(String key, String name, Object value, Color color) {
        HudDebugLabel hudDebugLabel = new HudDebugLabel(name, DebugDisplayUtils.printValue(value), color);

        if (HudDebug.instance == null) {
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

    public static void changeColor(String name, Color color) {
        if (instance == null) {
            HudDebugUtils.changeColorBeforeInit(name, color, arrayBeforeInit);
        } else {
            instance.container.changeColor(name, color);
        }
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
}
