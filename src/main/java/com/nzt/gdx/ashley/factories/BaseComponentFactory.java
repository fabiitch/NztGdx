package com.nzt.gdx.ashley.factories;

import com.badlogic.ashley.core.Engine;

abstract class BaseComponentFactory {

    protected Engine engine;

    public BaseComponentFactory(Engine engine) {
        this.engine = engine;
    }
}