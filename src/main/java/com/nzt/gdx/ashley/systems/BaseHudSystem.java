package com.nzt.gdx.ashley.systems;

import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.nzt.gdx.ashley.NztSystemsOrder;
import com.nzt.gdx.debug.perf.frame.PerformanceFrameUtils;

public abstract class BaseHudSystem extends EntitySystem {

	public Stage stage;
	public Viewport viewportStage;

	public BaseHudSystem(Stage stage) {
		this(stage, NztSystemsOrder.HUD);
		this.viewportStage = stage.getViewport();
	}

	public BaseHudSystem(Stage stage, int order) {
		super(order);
		this.stage = stage;
	}

	public abstract void doUpdate(float dt);

	@Override
	public void update(float dt) {
		PerformanceFrameUtils.startSystem(this);
		super.update(dt);
		doUpdate(dt);
		stage.act(dt);
		stage.draw();
		PerformanceFrameUtils.endSystem(this);
	}

	public void dispose() {
		stage.dispose();
	}

	public void resize(int width, int height) {
		stage.getViewport().update(width, height, true);
	}
}
