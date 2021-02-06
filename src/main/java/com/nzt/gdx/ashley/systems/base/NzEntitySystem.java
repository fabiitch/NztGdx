package com.nzt.gdx.ashley.systems.base;

import com.badlogic.ashley.core.EntitySystem;
import com.nzt.gdx.debug.perf.frame.PerformanceFrameUtils;

public abstract class NzEntitySystem extends EntitySystem {
    public NzEntitySystem() {
        super();
    }

    public NzEntitySystem(int priority) {
        super(priority);
    }

    public void update(float dt) {
        PerformanceFrameUtils.startSystem(this);
        doUpdate(dt);
        PerformanceFrameUtils.endSystem(this);
    }

    public abstract void doUpdate(float dt);
}
