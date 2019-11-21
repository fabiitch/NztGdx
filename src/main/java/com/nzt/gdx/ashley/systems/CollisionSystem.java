package com.nzt.gdx.ashley.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.nzt.gdx.ashley.components.physx.CollisionComponent;

public class CollisionSystem extends IteratingSystem {
	ComponentMapper<CollisionComponent> cm;

	public CollisionSystem() {
		// only need to worry about player collisions
		super(Family.all(CollisionComponent.class).get());

		cm = ComponentMapper.getFor(CollisionComponent.class);
	}

	@Override
	protected void processEntity(Entity entity, float deltaTime) {

	}

}
