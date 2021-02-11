package com.nzt.gdx.ashley.factories.components;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.ashley.components.physx.NzShapeComponent;
import com.nzt.gdx.math.nzshape2d.NzCircle;
import com.nzt.gdx.math.nzshape2d.NzRectangle;

public class PhysxComponentFactory extends BaseComponentFactory {
    public PhysxComponentFactory(Engine engine) {
        super(engine);
    }

    public NzShapeComponent shapeCircle(Vector2 pos, float radius) {
        NzShapeComponent component = engine.createComponent(NzShapeComponent.class);
        NzCircle circle = new NzCircle(pos.x, pos.y, radius);
        component.shape = circle;
        return component;
    }

    public NzShapeComponent shapeCircle(float x, float y, float radius) {
        NzShapeComponent component = engine.createComponent(NzShapeComponent.class);
        NzCircle circle = new NzCircle(x, y, radius);
        component.shape = circle;
        return component;
    }

    public NzShapeComponent shapeRectangle(Rectangle rect) {
        NzShapeComponent component = engine.createComponent(NzShapeComponent.class);
        component.shape = new NzRectangle(rect);
        return component;
    }
}
