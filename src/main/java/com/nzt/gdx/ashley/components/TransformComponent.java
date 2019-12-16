package com.nzt.gdx.ashley.components;

import com.badlogic.gdx.math.Vector3;
import com.nzt.gdx.ashley.components.base.BasePoolableComponent;

/**
 * Position component, contains V3 position and rotation.
 * @author fabiitch
 *
 */
public class TransformComponent extends BasePoolableComponent {
	public TransformComponent() {
		super();
	}	

	public final Vector3 position = new Vector3();
	public float angle = 0.0f;

	@Override
	public void reset() {
		System.out.println("reset");
		this.position.set(0, 0, 0);
		this.angle = 0f;

	}
}
