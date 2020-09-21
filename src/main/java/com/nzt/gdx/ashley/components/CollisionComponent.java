package com.nzt.gdx.ashley.components;

import com.badlogic.ashley.core.ComponentMapper;
import com.nzt.gdx.ashley.components.base.PoolableComponent;

public class CollisionComponent extends PoolableComponent {

	public static ComponentMapper<CollisionComponent> mapper = ComponentMapper.getFor(CollisionComponent.class);

	@Override
	public void reset() {

	}
}
