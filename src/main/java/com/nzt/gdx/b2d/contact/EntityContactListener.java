package com.nzt.gdx.b2d.contact;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.nzt.gdx.ashley.components.RemoveEntityComponent;
import com.nzt.gdx.ashley.components.TypeComponent;
import com.nzt.gdx.ashley.components.physx.B2DBodyComponent;
import com.nzt.gdx.b2d.factory.B2DEventFactory;
import com.nzt.gdx.logger.tag.LogTagBase;
import com.nzt.gdx.logger.tag.TagLogger;

public abstract class EntityContactListener implements ContactListener {

	public ComponentMapper<TypeComponent> typeMapper = TypeComponent.mapper;
	public ComponentMapper<B2DBodyComponent> b2dMapper = B2DBodyComponent.mapper;
	
	public Engine engine;

	public EntityContactListener(Engine engine) {
		this.engine = engine;
	}

	public void beginContact(Contact contact) {
		Fixture fa = contact.getFixtureA();
		Fixture fb = contact.getFixtureB();

		Entity entityA = (Entity) fa.getBody().getUserData();
		Entity entityB = (Entity) fb.getBody().getUserData();
		debugEvent("Begin Contact", entityA, entityB);
		doBeginContact(entityA, entityB);
	}

	public abstract void doBeginContact(Entity entityA, Entity entityB);

	@Override
	public void endContact(Contact contact) {
		Fixture fa = contact.getFixtureA();
		Fixture fb = contact.getFixtureB();

		Entity entityA = (Entity) fa.getBody().getUserData();
		Entity entityB = (Entity) fb.getBody().getUserData();
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

	private void debugEvent(String eventName, Entity entityA, Entity entityB) {
		TagLogger.log(LogTagBase.B2D_CONTACT, eventName,
				typeMapper.get(entityA).name + " / " + typeMapper.get(entityB).name);
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
	protected boolean testContact(int type1, int type2, Entity entityA, Entity entityB) {
		if ((typeMapper.get(entityA).mask == type1 && typeMapper.get(entityB).mask == type2)
				|| (typeMapper.get(entityA).mask == type2 && typeMapper.get(entityB).mask == type1)) {
			return true;
		}
		return false;
	}

	protected Entity getEntity(int type, Entity userData1, Entity userData2) {
		if (typeMapper.get(userData1).mask == type) {
			return userData1;
		} else {
			return userData2;
		}
	}

	public void destroyEntity(Entity entity){
		this.engine.createComponent(RemoveEntityComponent.class);
		entity.add(this.engine.createComponent(RemoveEntityComponent.class));
		b2dMapper.get(entity).addBox2DEvent(B2DEventFactory.destroy());
	}

}
