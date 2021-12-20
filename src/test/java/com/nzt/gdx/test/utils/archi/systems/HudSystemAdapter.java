package com.nzt.gdx.test.utils.archi.systems;

import com.nzt.gdx.ashley.systems.hud.BaseHudSystem;
import com.nzt.gdx.scene2D.nz.NzStage;

public class HudSystemAdapter extends BaseHudSystem {

    public HudSystemAdapter(NzStage stage) {
        super(stage, 15);
    }

    @Override
    public void doUpdate(float dt) {
    }

}
