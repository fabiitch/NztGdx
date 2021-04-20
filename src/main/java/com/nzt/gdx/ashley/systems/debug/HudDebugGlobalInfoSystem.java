package com.nzt.gdx.ashley.systems.debug;

import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.gdx.graphics.Color;
import com.nzt.gdx.ashley.NztSystemsOrder;
import com.nzt.gdx.debug.hud.HudDebugGlobalInfo;

public class HudDebugGlobalInfoSystem extends EntitySystem {

	public HudDebugGlobalInfo hudGlobalInfo;

	public HudDebugGlobalInfoSystem(int positionHudDebug, Color color) {
		this(positionHudDebug, color, NztSystemsOrder.HUD_DEBUG);
	}

	public HudDebugGlobalInfoSystem(int positionHudDebug, Color color, int priority) {
		super(priority);
		this.hudGlobalInfo = new HudDebugGlobalInfo(positionHudDebug, color);
	}
	

	@Override
	public void update(float dt) {
		this.hudGlobalInfo.update(dt);
	}
}
