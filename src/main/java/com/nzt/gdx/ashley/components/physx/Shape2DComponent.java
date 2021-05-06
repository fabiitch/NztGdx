package com.nzt.gdx.ashley.components.physx;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Shape2D;
import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.ashley.base.components.PoolableComponent;

public class Shape2DComponent extends PoolableComponent {
    public static ComponentMapper<Shape2DComponent> mapper = ComponentMapper.getFor(Shape2DComponent.class);
    public static final int RECTANGLE = 1;
    public static final int CIRCLE = 2;

    private Shape2D shape;
    private int shapeTypeNumber;

    public void setRectangle(Rectangle rectangle) {
        this.shape = rectangle;
        this.shapeTypeNumber = RECTANGLE;
    }

    public Rectangle getRectangle() {
        if (this.shapeTypeNumber == RECTANGLE)
            return (Rectangle) shape;
        return null;
    }

    public void setCircle(Circle circle) {
        this.shape = circle;
        this.shapeTypeNumber = CIRCLE;
    }

    public Circle getCircle() {
        if (this.shapeTypeNumber == CIRCLE)
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
        if (shapeTypeNumber == RECTANGLE) {
            Rectangle rect = (Rectangle) shape;
            rect.setPosition(x - rect.width / 2, y - rect.height / 2);
        } else if (shapeTypeNumber == CIRCLE) {
            Circle circle = (Circle) shape;
            circle.setPosition(x, y);
        }
    }

    public static void updateShapePositionFromBody(Entity entity){

    }

    public Shape2D getShape() {
        return shape;
    }

    public int getShapeTypeNumber() {
        return shapeTypeNumber;
    }

}
