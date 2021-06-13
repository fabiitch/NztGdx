package com.nzt.gdx.ashley.base.factories;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.nzt.gdx.ashley.base.components.BaseComponent;
import com.nzt.gdx.ashley.factories.B2DComponentFactory;
import com.nzt.gdx.ashley.factories.MvtComponentFactory;
import com.nzt.gdx.ashley.factories.PropertiesComponentFactory;
import com.nzt.gdx.ashley.factories.RendersComponentFactory;

//TODO a voir si bien fait la factory comme sa
//TODO un system d'interface pour rajouté de nouvelle factory implements x,y,z

public class EntityFactory {
    protected Engine engine;
    public MvtComponentFactory mvtFactory;
    public B2DComponentFactory b2DFactory;
    //    public PhysxComponentFactory physxFactory;
    public PropertiesComponentFactory propertiesFactory;
    public RendersComponentFactory rendersFactory;

    public EntityFactory(Engine engine) {
        this.engine = engine;
        this.mvtFactory = new MvtComponentFactory(engine);
        this.b2DFactory = new B2DComponentFactory(engine);
//        this.physxFactory = new PhysxComponentFactory(engine);
        this.propertiesFactory = new PropertiesComponentFactory(engine);
        this.rendersFactory = new RendersComponentFactory(engine);
    }

    protected <T extends BaseComponent> T createComponent(Class<T> componentType) {
        return this.engine.createComponent(componentType);
    }

    /**
     * Create and Add entity to engine
     */
    public Entity createEntity() {
        Entity newEntity = this.engine.createEntity();
        engine.addEntity(newEntity);
        return newEntity;
    }

    public Entity createEntity(boolean add) {
        Entity newEntity = this.engine.createEntity();
        if (add)
            engine.addEntity(newEntity);
        return newEntity;
    }
}
