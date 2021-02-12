package com.nzt.gdx.ashley.systems.physx;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.utils.Array;
import com.nzt.gdx.ashley.components.mvt.PositionComponent;
import com.nzt.gdx.ashley.components.mvt.Velocity2DComponent;
import com.nzt.gdx.ashley.components.physx.PhysxComponent;
import com.nzt.gdx.math.nzshape2d.NzShape2D;

public class PhysX {
    private static ComponentMapper<PositionComponent> posMapper = PositionComponent.mapper;
    private static ComponentMapper<PhysxComponent> shapeMapper = PhysxComponent.mapper;
    private static ComponentMapper<Velocity2DComponent> velocityMapper = Velocity2DComponent.mapper;
    public Array<Entity> staticBodies;
    public Array<Entity> dynamicBodies;

    public PhysX() {
        this.staticBodies = new Array<>();
        this.dynamicBodies = new Array<>();
    }


    public void update(float dt) {
        for (int i = 0, n = dynamicBodies.size; i < n; i++) {
            Entity entity = dynamicBodies.get(i);
            PositionComponent positionComponent = posMapper.get(entity);
            PhysxComponent physxComponent = shapeMapper.get(entity);
            Velocity2DComponent velocity2DComponent = velocityMapper.get(entity);
            positionComponent.position.add(velocity2DComponent.velocity.x * dt, velocity2DComponent.velocity.y * dt, positionComponent.position.x);
            physxComponent.shape.updatePosition(positionComponent.getPosition());
        }
    }


    public void collideStatic(NzShape2D nzShape2D){
    }
}
