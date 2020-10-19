package com.nzt.gdx.ashley.components.mvt;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.ashley.components.abstracts.PoolableComponent;

public class Velocity2DComponent extends PoolableComponent {

	public static ComponentMapper<Velocity2DComponent> mapper = ComponentMapper.getFor(Velocity2DComponent.class);

	public Vector2 velocity = new Vector2();

	public Velocity2DComponent() {
		super();
	}

	@Override
	public void reset() {
		this.velocity.setZero();
	}

}
