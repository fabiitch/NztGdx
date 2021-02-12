package com.nzt.gdx.ashley.systems.physx;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.nzt.gdx.ashley.NztSystemsOrder;
import com.nzt.gdx.ashley.components.physx.PhysxComponent;
import com.nzt.gdx.debug.perf.frame.PerformanceFrameUtils;
import com.nzt.gdx.graphics.renderers.NzShapeRenderer;

public class PhysxDebugSystem extends IteratingSystem {
    private static ComponentMapper<PhysxComponent> shapeMapper = PhysxComponent.mapper;
    private NzShapeRenderer nzShapeRenderer;
    private Camera camera;

    public PhysxDebugSystem(NzShapeRenderer nzShapeRenderer, Camera camera) {
        this(nzShapeRenderer, camera, NztSystemsOrder.PHYSX_DEBUG);
    }

    public PhysxDebugSystem(NzShapeRenderer nzShapeRenderer, Camera camera, int priority) {
        super(Family.one(PhysxComponent.class).get(), priority);
        this.nzShapeRenderer = nzShapeRenderer;
        this.camera = camera;
    }

    @Override
    public void update(float deltaTime) {
        PerformanceFrameUtils.startSystem(this);
        nzShapeRenderer.setProjectionMatrix(camera.combined);
        nzShapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        nzShapeRenderer.setColor(Color.GREEN);
        super.update(deltaTime);
        nzShapeRenderer.end();
        PerformanceFrameUtils.endSystem(this);
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        PhysxComponent shapeComponent = shapeMapper.get(entity);
        shapeComponent.shape.render(nzShapeRenderer);
    }
}
