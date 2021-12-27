package com.nzt.gdx.ashley.components.renders.shape;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.nzt.gdx.ashley.components.physx.Shape2DComponent;
import com.nzt.gdx.graphics.renderers.NzShapeRenderer;

//juste pour le system
public class ShapeRenderableComponent extends Shape2DComponent {
    public static final ComponentMapper<ShapeRenderableComponent> mapper = ComponentMapper.getFor(ShapeRenderableComponent.class);

    public final Color color;

    public ShapeRenderableComponent(Shape2DComponent shape2DComponent, Color color) {
        super();
        this.color = color;
        this.shape = shape2DComponent.getShape();
        this.shapeTypeNumber = shape2DComponent.getShapeTypeNumber();
    }

    public void render(Vector3 position, NzShapeRenderer shapeRenderer) {
        shapeRenderer.setColor(color);
        if (shapeTypeNumber == Rectangle) {
            Rectangle rectangle = getRectangle();
            rectangle.setPosition(position.x, position.y);
            shapeRenderer.rect(rectangle);
        } else if (shapeTypeNumber == Circle) {
            Circle circle = getCircle();
            circle.setPosition(position.x, position.y);
            shapeRenderer.circle(circle);
        } else if (shapeTypeNumber == Polygon) {
           Polygon polygon = getPolygon();
            polygon.setPosition(position.x, position.y);
            shapeRenderer.polygon(getPolygon());
        }
    }

}
