package com.nzt.gdx.ashley.systems.render;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.nzt.gdx.ashley.components.mvt.PositionComponent;
import com.nzt.gdx.ashley.components.renders.shape.ShapeRenderableComponent;
import com.nzt.gdx.debug.perf.PerformanceFrame;
import com.nzt.gdx.graphics.renderers.NzShapeRenderer;

public class ShapeRenderSystem extends IteratingSystem {
    public static final ComponentMapper<PositionComponent> posMapper = PositionComponent.mapper;
    public static final ComponentMapper<ShapeRenderableComponent> mapperShape = ShapeRenderableComponent.mapper;

    private Camera camera;
    private final NzShapeRenderer shapeRenderer;

    public ShapeRenderSystem(NzShapeRenderer shapeRenderer, Camera camera, int order) {
        super(Family.all(ShapeRenderableComponent.class, PositionComponent.class).get(), order);

        this.camera = camera;
        this.shapeRenderer = shapeRenderer;
        PerformanceFrame.addSystem(this);
    }

    @Override
    public void update(float deltaTime) {
        PerformanceFrame.startSystem(this);
        shapeRenderer.setProjectionMatrix(camera.combined);
        shapeRenderer.begin();
        shapeRenderer.set(ShapeRenderer.ShapeType.Filled);
        super.update(deltaTime);
        shapeRenderer.end();
        PerformanceFrame.endSystem(this);
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        PositionComponent pos = posMapper.get(entity);
        ShapeRenderableComponent shapeComponent = mapperShape.get(entity);
        if (shapeComponent != null)
            shapeComponent.render(pos.position, shapeRenderer);
    }

}
