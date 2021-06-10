package com.nzt.gdx.test.trials.st.perf.memory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.nzt.gdx.ashley.systems.utils.MemoryAllocationTrackingSystem;
import com.nzt.gdx.debug.hud.core.HudDebug;
import com.nzt.gdx.scene2D.nz.NzStage;
import com.nzt.gdx.test.trials.st.scene2D.Scene2DTestConstants;
import com.nzt.gdx.test.trials.tester.archi.main.FastTesterMain;
import com.nzt.gdx.test.trials.tester.archi.screens.systems.BaseSystemTestScreen;
import com.nzt.gdx.test.trials.tester.selector.TestScreen;

@TestScreen(group = "perf.malloc")
public class STMallocTrackingSystem extends BaseSystemTestScreen {
    protected NzStage nzStage;
    protected Skin skin;

    public STMallocTrackingSystem(FastTesterMain main) {
        super(main);
        this.nzStage = new NzStage();
        this.skin = new Skin(Gdx.files.internal(Scene2DTestConstants.UI_SKIN));
        new HudDebug(nzStage, skin);
        engine.addSystem(new MemoryAllocationTrackingSystem());
    }

    @Override
    protected void renderScreen(float dt) {
        super.renderScreen(dt);
        nzStage.act();
        nzStage.draw();
        for (int i = 0; i < 1000; i++) {
            Vector2 v = new Vector2();
            v.set(1, 0);
        }
    }

    @Override
    protected void doDispose() {
        nzStage.dispose();
        skin.dispose();
    }
}
