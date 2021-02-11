package com.nzt.gdx.ashley.components.physx;

import com.badlogic.ashley.core.ComponentMapper;
import com.nzt.gdx.ashley.components.abstracts.PoolableComponent;
import com.nzt.gdx.math.nzshape2d.NzShape2D;

public class NzShapeComponent extends PoolableComponent {
    public static ComponentMapper<NzShapeComponent> mapper = ComponentMapper.getFor(NzShapeComponent.class);
    public NzShape2D shape;

    @Override
    public void reset() {
        shape = null;
    }
}
