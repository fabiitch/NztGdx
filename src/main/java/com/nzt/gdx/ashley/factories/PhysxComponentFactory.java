package com.nzt.gdx.ashley.factories.list;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.ashley.components.physx.PhysXComponent;
import com.nzt.gdx.ashley.systems.physx.NzShape2DTypes;

public class PhysxComponentFactory extends BaseComponentFactory {
    public PhysxComponentFactory(Engine engine) {
        super(engine);
    }

    public PhysXComponent shapeCircle(Vector2 pos, float radius, boolean isStatic) {
        return shapeCircle(pos.x, pos.y, radius, isStatic);
    }

    public PhysXComponent shapeCircle(float x, float y, float radius, boolean isStatic) {
        PhysXComponent component = engine.createComponent(PhysXComponent.class);
        Circle circle = new Circle(x, y, radius);
        component.shape = circle;
        component.nzShapeType = NzShape2DTypes.CIRCLE;

        component.isStatic = isStatic;
        return component;
    }

    public PhysXComponent shapeRectangle(Rectangle rect, boolean isStatic) {
        PhysXComponent component = engine.createComponent(PhysXComponent.class);
        component.shape = new Rectangle(rect);
        component.nzShapeType = NzShape2DTypes.RECTANGLE;

        component.isStatic = isStatic;
        return component;
    }
}
