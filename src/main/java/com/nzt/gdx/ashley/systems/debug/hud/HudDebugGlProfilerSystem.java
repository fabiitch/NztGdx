package com.nzt.gdx.ashley.systems.debug.hud;

import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.gdx.graphics.Color;
import com.nzt.gdx.debug.gl.NzGLProfiler;

public class HudDebugGlProfilerSystem extends EntitySystem {
    private final NzGLProfiler profiler;

    public HudDebugGlProfilerSystem(NzGLProfiler profiler, int positionOnStage,
                                    Color color, int systemOrder) {
        super(systemOrder);
        this.profiler = profiler;
        profiler.initHudDebug(positionOnStage, color);
        profiler.active();
    }

    public void active() {
        profiler.active();
    }

    public void desactive() {
        profiler.desactive();
    }

    @Override
    public void update(float dt) {
        profiler.updateHudDebug();
    }
}
