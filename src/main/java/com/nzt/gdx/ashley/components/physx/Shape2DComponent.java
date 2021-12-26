package com.nzt.gdx.ashley.components.physx;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.gdx.math.*;
import com.nzt.gdx.ashley.base.components.PoolableComponent;

public class Shape2DComponent extends PoolableComponent {
    public static final ComponentMapper<Shape2DComponent> mapper = ComponentMapper.getFor(Shape2DComponent.class);

    public static final int Rectangle = 1;
    public static final int Circle = 2;
    public static final int Polygon = 2;

    protected Shape2D shape;
    protected int shapeTypeNumber;

    public void setRectangle(Rectangle rectangle) {
        this.shape = rectangle;
        this.shapeTypeNumber = Rectangle;
    }
    public void setPolygon(Polygon polygon) {
        this.shape = polygon;
        this.shapeTypeNumber = Polygon;
    }
    public Polygon getPolygon() {
        if (this.shapeTypeNumber == Polygon)
            return (Polygon) shape;
        return null;
    }
    public Rectangle getRectangle() {
        if (this.shapeTypeNumber == Rectangle)
            return (Rectangle) shape;
        return null;
    }

    public void setCircle(Circle circle) {
        this.shape = circle;
        this.shapeTypeNumber = Circle;
    }

    public Circle getCircle() {
        if (this.shapeTypeNumber == Circle)
            return (Circle) shape;
        return null;
    }

    @Override
    public void reset() {
        this.shape = null;
        this.shapeTypeNumber = 0;
    }

    public void updatePosition(Vector2 position) {
        this.updatePosition(position.x, position.y);
    }

    public void updatePosition(float x, float y) {
        if (shapeTypeNumber == Rectangle) {
            Rectangle rect = (Rectangle) shape;
            rect.setPosition(x - rect.width / 2, y - rect.height / 2);
        } else if (shapeTypeNumber == Circle) {
            Circle circle = (Circle) shape;
            circle.setPosition(x, y);
        } else if (shapeTypeNumber == Polygon) {
            Polygon polygon = (Polygon) shape;
            polygon.setPosition(x, y);
        }
    }

    public Shape2D getShape() {
        return shape;
    }

    public int getShapeTypeNumber() {
        return shapeTypeNumber;
    }

}
