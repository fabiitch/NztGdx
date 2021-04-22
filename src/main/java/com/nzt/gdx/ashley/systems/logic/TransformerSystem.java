package com.nzt.gdx.ashley.systems.logic;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.nzt.gdx.ashley.NztSystemsOrder;
import com.nzt.gdx.ashley.components.TransformersComponent;
import com.nzt.gdx.debug.perf.PerformanceFrame;

public class TransformerSystem extends IteratingSystem {

	private ComponentMapper<TransformersComponent> transformMapper = TransformersComponent.mapper;

	public TransformerSystem() {
		this(NztSystemsOrder.CALCUL);
	}

	public TransformerSystem(int order) {
		super(Family.one(TransformersComponent.class).get(), order);
		PerformanceFrame.addSystem(this);
	}
	
	@Override
	public void update(float dt) {
		PerformanceFrame.startSystem(this);
		super.update(dt);
		PerformanceFrame.endSystem(this);
	}

	@Override
	protected void processEntity(Entity entity, float deltaTime) {
		transformMapper.get(entity).update(deltaTime);
	}

}
