package com.nzt.gdx.b2d.contact;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.physics.box2d.*;
import com.nzt.gdx.ashley.components.physx.B2DBodyComponent;
import com.nzt.gdx.ashley.components.properties.RemoveEntityComponent;
import com.nzt.gdx.ashley.components.properties.TypeComponent;
import com.nzt.gdx.b2d.factories.B2DEventFactory;
import com.nzt.gdx.debug.B2DDebug;
import com.nzt.gdx.logger.tag.LogTagsBase;
import com.nzt.gdx.logger.tag.TagLogger;

public abstract class EntityContactListener implements ContactListener {
    //TODO conditions debug contact

    public ComponentMapper<TypeComponent> typeMapper = TypeComponent.mapper;
    public ComponentMapper<B2DBodyComponent> b2dMapper = B2DBodyComponent.mapper;

    public Engine engine;


    public static boolean LOG_EVENT = true;
    public static boolean LOG_DETAILS = false;

    public EntityContactListener(Engine engine) {
        this.engine = engine;
    }

    public void beginContact(Contact contact) {
        Fixture fa = contact.getFixtureA();
        Fixture fb = contact.getFixtureB();

        Entity entityA = (Entity) fa.getBody().getUserData();
        Entity entityB = (Entity) fb.getBody().getUserData();

        logContactEvent("Begin Contact", entityA, entityB);
//        logContactDetails("Begin Contact", contact);

        doBeginContact(contact, entityA, entityB);
    }

    public abstract void doBeginContact(Contact contact, Entity entityA, Entity entityB);

    public abstract void doEndContact(Contact contact, Entity entityA, Entity entityB);


    @Override
    public void endContact(Contact contact) {
        Fixture fa = contact.getFixtureA();
        Fixture fb = contact.getFixtureB();
        Entity entityA = (Entity) fa.getBody().getUserData();
        Entity entityB = (Entity) fb.getBody().getUserData();

        logContactEvent("End Contact", entityA, entityB);
//        logContactDetails("End Contact", contact);

        doEndContact(contact, entityA, entityB);

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {
        // TODO Auto-generated method stub

    }

    /**
     * test contact between object
     *
     * @param type1
     * @param type2
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

    protected void logContactEvent(String eventName, Entity entityA, Entity entityB) {
        TagLogger.info(LogTagsBase.B2D_CONTACT, eventName,
                typeMapper.get(entityA).name + " / " + typeMapper.get(entityB).name);
    }

    protected void logContactDetails(String eventName, Contact contact) {
        B2DDebug.debugContact(eventName, contact);
    }

    public void destroyEntity(Entity entity) {
        entity.add(RemoveEntityComponent.getNew());
        b2dMapper.get(entity).addBox2DEvent(B2DEventFactory.destroy());
    }

}
