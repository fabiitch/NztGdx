package com.nzt.gdx.ashley.components.physx;

import com.badlogic.ashley.core.ComponentMapper;
import com.nzt.gdx.ashley.components.abstracts.PoolableComponent;
import com.nzt.gdx.math.nzshape2d.NzShape2D;

public class PhysxComponent extends PoolableComponent {
    public static ComponentMapper<PhysxComponent> mapper = ComponentMapper.getFor(PhysxComponent.class);

    public NzShape2D shape;
    public int nzShapeType;

    public boolean isStatic = false;

    @Override
    public void reset() {
        this.shape = null;
        this.isStatic = false;
        this.nzShapeType = 0;
    }
}
