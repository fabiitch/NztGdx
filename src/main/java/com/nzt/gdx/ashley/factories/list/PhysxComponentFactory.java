package com.nzt.gdx.ashley.factories.list;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.ashley.components.physx.PhysxComponent;
import com.nzt.gdx.ashley.systems.physx.NzShapeTypes;
import com.nzt.gdx.math.nzshape2d.NzCircle;
import com.nzt.gdx.math.nzshape2d.NzRectangle;

public class PhysxComponentFactory extends BaseComponentFactory {
    public PhysxComponentFactory(Engine engine) {
        super(engine);
    }

    public PhysxComponent shapeCircle(Vector2 pos, float radius, boolean isStatic) {
        PhysxComponent component = engine.createComponent(PhysxComponent.class);
        NzCircle circle = new NzCircle(pos.x, pos.y, radius);
        component.shape = circle;
        component.nzShapeType = NzShapeTypes.CIRCLE;

        component.isStatic = isStatic;
        return component;
    }

    public PhysxComponent shapeCircle(float x, float y, float radius, boolean isStatic) {
        PhysxComponent component = engine.createComponent(PhysxComponent.class);
        NzCircle circle = new NzCircle(x, y, radius);
        component.shape = circle;
        component.nzShapeType = NzShapeTypes.CIRCLE;

        component.isStatic = isStatic;
        return component;
    }

    public PhysxComponent shapeRectangle(Rectangle rect, boolean isStatic) {
        PhysxComponent component = engine.createComponent(PhysxComponent.class);
        component.shape = new NzRectangle(rect);
        component.nzShapeType = NzShapeTypes.RECTANGLE;

        component.isStatic = isStatic;
        return component;
    }
}
