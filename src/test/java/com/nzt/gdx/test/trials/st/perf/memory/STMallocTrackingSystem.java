package com.nzt.gdx.test.trials.st.perf.memory;

import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.ashley.systems.utils.MemoryAllocationTrackingSystem;
import com.nzt.gdx.test.trials.tester.archi.main.FastTesterMain;
import com.nzt.gdx.test.trials.tester.archi.screens.BaseSystemTestScreen;
import com.nzt.gdx.test.trials.tester.selector.TestScreenList;

@TestScreenList(group = "perf.malloc")
public class STMallocTrackingSystem extends BaseSystemTestScreen {

    public STMallocTrackingSystem(FastTesterMain main) {
        super(main);
        engine.addSystem(new MemoryAllocationTrackingSystem());
    }

    @Override
    public String getExplication() {
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
