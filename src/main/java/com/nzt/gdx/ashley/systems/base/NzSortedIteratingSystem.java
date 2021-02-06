package com.nzt.gdx.ashley.systems.base;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.SortedIteratingSystem;
import com.nzt.gdx.debug.perf.frame.PerformanceFrameUtils;

import java.util.Comparator;

public abstract class NzSortedIteratingSystem extends SortedIteratingSystem {

    public NzSortedIteratingSystem(Family family, Comparator<Entity> comparator) {
        super(family, comparator);
    }

    public NzSortedIteratingSystem(Family family, Comparator<Entity> comparator, int priority) {
        super(family, comparator, priority);
    }

    public void update(float dt) {
        PerformanceFrameUtils.startSystem(this);
        super.update(dt);
        PerformanceFrameUtils.endSystem(this);
    }
}
