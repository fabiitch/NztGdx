package com.nzt.gdx.ashley.components.physx;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pools;
import com.nzt.gdx.ashley.components.abstracts.PoolableComponent;
import com.nzt.gdx.ashley.systems.b2d.B2DWorldSystem;
import com.nzt.gdx.ashley.systems.render.B2DDebugSystem;
import com.nzt.gdx.b2d.events.B2DEvent;
import com.nzt.gdx.b2d.events.impl.properties.DestroyBodyEvent;

/**
 * Box2D body component used by system : {@link B2DWorldSystem} and
 * {@link B2DDebugSystem}
 *
 * @author fabiitch
 */
public class B2DBodyComponent extends PoolableComponent {

    public static ComponentMapper<B2DBodyComponent> mapper = ComponentMapper.getFor(B2DBodyComponent.class);

    public Body body;
    public Array<B2DEvent> eventArray;

    public B2DBodyComponent() {
        super();
        eventArray = new Array<>();
    }

    @Override
    public void reset() {
        this.body = null;
        this.eventArray = new Array<>();
    }

    public void addBox2DEvent(B2DEvent... events) {
        eventArray.addAll(events);
    }

    public void addBox2DEvent(B2DEvent event) {
        eventArray.add(event);
    }

    public boolean checkContainsDestroyEvent() {
        for (B2DEvent event : eventArray) {
            if (event.getClass() == DestroyBodyEvent.class)
                return true;
        }
        return false;
    }

    public void processAllEvents(World world) {
        boolean destroy = checkContainsDestroyEvent();
        if (destroy) {
            world.destroyBody(body);
            this.body = null;
        } else {
            for (B2DEvent event : eventArray) {
                event.apply(body);
            }
        }
        Pools.freeAll(eventArray);
        eventArray.clear();
    }

}
