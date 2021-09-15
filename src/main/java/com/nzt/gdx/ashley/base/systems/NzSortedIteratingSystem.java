package com.nzt.gdx.ashley.base.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.SortedIteratingSystem;
import com.nzt.gdx.debug.perf.PerformanceFrame;

import java.util.Comparator;

public abstract class NzSortedIteratingSystem extends SortedIteratingSystem {

    public NzSortedIteratingSystem(Family family, Comparator<Entity> comparator, int priority) {
        super(family, comparator, priority);
        PerformanceFrame.addSystem(this);
    }

    public NzSortedIteratingSystem(Family family, Comparator<Entity> comparator) {
        this(family, comparator, 0);

    }

    @Override
    public void update(float dt) {
        PerformanceFrame.startSystem(this);
        super.update(dt);
        PerformanceFrame.endSystem(this);
    }

}
