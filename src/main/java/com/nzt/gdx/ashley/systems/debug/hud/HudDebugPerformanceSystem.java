package com.nzt.gdx.ashley.systems.debug.hud;

import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.gdx.graphics.Color;
import com.nzt.gdx.debug.perf.HudDebugPerformanceFrame;

public class HudDebugPerformanceSystem extends EntitySystem {

    private final HudDebugPerformanceFrame performanceFrame;

    public HudDebugPerformanceSystem(int positionOnStage, Color color, int systemOrder) {
        super(systemOrder);
        performanceFrame = new HudDebugPerformanceFrame(positionOnStage, color);
    }

    @Override
    public void update(float dt) {
        performanceFrame.update(dt);
    }
}
