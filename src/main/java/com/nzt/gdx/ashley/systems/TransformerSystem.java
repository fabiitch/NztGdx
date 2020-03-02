package com.nzt.gdx.ashley.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.nzt.gdx.ashley.components.TransformersComponent;

public class TransformerSystem extends IteratingSystem {

	private ComponentMapper<TransformersComponent> tcMapper = ComponentMapper.getFor(TransformersComponent.class);

	public TransformerSystem() {
		super(Family.one(TransformersComponent.class).get(),BaseSystemsContants.CALCUL);
	}

	@Override
	protected void processEntity(Entity entity, float deltaTime) {
		tcMapper.get(entity).update(deltaTime);
	}

}
