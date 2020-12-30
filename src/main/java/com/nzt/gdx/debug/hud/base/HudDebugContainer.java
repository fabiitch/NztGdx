package com.nzt.gdx.debug.hud.base;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.nzt.gdx.debug.DebugDisplayUtils;

import java.util.HashMap;
import java.util.Map;

class HudDebugContainer {

    private Skin skin;
    private Stage stage;

    private int topR, topL, botR, botL;
    private Map<String, Label> mapLabels;
    float standartRight = 100;

    public HudDebugContainer(Stage stage) {
        this.skin = new Skin(Gdx.files.internal("ui/uiskin.json"));
        this.stage = stage;
        this.mapLabels = new HashMap<>();
    }

    public void update(String name, Object value) {
        Label label = mapLabels.get(name);
        label.setText(name + " : " + com.nzt.gdx.debug.DebugDisplayUtils.printValue(value));
    }

    public void addTopLeft(String name, Object value, Color color) {
        topL++;
        Label label = createLabel(name, value, color);
        label.setPosition(2 + Gdx.graphics.getSafeInsetRight()
                , stage.getHeight() - label.getHeight() * topL - 2 - Gdx.graphics.getSafeInsetTop());
    }

    public void addBotLeft(String name, Object value, Color color) {
        botL++;
        Label label = createLabel(name, value, color);
        label.setPosition(4, label.getHeight() * (botL - 1) + 1);
    }


    public void addBotRight(String name, Object value, Color color) {
        botR++;
        Label label = createLabel(name, value, color);
        float x = Math.max(label.getWidth() + 2, standartRight);
        label.setPosition(stage.getWidth() - x, stage.getHeight() - label.getHeight() * topR - 1);
    }


    public void addTopRight(String name, Object value, Color color) {
        topR++;
        Label label = createLabel(name, value, color);
        float witdhMax = Math.max(label.getWidth(), standartRight);
        label.setPosition(stage.getWidth() - witdhMax  -10, stage.getHeight() - label.getHeight() * topR - 1);
    }


    public Label createLabel(String name, Object value, Color color) {
        Label label = new Label(name + " : " + DebugDisplayUtils.printValue(value), skin);
        mapLabels.put(name, label);
        stage.addActor(label);
        label.setColor(color);
        return label;
    }

    public void addItem(HudDebugItem item) {
        if (item.position <= 1) {
            this.addTopLeft(item.name, item.value, item.color);
        } else if (item.position == 2) {
            this.addBotLeft(item.name, item.value, item.color);
        } else if (item.position == 3) {
            this.addTopRight(item.name, item.value, item.color);
        } else if (item.position >= 4) {
            this.addBotRight(item.name, item.value, item.color);
        }
    }

}
