package com.nzt.gdx.ashley.base;

import com.badlogic.ashley.core.EntitySystem;
import com.nzt.gdx.debug.perf.PerformanceFrame;

public abstract class NzEntitySystem extends EntitySystem {
	public NzEntitySystem(int priority) {
		super(priority);
		PerformanceFrame.addSystem(this);
	}

	public NzEntitySystem() {
		this(0);
	}

	@Override
	public final void update(float dt) {
		PerformanceFrame.startSystem(this);
		updateSystem(dt);
		PerformanceFrame.endSystem(this);
	}

	public abstract void updateSystem(float dt);
}
