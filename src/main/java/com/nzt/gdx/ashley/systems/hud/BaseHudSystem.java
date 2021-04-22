package com.nzt.gdx.ashley.systems.hud;

import com.badlogic.ashley.core.EntitySystem;
import com.nzt.gdx.ashley.NztSystemsOrder;
import com.nzt.gdx.debug.perf.PerformanceFrame;
import com.nzt.gdx.scene2D.nz.NzStage;

public abstract class BaseHudSystem extends EntitySystem {
	public NzStage nzStage;

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
	public void update(float dt) {
		PerformanceFrame.startSystem(this);
		super.update(dt);
		doUpdate(dt);
		nzStage.act(dt);
		nzStage.draw();
		PerformanceFrame.endSystem(this);
	}

	public void dispose() {
		nzStage.dispose();
	}

	public void resize(int width, int height) {
		this.nzStage.resize(width, height);
	}
}
