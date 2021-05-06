package com.nzt.gdx.debug.hud.base;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.nzt.gdx.debug.hud.HudDebugPosition;
import com.nzt.gdx.debug.utils.DebugDisplayUtils;
import com.nzt.gdx.logger.tag.LogTagsBase;
import com.nzt.gdx.logger.tag.TagLogger;

import java.util.HashMap;
import java.util.Map;

//TODO padding on android
class HudDebugContainer {

    private final Skin skin;
    private final Stage stage;

    private int topR, topM, topL, botR, botM, botL, rightM, leftM;
    private final Map<String, HudDebugLabel> mapLabels;

    public HudDebugContainer(Stage stage, Skin skin) {
        this.skin = skin;
        this.stage = stage;
        this.mapLabels = new HashMap<>();
    }

    public void remove(String key) {
        HudDebugLabel labelStage = mapLabels.get(key);
        if (labelStage != null) {
            int positionOnStage = labelStage.positionOnStage;
            int positionLabel = labelStage.position;
            mapLabels.remove(key);
            labelStage.remove();

            removeCount(positionOnStage);
            HudDebugUtils.replaceLabels(positionOnStage, positionLabel, stage, mapLabels);
        }
    }

    public boolean exist(String label) {
        return mapLabels.get(label) != null;
    }

    public void changeColor(String key, Color color) {
        HudDebugUtils.changeColor(key, color, mapLabels);
    }

    public void update(String key, String name, Object value) {
        HudDebugLabel label = mapLabels.get(key);
        if (label != null) {
            label.updateNameAndValue(name, DebugDisplayUtils.printValue(value));
        } else {
            TagLogger.debug(LogTagsBase.HUD_DEBUG, "Cant find label for update, key= " + key);
        }
    }

    public void update(String key, String value) {
        HudDebugLabel label = mapLabels.get(key);
        if (label != null) {
            label.updateValue(value);
        } else {
            TagLogger.debug(LogTagsBase.HUD_DEBUG, "Cant find label for update, key= " + key);
        }
    }

    public void update(String key, Object value) {
        HudDebugLabel label = mapLabels.get(key);
        if (label != null) {
            label.updateValue(DebugDisplayUtils.printValue(value));
        } else {
            TagLogger.debug(LogTagsBase.HUD_DEBUG, "Cant find label for update, key= " + key);
        }
    }

    public void addTopLeft(String key, String name, Object value, Color color) {
        topL++;
        HudDebugLabel label = createLabel(HudDebugPosition.TOP_LEFT, topL, key, name, value, color);
        HudDebugUtils.setDebugLabelPosition(stage, label);
        label.setPosition(1, stage.getViewport().getWorldHeight() - label.getHeight() * topL - 1);
    }

    public void addTopMiddle(String key, String name, Object value, Color color) {
        topM++;
        HudDebugLabel label = createLabel(HudDebugPosition.TOP_MIDDLE, topM, key, name, value, color);
        HudDebugUtils.setDebugLabelPosition(stage, label);
    }

    public void addTopRight(String key, String name, Object value, Color color) {
        topR++;
        HudDebugLabel label = createLabel(HudDebugPosition.TOP_RIGHT, topR, key, name, value, color);
        HudDebugUtils.setDebugLabelPosition(stage, label);
    }

    public void addBotLeft(String key, String name, Object value, Color color) {
        botL++;
        HudDebugLabel label = createLabel(HudDebugPosition.BOT_LEFT, botL, key, name, value, color);
        HudDebugUtils.setDebugLabelPosition(stage, label);
    }

    public void addBotMiddle(String key, String name, Object value, Color color) {
        botM++;
        HudDebugLabel label = createLabel(HudDebugPosition.BOT_MIDDLE, botM, key, name, value, color);
        HudDebugUtils.setDebugLabelPosition(stage, label);
    }

    public void addBotRight(String key, String name, Object value, Color color) {
        botR++;
        HudDebugLabel label = createLabel(HudDebugPosition.BOT_RIGHT, botR, key, name, value, color);
        HudDebugUtils.setDebugLabelPosition(stage, label);
    }

    public void addLeftMiddle(String key, String name, Object value, Color color) {
        leftM++;
        HudDebugLabel label = createLabel(HudDebugPosition.LEFT_MIDDLE, leftM, key, name, value, color);
        HudDebugUtils.setDebugLabelPosition(stage, label);
    }

    public void addRightMiddle(String key, String name, Object value, Color color) {
        rightM++;
        HudDebugLabel label = createLabel(HudDebugPosition.RIGHT_MIDDLE, rightM, key, name, value, color);
        HudDebugUtils.setDebugLabelPosition(stage, label);
    }

    public HudDebugLabel createLabel(int positionOnstage, int position, String key, String name, Object value, Color color) {
        HudDebugLabel label = new HudDebugLabel(name, positionOnstage, position,
                DebugDisplayUtils.printValue(value), skin);
        if (key == null)
            key = name;
        mapLabels.put(key, label);
        stage.addActor(label);
        label.setColor(color);
        return label;
    }

    public void addItem(PreInitItem item) {
        switch (item.positionOnStage) {
            case HudDebugPosition.TOP_LEFT:
                this.addTopLeft(item.key, item.name, item.value, item.color);
                break;
            case HudDebugPosition.TOP_MIDDLE:
                this.addTopMiddle(item.key, item.name, item.value, item.color);
                break;
            case HudDebugPosition.TOP_RIGHT:
                this.addTopRight(item.key, item.name, item.value, item.color);
                break;
            case HudDebugPosition.BOT_LEFT:
                this.addBotLeft(item.key, item.name, item.value, item.color);
                break;
            case HudDebugPosition.BOT_MIDDLE:
                this.addBotMiddle(item.key, item.name, item.value, item.color);
                break;
            case HudDebugPosition.BOT_RIGHT:
                this.addBotRight(item.key, item.name, item.value, item.color);
                break;
            case HudDebugPosition.LEFT_MIDDLE:
                this.addLeftMiddle(item.key, item.name, item.value, item.color);
                break;
            case HudDebugPosition.RIGHT_MIDDLE:
                this.addRightMiddle(item.key, item.name, item.value, item.color);
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
