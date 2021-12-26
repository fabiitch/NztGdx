package com.nzt.gdx.ashley.systems.render;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Array;
import com.nzt.gdx.ashley.components.physx.Shape2DComponent;
import com.nzt.gdx.ashley.components.renders.shape.ShapeRenderableArrayComponent;
import com.nzt.gdx.ashley.components.renders.shape.ShapeRenderableComponent;
import com.nzt.gdx.debug.perf.PerformanceFrame;
import com.nzt.gdx.graphics.renderers.NzShapeRenderer;

//TODO reprendre ou suppr
public class ShapeRenderSystem extends IteratingSystem {
    private final static ComponentMapper<ShapeRenderableArrayComponent> mapperShapeArray = ShapeRenderableArrayComponent.mapper;
    public static final ComponentMapper<ShapeRenderableComponent> mapperShape = ComponentMapper.getFor(ShapeRenderableComponent.class);

    private Camera camera;
    private final NzShapeRenderer shapeRenderer;

    public ShapeRenderSystem(NzShapeRenderer shapeRenderer, Camera camera, int order) {
        super(Family.one(ShapeRenderableArrayComponent.class, ShapeRenderableComponent.class).get(), order);
        this.camera = camera;
        this.shapeRenderer = shapeRenderer;
        PerformanceFrame.addSystem(this);
    }

    @Override
    public void update(float deltaTime) {
        PerformanceFrame.startSystem(this);
        shapeRenderer.setProjectionMatrix(camera.combined);
        shapeRenderer.begin();
        super.update(deltaTime);
        shapeRenderer.end();
        PerformanceFrame.endSystem(this);
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        ShapeRenderableArrayComponent shapeArrayComponent = mapperShapeArray.get(entity);
        if (shapeArrayComponent != null) {
            shapeArrayComponent.render(shapeRenderer);
        }

        ShapeRenderableComponent shapeComponent = mapperShape.get(entity);
        if (shapeComponent != null)
            shapeComponent.render(shapeRenderer);
    }

}
