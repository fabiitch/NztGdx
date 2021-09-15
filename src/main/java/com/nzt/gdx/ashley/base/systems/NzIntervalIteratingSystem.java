package com.nzt.gdx.ashley.base.systems;

import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IntervalIteratingSystem;
import com.nzt.gdx.debug.perf.PerformanceFrame;

public abstract class NzIntervalIteratingSystem extends IntervalIteratingSystem {

    public NzIntervalIteratingSystem(Family family, float interval, int priority) {
        super(family, interval, priority);
        PerformanceFrame.addSystem(this);
    }

    public NzIntervalIteratingSystem(Family family, float interval) {
        this(family, interval, 0);
    }

    @Override
    public void update(float dt) {
        PerformanceFrame.startSystem(this);
        super.update(dt);
        PerformanceFrame.endSystem(this);
    }

}
