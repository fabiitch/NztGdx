package com.nzt.gdx.ashley.systems.physx;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.nzt.gdx.ashley.NztSystemsOrder;
import com.nzt.gdx.ashley.components.physx.PhysXComponent;
import com.nzt.gdx.debug.perf.frame.PerformanceFrameUtils;
import com.nzt.gdx.graphics.renderers.NzShapeRenderer;

public class PhysXDebugSystem extends IteratingSystem {
    private static ComponentMapper<PhysXComponent> shapeMapper = PhysXComponent.mapper;
    private NzShapeRenderer nzShapeRenderer;
    private Camera camera;

    public PhysXDebugSystem(NzShapeRenderer nzShapeRenderer, Camera camera) {
        this(nzShapeRenderer, camera, NztSystemsOrder.PHYSX_DEBUG);
    }

    public PhysXDebugSystem(NzShapeRenderer nzShapeRenderer, Camera camera, int priority) {
        super(Family.one(PhysXComponent.class).get(), priority);
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
        PhysXComponent shapeComponent = shapeMapper.get(entity);
//        shapeComponent.shape.render(nzShapeRenderer);
    }
}
