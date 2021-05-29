package com.nzt.gdx.ashley.systems.debug.hud;

import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.gdx.graphics.Color;
import com.nzt.gdx.ashley.NztSystemsOrder;
import com.nzt.gdx.debug.perf.HudDebugPerformanceFrame;

public class HudDebugPerformanceSystem extends EntitySystem {

	private HudDebugPerformanceFrame performanceFrame;

	public HudDebugPerformanceSystem(int positionOnStage) {
		this(positionOnStage, Color.WHITE);
	}

	public HudDebugPerformanceSystem(int positionOnStage, Color color) {
		super(NztSystemsOrder.HUD_DEBUG);
		performanceFrame = new HudDebugPerformanceFrame(positionOnStage, color);
	}

	@Override
	public void update(float dt) {
		performanceFrame.update(dt);
	}
}
