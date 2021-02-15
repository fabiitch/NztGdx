package com.nzt.gdx.ashley.components.physx;

import com.badlogic.ashley.core.ComponentMapper;
import com.nzt.gdx.ashley.components.abstracts.PoolableComponent;
import com.nzt.gdx.math.nzshape2d.NzShape2D;

public class PhysXComponent extends PoolableComponent {
    public static ComponentMapper<PhysXComponent> mapper = ComponentMapper.getFor(PhysXComponent.class);

    public NzShape2D nzShape;
    public short nzShapeType;

    public boolean isStatic = false;

    @Override
    public void reset() {
        this.nzShape = null;
        this.isStatic = false;
        this.nzShapeType = 0;
    }
}
