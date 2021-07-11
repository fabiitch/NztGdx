package com.nzt.gdx.ashley.factories;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.ashley.components.physx.PhysXComponent;

public class PhysxComponentFactory extends BaseComponentFactory {
    public PhysxComponentFactory(Engine engine) {
        super(engine);
    }
}
