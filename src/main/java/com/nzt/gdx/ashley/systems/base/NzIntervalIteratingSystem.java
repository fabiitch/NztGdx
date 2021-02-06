package com.nzt.gdx.ashley.systems.base;

import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IntervalIteratingSystem;
import com.nzt.gdx.debug.perf.frame.PerformanceFrameUtils;

public abstract class NzIntervalIteratingSystem extends IntervalIteratingSystem {

    public NzIntervalIteratingSystem(Family family, float interval) {
        super(family, interval);
    }

    public NzIntervalIteratingSystem(Family family, float interval, int priority) {
        super(family, interval, priority);
    }

    public void update(float dt) {
        PerformanceFrameUtils.startSystem(this);
        super.update(dt);
        PerformanceFrameUtils.endSystem(this);
    }
}
