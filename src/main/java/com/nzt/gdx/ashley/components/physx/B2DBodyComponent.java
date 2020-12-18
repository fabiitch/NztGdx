package com.nzt.gdx.ashley.components.physx;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Pools;
import com.nzt.gdx.ashley.components.abstracts.PoolableComponent;
import com.nzt.gdx.ashley.systems.b2d.B2DWorldSystem;
import com.nzt.gdx.ashley.systems.render.B2DDebugSystem;
import com.nzt.gdx.b2d.events.B2DBaseEvent;
import com.nzt.gdx.b2d.events.B2DEventContainer;

/**
 * Box2D body component used by system : {@link B2DWorldSystem} and
 * {@link B2DDebugSystem}
 *
 * @author fabiitch
 */
public class B2DBodyComponent extends PoolableComponent {

    public static ComponentMapper<B2DBodyComponent> mapper = ComponentMapper.getFor(B2DBodyComponent.class);

    public Body body;
    public B2DEventContainer eventContainer;

    public B2DBodyComponent() {
        super();
        this.eventContainer = new B2DEventContainer();
    }

    @Override
    public void reset() {
        this.body = null;
        this.eventContainer.reset();
    }

    public void addBox2DEvent(B2DBaseEvent... events) {
        eventContainer.addEvent(events);
    }

    public void addBox2DEvent(B2DBaseEvent event) {
        eventContainer.addEvent(event);
    }

    public boolean checkContainsDestroyEvent() {
        return eventContainer.checkContainsDestroyEvent();
    }

    public void processAllEvents(World world) {
        boolean destroy = checkContainsDestroyEvent();
        if (destroy) {
            world.destroyBody(body);
            this.body = null;
        } else {
            for (B2DBaseEvent event : eventContainer.eventArray) {
                event.apply(body);
            }
        }
        Pools.freeAll(eventContainer.eventArray);
        eventContainer.reset();
    }

}
