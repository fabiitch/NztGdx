package com.nzt.gdx.ashley.components;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.math.Vector3;
import com.nzt.gdx.ashley.components.base.BasePoolableComponent;

public class TransformComponent extends BasePoolableComponent {
	public TransformComponent(Entity entity) {
		super(entity);
	}

	public final Vector3 position = new Vector3();
	public float angle = 0.0f;

	@Override
	public void reset() {
		System.out.println("reser");
		this.position.set(0, 0, 0);
		this.angle = 0f;

	}
}
