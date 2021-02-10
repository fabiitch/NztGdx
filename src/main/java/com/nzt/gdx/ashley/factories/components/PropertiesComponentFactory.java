package com.nzt.gdx.ashley.factories.components;

import com.badlogic.ashley.core.Engine;
import com.nzt.gdx.ashley.components.properties.TypeComponent;

public class PropertiesComponentFactory extends BaseComponentFactory {
    public PropertiesComponentFactory(Engine engine) {
        super(engine);
    }

    public TypeComponent type(short mask, String name) {
        TypeComponent typeComponent = engine.createComponent(TypeComponent.class);
        typeComponent.mask = mask;
        typeComponent.name = name;
        return typeComponent;
    }
}
