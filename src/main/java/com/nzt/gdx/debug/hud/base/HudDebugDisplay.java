package com.nzt.gdx.debug.hud.base;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.nzt.gdx.debug.DebugDisplayUtils;
import javafx.util.Pair;

import java.util.Map;

public class HudDebugDisplay {
    public static HudDebugDisplay instance;
    private static Array<HudDebugItem> arrayBeforeInit;

    private HudDebugContainer container;

    public HudDebugDisplay(Stage stage) {
        this.container = new HudDebugContainer(stage);
        this.instance = this;

        for (HudDebugItem item : arrayBeforeInit) {
            this.container.addItem(item);
        }
        this.arrayBeforeInit.clear();
        this.arrayBeforeInit = null;
    }

    public static void update(String name, Object value) {
        instance.container.update(name, value);
    }

    private static void addInitList(String name, Object value, Color color, int position) {
        if (arrayBeforeInit == null)
            arrayBeforeInit = new Array<>();

        arrayBeforeInit.add(new HudDebugItem(name, DebugDisplayUtils.printValue(value), color, position));
    }

    public static void addTopLeft(String name, Object value, Color color) {
        if (instance == null) {
            addInitList(name, value, color, 1);
        } else {
            instance.container.addTopLeft(name, value, color);
        }
    }

    public static void addTopLeft(String name, Object value) {
        addTopLeft(name, value, Color.WHITE);
    }

    public static void addBotLeft(String name, Object value, Color color) {
        if (instance == null) {
            addInitList(name, value, color, 2);
        } else {
            instance.container.addBotLeft(name, value, color);
        }
    }

    public static void addBotLeft(String name, Object value) {
        addBotLeft(name, value, Color.WHITE);
    }

    public static void addTopRight(String name, Object value, Color color) {
        if (instance == null) {
            addInitList(name, value, color, 3);
        } else {
            instance.container.addTopRight(name, value, color);
        }
    }

    public static void addTopRight(String name, Object value) {
        addTopRight(name, value, Color.WHITE);
    }

    public static void addBotRight(String name, Object value, Color color) {
        if (instance == null) {
            addInitList(name, value, color, 4);
        } else {
            instance.container.addBotRight(name, value, color);
        }
    }

    public static void addBotRight(String name, Object value) {
        addBotRight(name, value, Color.WHITE);
    }

}
