package com.nzt.gdx.ashley.components.physx;

import com.badlogic.ashley.core.Entity;
import com.nzt.gdx.ashley.components.base.BaseComponent;
import com.nzt.gdx.ashley.entities.BaseGameObject;

public class CollisionComponent extends BaseComponent {
	public CollisionComponent(Entity e) {
		super(e);
	}

	public BaseGameObject collisionEntity;

}
