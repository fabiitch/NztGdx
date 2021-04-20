package com.nzt.gdx.ashley.systems.hud;

import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.nzt.gdx.ashley.NztSystemsOrder;
import com.nzt.gdx.debug.perf.frame.PerformanceFrameUtils;
import com.nzt.gdx.scene2D.nz.NzStage;

public abstract class BaseHudSystem extends EntitySystem {

	public NzStage nzStage;
	public Viewport viewportStage;

	public BaseHudSystem(NzStage stage) {
		this(stage, NztSystemsOrder.HUD);
		this.viewportStage = stage.getViewport();
	}

	public BaseHudSystem(NzStage stage, int order) {
		super(order);
		this.nzStage = stage;
	}

	public abstract void doUpdate(float dt);

	@Override
	public void update(float dt) {
		PerformanceFrameUtils.startSystem(this);
		super.update(dt);
		doUpdate(dt);
		nzStage.act(dt);
		nzStage.draw();
		PerformanceFrameUtils.endSystem(this);
	}

	public void dispose() {
		nzStage.dispose();
	}

	public void resize(int width, int height) {
		this.nzStage.resize(width, height);
	}
}
