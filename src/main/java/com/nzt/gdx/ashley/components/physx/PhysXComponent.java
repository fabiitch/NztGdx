package com.nzt.gdx.ashley.components.physx;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.gdx.math.Shape2D;
import com.nzt.gdx.ashley.base.components.PoolableComponent;


//TODO remove
public class PhysXComponent extends PoolableComponent {
    public static ComponentMapper<PhysXComponent> mapper = ComponentMapper.getFor(PhysXComponent.class);

    public Shape2D shape;
    public short nzShapeType;

    public boolean isStatic = false;

    @Override
    public void reset() {
        this.shape = null;
        this.isStatic = false;
        this.nzShapeType = 0;
    }
}
