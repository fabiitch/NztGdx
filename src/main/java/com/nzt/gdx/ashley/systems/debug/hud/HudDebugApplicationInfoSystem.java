package com.nzt.gdx.ashley.systems.debug.hud;

import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.gdx.graphics.Color;
import com.nzt.gdx.ashley.NztSystemsOrder;
import com.nzt.gdx.debug.hud.HudDebugApplicationInfo;

public class HudDebugApplicationInfoSystem extends EntitySystem {

	public HudDebugApplicationInfo hudGlobalInfo;

	public HudDebugApplicationInfoSystem(int positionHudDebug, Color color) {
		this(positionHudDebug, color, NztSystemsOrder.HUD_DEBUG);
	}

	public HudDebugApplicationInfoSystem(int positionHudDebug, Color color, int priority) {
		super(priority);
		this.hudGlobalInfo = new HudDebugApplicationInfo(positionHudDebug, color);
	}
	

	@Override
	public void update(float dt) {
		this.hudGlobalInfo.update(dt);
	}
}
