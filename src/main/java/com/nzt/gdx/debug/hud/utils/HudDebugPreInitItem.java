package com.nzt.gdx.debug.hud.utils;

import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Used in HudDebug before init();
 */
public class HudDebugPreInitItem {
    public String key; // key in map for HudDebug.update(key,value)
    public Actor actor;
    public int positionOnStage;

    public HudDebugPreInitItem(String key, int positionOnStage, Actor actor) {
        this.key = key;
        this.positionOnStage = positionOnStage;
        this.actor = actor;
    }

}
