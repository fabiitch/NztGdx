package com.nzt.gdx.ashley.systems.render;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Array;
import com.nzt.gdx.ashley.components.renders.ShapeRenderableArrayComponent;
import com.nzt.gdx.debug.perf.PerformanceFrame;

//TODO reprendre ou suppr
public class ShapeRenderSystem extends IteratingSystem {
    private final static ComponentMapper<ShapeRenderableArrayComponent> shapeArrayMapper = ShapeRenderableArrayComponent.mapper;

    private final ShapeRenderer shapeRenderer;
    private final Array<Entity> queue;

    public ShapeRenderSystem(ShapeRenderer shapeRenderer, int order) {
        super(Family.one(ShapeRenderableArrayComponent.class).get(), order);
        this.shapeRenderer = shapeRenderer;
        this.queue = new Array<Entity>();
        PerformanceFrame.addSystem(this);
    }

    @Override
    public void update(float deltaTime) {
        PerformanceFrame.startSystem(this);
        shapeRenderer.begin();
        super.update(deltaTime);
        shapeRenderer.end();
        PerformanceFrame.endSystem(this);
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        ShapeRenderableArrayComponent shapeComponent = shapeArrayMapper.get(entity);
        shapeComponent.render(shapeRenderer);
    }

    public void dispose() {
        this.queue.clear();
    }

}
