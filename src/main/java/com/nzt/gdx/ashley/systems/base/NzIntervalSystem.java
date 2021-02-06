package com.nzt.gdx.ashley.systems.base;

import com.badlogic.ashley.systems.IntervalSystem;
import com.nzt.gdx.debug.perf.frame.PerformanceFrameUtils;

public abstract class NzIntervalSystem extends IntervalSystem {
    public NzIntervalSystem(float interval) {
        super(interval);
    }

    public NzIntervalSystem(float interval, int priority) {
        super(interval, priority);
    }

    public void update(float dt) {
        PerformanceFrameUtils.startSystem(this);
        super.update(dt);
        PerformanceFrameUtils.endSystem(this);
    }
}
