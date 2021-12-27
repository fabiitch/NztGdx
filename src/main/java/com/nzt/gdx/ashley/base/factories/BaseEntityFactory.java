package com.nzt.gdx.ashley.base.factories;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.nzt.gdx.ashley.base.components.BaseComponent;
import com.nzt.gdx.ashley.factories.MvtComponentFactory;
import com.nzt.gdx.ashley.factories.PropertiesComponentFactory;
import com.nzt.gdx.ashley.factories.RendersComponentFactory;

//TODO a voir si bien fait la factory comme sa
//TODO un system d'interface pour rajouté de nouvelle factory implements x,y,z

//TODO a rpendre je crois
public class BaseEntityFactory {
    protected Engine engine;
    public MvtComponentFactory mvtFactory;
    public PropertiesComponentFactory propertiesFactory;
    public RendersComponentFactory rendersFactory;

    public BaseEntityFactory(Engine engine) {
        this.engine = engine;
        this.mvtFactory = new MvtComponentFactory(engine);
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
