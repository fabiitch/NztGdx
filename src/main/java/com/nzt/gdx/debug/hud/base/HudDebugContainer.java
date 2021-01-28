package com.nzt.gdx.debug.hud.base;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.nzt.gdx.debug.DebugDisplayUtils;
import com.nzt.gdx.debug.hud.HudDebugPosition;

//TODO padding on android
class HudDebugContainer {

    private Skin skin;
    private Stage stage;

    private int topR, topM, topL, botR, botM, botL, rightM, leftM;
    private Map<String, Label> mapLabels;
    float standartRight = 100;

    public HudDebugContainer(Stage stage) {
        this.skin = new Skin(Gdx.files.internal("ui/uiskin.json"));
        this.stage = stage;
        this.mapLabels = new HashMap<>();
    }

    public void update(String name, Object value) {
        Label label = mapLabels.get(name);
        if(label == null) {
            System.out.println(name);
        }
        label.setText(name + " : " + DebugDisplayUtils.printValue(value));
    }

    public void addTopLeft(String name, Object value, Color color) {
        topL++;
        Label label = createLabel(name, value, color);
        label.setPosition(1, stage.getViewport().getWorldHeight() - label.getHeight() * topL - 1);
    }

    public void addTopMiddle(String name, Object value, Color color) {
        topM++;
        Label label = createLabel(name, value, color);
        label.setPosition(stage.getViewport().getWorldWidth() / 2 - stage.getViewport().getWorldWidth() / 6, stage.getViewport().getWorldHeight() - label.getHeight() * topM - 1);
    }

    public void addTopRight(String name, Object value, Color color) {
        topR++;
        Label label = createLabel(name, value, color);
        float witdhMax = Math.max(label.getWidth(), standartRight);
        label.setPosition(stage.getViewport().getWorldWidth() - witdhMax - 10, stage.getViewport().getWorldHeight() - label.getHeight() * topR - 1);
    }

    public void addBotLeft(String name, Object value, Color color) {
        botL++;
        Label label = createLabel(name, value, color);
        label.setPosition(4, label.getHeight() * (botL - 1) + 1);
    }

    public void addBotMiddle(String name, Object value, Color color) {
        botM++;
        Label label = createLabel(name, value, color);
        float x = Math.max(label.getWidth() + 2, standartRight);
        label.setPosition(stage.getViewport().getWorldWidth() / 2 - stage.getViewport().getWorldWidth() / 6, label.getHeight() * (botM - 1) + 1);
    }

    public void addBotRight(String name, Object value, Color color) {
        botR++;
        Label label = createLabel(name, value, color);
        float x = Math.max(label.getWidth() + 2, standartRight);
        label.setPosition(stage.getViewport().getWorldWidth() - x, label.getHeight() * (botR - 1) + 1);
    }

    public void addLeftMiddle(String name, Object value, Color color) {
        leftM++;
        Label label = createLabel(name, value, color);
        label.setPosition(1,
                stage.getViewport().getWorldHeight() / 2 + stage.getViewport().getWorldHeight() / 6 - label.getHeight() * leftM - 1 - Gdx.graphics.getSafeInsetTop());
    }

    public void addRightMiddle(String name, Object value, Color color) {
        rightM++;
        Label label = createLabel(name, value, color);
        float x = Math.max(label.getWidth() + 2, standartRight);
        label.setPosition(stage.getViewport().getWorldWidth() - x,
                stage.getViewport().getWorldHeight() / 2 + stage.getViewport().getWorldHeight() / 6 - label.getHeight() * rightM - 1 - Gdx.graphics.getSafeInsetTop());

    }

    public Label createLabel(String name, Object value, Color color) {
        Label label = new Label(name + " : " + DebugDisplayUtils.printValue(value), skin);
        mapLabels.put(name, label);
        stage.addActor(label);
        label.setColor(color);
        return label;
    }

    public void addItem(HudDebugItem item) {
        switch (item.position) {
            case HudDebugPosition.topLeft:
                this.addTopLeft(item.name, item.value, item.color);
                break;
            case HudDebugPosition.topMiddle:
                this.addTopMiddle(item.name, item.value, item.color);
                break;
            case HudDebugPosition.topRight:
                this.addTopRight(item.name, item.value, item.color);
                break;
            case HudDebugPosition.botLeft:
                this.addBotLeft(item.name, item.value, item.color);
                break;
            case HudDebugPosition.botMiddle:
                this.addBotMiddle(item.name, item.value, item.color);
                break;
            case HudDebugPosition.botRight:
                this.addBotRight(item.name, item.value, item.color);
                break;
            case HudDebugPosition.leftMiddle:
                this.addLeftMiddle(item.name, item.value, item.color);
                break;
            case HudDebugPosition.rightMiddle:
                this.addRightMiddle(item.name, item.value, item.color);
                break;
        }
    }

}
