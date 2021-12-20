package com.nzt.gdx.ashley.systems.debug.hud;

import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.gdx.graphics.Color;
import com.nzt.gdx.debug.hud.HudDebugApplicationInfo;

public class HudDebugApplicationInfoSystem extends EntitySystem {

    public final HudDebugApplicationInfo hudGlobalInfo;

    public HudDebugApplicationInfoSystem(int positionHudDebug, Color color, int priority) {
        super(priority);
        this.hudGlobalInfo = new HudDebugApplicationInfo(positionHudDebug, color);
    }


    @Override
    public void update(float dt) {
        this.hudGlobalInfo.update(dt);
    }
}
