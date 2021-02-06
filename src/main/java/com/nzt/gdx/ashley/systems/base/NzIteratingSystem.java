package com.nzt.gdx.ashley.systems.base;

import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.nzt.gdx.debug.perf.frame.PerformanceFrameUtils;

public abstract class NzIteratingSystem extends IteratingSystem {

    public NzIteratingSystem(Family family) {
        super(family);
    }

    public NzIteratingSystem(Family family, int priority) {
        super(family, priority);
    }

    @Override
    public void update (float dt) {
        PerformanceFrameUtils.startSystem(this);
        super.update(dt);
        PerformanceFrameUtils.endSystem(this);
    }

}
