package com.nzt.gdx.ashley.factories.components;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.ashley.components.physx.ShapeComponent;

public class PhysxComponentFactory extends BaseComponentFactory {
    public PhysxComponentFactory(Engine engine) {
        super(engine);
    }

    public ShapeComponent shapeCircle(Vector2 pos, float radius) {
        ShapeComponent component = engine.createComponent(ShapeComponent.class);
        Circle circle = new Circle(pos.x, pos.y, radius);
        component.shape = circle;
        return component;
    }

    public ShapeComponent shapeCircle(float x, float y, float radius) {
        ShapeComponent component = engine.createComponent(ShapeComponent.class);
        Circle circle = new Circle(x, y, radius);
        component.shape = circle;
        return component;
    }

    public ShapeComponent shapeRectangle(Rectangle rect) {
        ShapeComponent component = engine.createComponent(ShapeComponent.class);
        component.shape = new Rectangle(rect);
        return component;
    }
}
