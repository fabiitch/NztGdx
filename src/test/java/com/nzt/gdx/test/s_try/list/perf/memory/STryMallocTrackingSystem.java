package com.nzt.gdx.test.s_try.list.perf.memory;

import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.ashley.systems.utils.MemoryAllocationTrackingSystem;
import com.nzt.gdx.test.utils.archi.mains.dev.FastTesterMain;
import com.nzt.gdx.test.utils.archi.screens.BaseSystemTestScreen;
import com.nzt.gdx.test.utils.screen_selector.TestScreen;

@TestScreen(group = "utils.perf.malloc")
public class STryMallocTrackingSystem extends BaseSystemTestScreen {

    public STryMallocTrackingSystem(FastTesterMain main) {
        super(main);
        engine.addSystem(new MemoryAllocationTrackingSystem());
    }

    @Override
    public String getTestExplication() {
        return "System qui tracke les alloc sur Gdx";
    }

    @Override
    public void renderTestScreen(float dt) {
        for (int i = 0; i < 1000; i++) {
            Vector2 v = new Vector2();
            v.set(1, 0);
        }
    }

    @Override
    public void disposeTestScreen() {

    }
}
