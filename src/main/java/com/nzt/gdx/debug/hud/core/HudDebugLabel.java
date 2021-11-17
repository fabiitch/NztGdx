package com.nzt.gdx.debug.hud.core;

import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.nzt.gdx.debug.hud.HudDebugPosition;
import com.nzt.gdx.utils.GdxUtils;

/**
 * Used in HudDebug
 */
 class HudDebugLabel extends Label {

    private static final String SEPARATOR = " : ";

    public int positionOnStage;
    public int position;
    public String name;
    float maxWitdh; //only for right/mid

    public HudDebugLabel(String name, int positionOnStage, int order, String value, Skin skin) {
        super(name + SEPARATOR + value, skin);
        if (GdxUtils.isMobile()) {
            this.setWidth(this.getWidth() * 2);
            this.setHeight(this.getHeight() * 2);
            this.setFontScale(2);
        }
        this.name = name;
        this.positionOnStage = positionOnStage;
        this.position = order;
        this.setTouchable(Touchable.disabled);
    }

    public void updateNameAndValue(String name, String value) {
        this.name = name;
        updateValue(value);
    }

    public void updateValue(String value) {
        this.setText(this.name + SEPARATOR + value);
        //cancel shake
        if(HudDebugPosition.isRight(this.positionOnStage) || HudDebugPosition.isMiddleHorizontal(this.positionOnStage)){
            maxWitdh = Math.max(maxWitdh,getPrefWidth());
            setSize(maxWitdh, getPrefHeight());
        }

    }
}
