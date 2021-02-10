package com.nzt.gdx.ashley.components.physx;

import com.badlogic.gdx.math.Shape2D;
import com.nzt.gdx.ashley.components.abstracts.PoolableComponent;

public class ShapeComponent extends PoolableComponent {

    public Shape2D shape;

    @Override
    public void reset() {
        shape = null;
    }
}
