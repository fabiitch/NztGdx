package com.nzt.gdx.ashley.entities.visitor;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.nzt.gdx.ashley.entities.BaseGameObject;

public class VisitorContactListener extends BaseVisitorGameContactListener<VisitorBaseEntity> {
	/**
	 * visitor pattern
	 * 
	 * @author foccelli
	 *
	 * @param <C>
	 */
	@Override
	public void doBeginContact(VisitorBaseEntity entityA, VisitorBaseEntity entityB) {
		entityA.accept(entityB);
		entityB.accept(entityA);
	}

}

abstract class BaseVisitorGameContactListener<E extends BaseGameObject>
		implements com.badlogic.gdx.physics.box2d.ContactListener {
	public boolean debugContact = true;

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
		if (debugContact) {
			System.out.println("-----------" + eventName + "-----------");
			System.out.println("entityA :" + entityA.name);
			System.out.println("entityB :" + entityB.name);
			System.out.println("--------------------------------------");
		}
	}
}