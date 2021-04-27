package com.nzt.gdx.ashley.systems.debug;

import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.gdx.graphics.Color;
import com.nzt.gdx.ashley.NztSystemsOrder;
import com.nzt.gdx.debug.gl.NzGLProfiler;

public class HudDebugGlProfilerSystem extends EntitySystem {
	private NzGLProfiler profiler;

	public HudDebugGlProfilerSystem(NzGLProfiler profiler, int positionOnStage) {
		this(profiler, positionOnStage, Color.WHITE);
	}

	public HudDebugGlProfilerSystem(NzGLProfiler profiler, int positionOnStage, Color color) {
		super(NztSystemsOrder.HUD_DEBUG);
		this.profiler = profiler;
		profiler.initHudDebug(positionOnStage, color);
		profiler.active();
	}

	public void active() {
		profiler.active();
	}

	public void desactive() {
		profiler.desactive();
	}

	@Override
	public void update(float dt) {
		profiler.updateHudDebug();
	}
}
