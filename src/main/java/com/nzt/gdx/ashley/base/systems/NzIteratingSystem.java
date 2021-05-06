package com.nzt.gdx.ashley.base.systems;

import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.nzt.gdx.debug.perf.PerformanceFrame;

public abstract class NzIteratingSystem extends IteratingSystem {

	public NzIteratingSystem(Family family, int priority) {
		super(family, priority);
		PerformanceFrame.addSystem(this);
	}

	public NzIteratingSystem(Family family) {
		this(family, 0);
	}

	@Override
	public void update(float dt) {
		PerformanceFrame.startSystem(this);
		super.update(dt);
		PerformanceFrame.endSystem(this);
	}

}
