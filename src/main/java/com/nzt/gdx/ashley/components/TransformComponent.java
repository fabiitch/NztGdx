package com.nzt.gdx.ashley.components;

import com.badlogic.gdx.math.Vector3;
import com.nzt.gdx.ashley.components.base.PoolableComponent;

/**
 * Position component, contains V3 position and rotation.
 * @author fabiitch
 *
 */
public class TransformComponent extends PoolableComponent {
	public final Vector3 position = new Vector3();
	public float angle = 0.0f;

	public TransformComponent() {
		super();
	}

	@Override
	public void reset() {
		this.position.set(0, 0, 0);
		this.angle = 0f;

	}
}
