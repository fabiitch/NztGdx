package com.nzt.gdx.ashley.components;

import com.badlogic.gdx.math.Vector3;
import com.nzt.gdx.ashley.components.base.BasePoolableComponent;

public class TransformComponent extends BasePoolableComponent {
	public final Vector3 position = new Vector3();
	public float rotation = 0.0f;

	@Override
	public void reset() {
		this.position.set(0, 0, 0);
		this.rotation = 0f;

	}
}
