package com.nzt.gdx.debug.hud.actors;

import com.badlogic.gdx.scenes.scene2d.Actor;

public class HudDebugActor{
    public int positionOnStage;
    public int position;
    public Actor actor;

    public HudDebugActor(int positionOnStage, int position, Actor actor) {
        this.positionOnStage = positionOnStage;
        this.position = position;
        this.actor = actor;
    }

    public void setPosition(float x, float y) {
        actor.setPosition(x, y);
    }

    public void remove() {
        actor.remove();
    }
}
