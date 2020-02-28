package com.nzt.gdx.b2D.contact;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.nzt.gdx.ashley.components.PositionComponent;
import com.nzt.gdx.ashley.components.TypeComponent;
import com.nzt.gdx.ashley.components.physx.B2DBodyComponent;
import com.nzt.gdx.ashley.entities.EntityWrapper;
import com.nzt.gdx.logger.tag.LogTagBase;
import com.nzt.gdx.logger.tag.TagLogger;

public abstract class EntityContactListener implements ContactListener {
	protected ComponentMapper<TypeComponent> typeCMapper = ComponentMapper.getFor(TypeComponent.class);

	@Override
	public void beginContact(Contact contact) {
		Fixture fa = contact.getFixtureA();
		Fixture fb = contact.getFixtureB();

		Entity entityA = (Entity) fa.getBody().getUserData();
		Entity entityB = (Entity) fb.getBody().getUserData();

		TypeComponent typeA = typeCMapper.get(entityA);
		TypeComponent typeB = typeCMapper.get(entityB);
		debugEvent("Begin Contact", typeA, typeB);

		doBeginContact(entityA, entityB);
	}

	public abstract void doBeginContact(Entity entityA, Entity entityB);

	@Override
	public void endContact(Contact contact) {
		Fixture fa = contact.getFixtureA();
		Fixture fb = contact.getFixtureB();
		Entity entityA = (Entity) fa.getBody().getUserData();
		Entity entityB = (Entity) fb.getBody().getUserData();
		TypeComponent typeA = typeCMapper.get(entityA);
		TypeComponent typeB = typeCMapper.get(entityB);
		debugEvent("End Contact", typeA, typeB);
	}

	@Override
	public void preSolve(Contact contact, Manifold oldManifold) {
		// TODO Auto-generated method stub

	}

	@Override
	public void postSolve(Contact contact, ContactImpulse impulse) {
		// TODO Auto-generated method stub

	}

	private void debugEvent(String eventName, TypeComponent typeA, TypeComponent typeB) {
		TagLogger.log(LogTagBase.B2D_CONTACT, eventName, typeA.name + " / " + typeB.name);
	}

	/**
	 * test contact between object
	 * 
	 * @param class1
	 * @param class2
	 * @param entityA
	 * @param entityB
	 * @return
	 */
	protected boolean testContact(Class<? extends E> class1, Class<? extends E> class2, E entityA, E entityB) {
		if (entityA.getClass() == class1 && entityB.getClass() == class2
				|| entityB.getClass() == class1 && entityA.getClass() == class2) {
			return true;
		}
		return false;
	}

	protected <W extends E> W getGameObject(Class<W> classAsk, E userData1, Object userData2) {
		if (userData1.getClass() == classAsk) {
			return classAsk.cast(userData1);
		} else {
			return classAsk.cast(userData2);
		}
	}

}
