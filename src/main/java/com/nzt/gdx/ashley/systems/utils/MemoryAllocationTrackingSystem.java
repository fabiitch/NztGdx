package com.nzt.gdx.ashley.systems.utils;

import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.gdx.graphics.Color;
import com.nzt.gdx.debug.hud.core.HudDebug;
import com.nzt.gdx.utils.GdxUtils;

//TODO a revoir ...
public class MemoryAllocationTrackingSystem extends EntitySystem {

    private final long memoryStart;
    private boolean addedToHud = false;

    public MemoryAllocationTrackingSystem() {
        this.memoryStart = GdxUtils.getHeapMb();
    }

    @Override
    public void update(float deltaTime) {
        if (GdxUtils.getHeapMb() > this.memoryStart) {
            if (!addedToHud) {
                HudDebug.addTopLeft("Memory Grow", GdxUtils.getHeapMb() - this.memoryStart + " MB", Color.RED);
                addedToHud = true;
            } else
                HudDebug.update("Memory Grow", GdxUtils.getHeapMb() - this.memoryStart + " MB");
        }
    }
}
