package com.nzt.gdx.ashley.factories;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.nzt.gdx.ashley.components.mvt.PositionComponent;
import com.nzt.gdx.ashley.components.mvt.Velocity2DComponent;
import com.nzt.gdx.ashley.components.physx.Shape2DComponent;

public class MvtComponentFactory extends BaseComponentFactory {

    public MvtComponentFactory(Engine engine) {
        super(engine);
    }

    public PositionComponent position() {
        return position(0, 0, 0, 0);
    }

    public PositionComponent position(float x, float y) {
        return position(x, y, 0, 0);
    }

    public PositionComponent rectPosition(Rectangle rect) {
        return position(rect.x + rect.width / 2, rect.y + rect.height / 2, 0, 0);
    }

    public PositionComponent rectPosition(Rectangle rect, float z) {
        return position(rect.x + rect.width / 2, rect.y + rect.height / 2, z, 0);
    }

    public PositionComponent position(Vector2 pos) {
        return position(pos.x, pos.y, 0, 0);
    }

    public PositionComponent position(float x, float y, float z) {
        return position(x, y, z, 0);
    }

    public PositionComponent position(float x, float y, float z, float angle) {
        PositionComponent positionComponent = engine.createComponent(PositionComponent.class);
        positionComponent.position.x = x;
        positionComponent.position.y = y;
        positionComponent.position.z = z;
        positionComponent.angleRadian = angle;
        return positionComponent;
    }

    public PositionComponent position(Vector3 pos, float angle) {
        PositionComponent positionComponent = engine.createComponent(PositionComponent.class);
        positionComponent.position.x = pos.x;
        positionComponent.position.y = pos.y;
        positionComponent.position.z = pos.z;
        positionComponent.angleRadian = angle;
        return positionComponent;
    }

    public Velocity2DComponent velocity2D() {
        Velocity2DComponent velocity = engine.createComponent(Velocity2DComponent.class);
        return velocity;
    }

    public Velocity2DComponent velocity2D(Vector2 vel) {
        Velocity2DComponent velocity = engine.createComponent(Velocity2DComponent.class);
        velocity.velocity = vel;
        return velocity;
    }

    public Shape2DComponent shape2D(Circle circle) {
        Shape2DComponent shape2DComponent = engine.createComponent(Shape2DComponent.class);
        shape2DComponent.setCircle(circle);
        return shape2DComponent;
    }

    public Shape2DComponent shape2D(Rectangle rectangle) {
        Shape2DComponent shape2DComponent = engine.createComponent(Shape2DComponent.class);
        shape2DComponent.setRectangle(rectangle);
        return shape2DComponent;
    }
}
