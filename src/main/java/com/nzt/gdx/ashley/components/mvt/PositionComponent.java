package com.nzt.gdx.ashley.components.mvt;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.gdx.math.Vector3;
import com.nzt.gdx.ashley.components.abstracts.PoolableComponent;

/**
 * Position component, contains V3 position and rotation.
 * 
 * @author fabiitch
 *
 */
public class PositionComponent extends PoolableComponent {
	
	public static ComponentMapper<PositionComponent> mapper = ComponentMapper.getFor(PositionComponent.class);

	public final Vector3 position = new Vector3();
	public float angleRadian = 0.0f;

	public PositionComponent() {
		super();
	}

	@Override
	public void reset() {
		this.position.setZero();
		this.angleRadian = 0f;

	}
}
