package com.nzt.gdx.ashley.systems.hud;

import com.nzt.gdx.ashley.NztSystemsOrder;
import com.nzt.gdx.ashley.base.systems.NzEntitySystem;
import com.nzt.gdx.debug.perf.PerformanceFrame;
import com.nzt.gdx.scene2D.nz.NzStage;

public abstract class BaseHudSystem extends NzEntitySystem {
	public final NzStage nzStage;

	public BaseHudSystem(NzStage stage) {
		this(stage, NztSystemsOrder.HUD);
	}

	public BaseHudSystem(NzStage stage, int order) {
		super(order);
		this.nzStage = stage;
		PerformanceFrame.addSystem(this);
	}

	public abstract void doUpdate(float dt);

	@Override
	public void updateSystem(float dt) {
		doUpdate(dt);
		nzStage.act(dt);
		nzStage.draw();
	}

	public void dispose() {
		nzStage.dispose();
	}

	public void resize(int width, int height) {
		this.nzStage.resize(width, height);
	}
}
