package com.nzt.gdx.ashley.components.renders.shape;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.gdx.graphics.Color;
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

    public void render(NzShapeRenderer shapeRenderer) {
        shapeRenderer.setColor(color);
        if (shapeTypeNumber == Rectangle) {
            shapeRenderer.rect(getRectangle());
        } else if (shapeTypeNumber == Circle) {
            shapeRenderer.circle(getCircle());
        } else if (shapeTypeNumber == Polygon) {
            shapeRenderer.polygon(getPolygon());
        }
    }

}
