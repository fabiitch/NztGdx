package com.nzt.gdx.ashley.factories;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.nzt.gdx.ashley.components.abstracts.BaseComponent;
import com.nzt.gdx.ashley.factories.list.*;

//TODO a voir si bien fait la factory comme sa
//TODO un system d'interface pour rajouté de nouvelle factory implements x,y,z

public class BaseEntityFactory {
    protected Engine engine;
    public MvtComponentFactory mvtFactory;
    public B2DComponentFactory b2DFactory;
//    public PhysxComponentFactory physxFactory;
    public PropertiesComponentFactory propertiesFactory;
    public RendersComponentFactory rendersFactory;

    public BaseEntityFactory(Engine engine) {
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

    protected Entity createEntity() {
        Entity newEntity = this.engine.createEntity();
        engine.addEntity(newEntity);
        return newEntity;
    }

    protected Entity createEntity(boolean add) {
        Entity newEntity = this.engine.createEntity();
        if (add)
            engine.addEntity(newEntity);
        return newEntity;
    }
}
