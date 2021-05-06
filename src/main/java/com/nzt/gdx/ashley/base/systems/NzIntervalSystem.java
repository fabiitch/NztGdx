package com.nzt.gdx.ashley.base.systems;

import com.badlogic.ashley.systems.IntervalSystem;
import com.nzt.gdx.debug.perf.PerformanceFrame;

public abstract class NzIntervalSystem extends IntervalSystem {

	public NzIntervalSystem(float interval, int priority) {
		super(interval, priority);
		PerformanceFrame.addSystem(this);
	}

	public NzIntervalSystem(float interval) {
		this(interval, 0);
	}

	@Override
	public void update(float dt) {
		PerformanceFrame.startSystem(this);
		super.update(dt);
		PerformanceFrame.endSystem(this);
	}

}
