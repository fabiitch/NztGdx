package com.nzt.gdx.debug.hud.base;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.nzt.gdx.debug.hud.HudDebugPosition;
import com.nzt.gdx.debug.utils.DebugDisplayUtils;
import com.nzt.gdx.logger.tag.LogTagsBase;
import com.nzt.gdx.logger.tag.TagLogger;

//TODO padding on android
class HudDebugContainer {

    private Skin skin;
    private Stage stage;

    private int topR, topM, topL, botR, botM, botL, rightM, leftM;
    private final Map<String, HudDebugLabel> mapLabels;

    public HudDebugContainer(Stage stage, Skin skin) {
        this.skin = skin;
        this.stage = stage;
        this.mapLabels = new HashMap<>();
    }

    public void remove(String label) {
        HudDebugLabel labelStage = mapLabels.get(label);
        if (labelStage != null) {
            int positionOnStage = labelStage.positionOnStage;
            int positionLabel = labelStage.position;
            mapLabels.remove(label);
            labelStage.remove();

            removeCount(positionOnStage);
            HudDebugUtils.replaceLabels(positionOnStage, positionLabel, stage, mapLabels);
        }
    }

    public boolean exist(String label) {
        return mapLabels.get(label) != null;
    }

    public void changeColor(String label, Color color) {
        HudDebugUtils.changeColor(label, color, mapLabels);
    }

    public void update(String name, Object value) {
        Label label = mapLabels.get(name);
        if (label != null) {
            label.setText(name + " : " + DebugDisplayUtils.printValue(value));
        } else {
            TagLogger.debug(LogTagsBase.HUD_DEBUG, "Cant find label for update: " + label);
        }
    }

    public void addTopLeft(String name, Object value, Color color) {
        topL++;
        HudDebugLabel label = createLabel(HudDebugPosition.TOP_LEFT, topL, name, value, color);
        HudDebugUtils.setDebugLabelPosition(stage, label);
        label.setPosition(1, stage.getViewport().getWorldHeight() - label.getHeight() * topL - 1);
    }

    public void addTopMiddle(String name, Object value, Color color) {
        topM++;
        HudDebugLabel label = createLabel(HudDebugPosition.TOP_MIDDLE, topM, name, value, color);
        HudDebugUtils.setDebugLabelPosition(stage, label);
    }

    public void addTopRight(String name, Object value, Color color) {
        topR++;
        HudDebugLabel label = createLabel(HudDebugPosition.TOP_RIGHT, topR, name, value, color);
        HudDebugUtils.setDebugLabelPosition(stage, label);
    }

    public void addBotLeft(String name, Object value, Color color) {
        botL++;
        HudDebugLabel label = createLabel(HudDebugPosition.BOT_LEFT, botL, name, value, color);
        HudDebugUtils.setDebugLabelPosition(stage, label);
    }

    public void addBotMiddle(String name, Object value, Color color) {
        botM++;
        HudDebugLabel label = createLabel(HudDebugPosition.BOT_MIDDLE, botM, name, value, color);
        HudDebugUtils.setDebugLabelPosition(stage, label);
    }

    public void addBotRight(String name, Object value, Color color) {
        botR++;
        HudDebugLabel label = createLabel(HudDebugPosition.BOT_RIGHT, botR, name, value, color);
        HudDebugUtils.setDebugLabelPosition(stage, label);
    }

    public void addLeftMiddle(String name, Object value, Color color) {
        leftM++;
        HudDebugLabel label = createLabel(HudDebugPosition.LEFT_MIDDLE, leftM, name, value, color);
        HudDebugUtils.setDebugLabelPosition(stage, label);
    }

    public void addRightMiddle(String name, Object value, Color color) {
        rightM++;
        HudDebugLabel label = createLabel(HudDebugPosition.RIGHT_MIDDLE, rightM, name, value, color);
        HudDebugUtils.setDebugLabelPosition(stage, label);
    }

    public HudDebugLabel createLabel(int positionOnstage, int position, String name, Object value, Color color) {
        HudDebugLabel label = new HudDebugLabel(positionOnstage, position,
                name + " : " + DebugDisplayUtils.printValue(value), skin);
        mapLabels.put(name, label);
        stage.addActor(label);
        label.setColor(color);
        return label;
    }

    public void addItem(HudDebugItem item) {
        switch (item.position) {
            case HudDebugPosition.TOP_LEFT:
                this.addTopLeft(item.name, item.value, item.color);
                break;
            case HudDebugPosition.TOP_MIDDLE:
                this.addTopMiddle(item.name, item.value, item.color);
                break;
            case HudDebugPosition.TOP_RIGHT:
                this.addTopRight(item.name, item.value, item.color);
                break;
            case HudDebugPosition.BOT_LEFT:
                this.addBotLeft(item.name, item.value, item.color);
                break;
            case HudDebugPosition.BOT_MIDDLE:
                this.addBotMiddle(item.name, item.value, item.color);
                break;
            case HudDebugPosition.BOT_RIGHT:
                this.addBotRight(item.name, item.value, item.color);
                break;
            case HudDebugPosition.LEFT_MIDDLE:
                this.addLeftMiddle(item.name, item.value, item.color);
                break;
            case HudDebugPosition.RIGHT_MIDDLE:
                this.addRightMiddle(item.name, item.value, item.color);
                break;
            default:
                break;
        }
    }

    private void removeCount(int positionOnStage) {
        switch (positionOnStage) {
            case HudDebugPosition.TOP_LEFT:
                topL--;
                break;
            case HudDebugPosition.TOP_MIDDLE:
                topM--;
                break;
            case HudDebugPosition.TOP_RIGHT:
                topR--;
                break;
            case HudDebugPosition.BOT_LEFT:
                botL--;
                break;
            case HudDebugPosition.BOT_MIDDLE:
                botM--;
                break;
            case HudDebugPosition.BOT_RIGHT:
                botR--;
                break;
            case HudDebugPosition.LEFT_MIDDLE:
                leftM--;
                break;
            case HudDebugPosition.RIGHT_MIDDLE:
                rightM--;
                break;
            default:
                break;
        }
    }

}
