package com.nzt.gdx.ashley.factories.list;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.physics.box2d.Body;
import com.nzt.gdx.ashley.components.b2d.B2DBodyComponent;

public class B2DComponentFactory extends BaseComponentFactory {
    public B2DComponentFactory(Engine engine) {
        super(engine);
    }

    public B2DBodyComponent b2DBody(Body body) {
        B2DBodyComponent box2dBodyComponent = engine.createComponent(B2DBodyComponent.class);
        box2dBodyComponent.body = body;
        return box2dBodyComponent;
    }
}
