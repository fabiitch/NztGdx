package com.nzt.gdx.ashley.components.mvt;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.ashley.components.abstracts.PoolableComponent;
import com.nzt.gdx.ashley.components.physx.B2DBodyComponent;

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

	public static void updateVelocityFromBody(Entity entity) {
		Velocity2DComponent velocity2DComponent = mapper.get(entity);
		if (velocity2DComponent != null) { // les static n'ont pas de vel
			B2DBodyComponent b2DBodyComponent = B2DBodyComponent.mapper.get(entity);
			Vector2 linearVelocity = b2DBodyComponent.body.getLinearVelocity();
			velocity2DComponent.velocity.set(linearVelocity);
		}
	}

	// TODO a voir si  pas crée une variable simple
	public Vector2 getDir() {
		return velocity.cpy().nor();
	}

	public float getSpeed() {
		return velocity.len();
	}
}
