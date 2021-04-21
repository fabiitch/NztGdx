package com.nzt.gdx.ashley.base;

import com.badlogic.ashley.core.EntitySystem;
import com.nzt.gdx.debug.perf.PerformanceFrame;

public abstract class NzEntitySystem extends EntitySystem {

	public EntitySystem system;

	public NzEntitySystem(EntitySystem system) {
		super(system.priority);
		PerformanceFrame.add(system.getClass().getSimpleName());
	}

	public void update(float dt) {
		PerformanceFrame.startAction(system.getClass().getSimpleName());
		system.update(dt);
		PerformanceFrame.endAction(system.getClass().getSimpleName());
	}

}
