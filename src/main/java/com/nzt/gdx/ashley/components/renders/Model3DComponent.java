package com.nzt.gdx.ashley.components.renders;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.nzt.gdx.ashley.base.components.PoolableComponent;

public class Model3DComponent extends PoolableComponent {

    public static ComponentMapper<Model3DComponent> mapper = ComponentMapper.getFor(Model3DComponent.class);

    public ModelInstance modelInstance;
    public Environment environment;
    public boolean visible = true;

    public Model3DComponent() {
        super();
    }

    @Override
    public void reset() {
        this.modelInstance = null;
        this.environment = null;
        this.visible = true;
    }
}
