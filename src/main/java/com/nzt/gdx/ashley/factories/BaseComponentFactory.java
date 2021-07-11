package com.nzt.gdx.ashley.factories;

import com.badlogic.ashley.core.Engine;

public abstract class BaseComponentFactory {

    protected Engine engine;

    public BaseComponentFactory(Engine engine) {
        this.engine = engine;
    }
}
