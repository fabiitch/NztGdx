package com.nzt.gdx.b2d.contact;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.nzt.gdx.ashley.entities.BaseGameObject;
import com.nzt.gdx.utils.logger.LogTagBase;
import com.nzt.gdx.utils.logger.TagLogger;

public abstract class BaseGameContactListener<E extends BaseGameObject> implements ContactListener {

	@SuppressWarnings("unchecked")
	@Override
	public void beginContact(Contact contact) {
		Fixture fa = contact.getFixtureA();
		Fixture fb = contact.getFixtureB();

		E entityA = (E) fa.getBody().getUserData();
		E entityB = (E) fb.getBody().getUserData();
		debugEvent("Begin Contact", entityA, entityB);

		doBeginContact(entityA, entityB);
	}

	public abstract void doBeginContact(E entityA, E entityB);

	@Override
	public void endContact(Contact contact) {
		Fixture fa = contact.getFixtureA();
		Fixture fb = contact.getFixtureB();
		BaseGameObject entityA = (BaseGameObject) fa.getBody().getUserData();
		BaseGameObject entityB = (BaseGameObject) fb.getBody().getUserData();
		debugEvent("End Contact", entityA, entityB);
	}

	@Override
	public void preSolve(Contact contact, Manifold oldManifold) {
		// TODO Auto-generated method stub

	}

	@Override
	public void postSolve(Contact contact, ContactImpulse impulse) {
		// TODO Auto-generated method stub

	}

	private void debugEvent(String eventName, BaseGameObject entityA, BaseGameObject entityB) {
		TagLogger.log(LogTagBase.B2D_CONTACT, eventName, entityA.name + " / " + entityB.name);
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
