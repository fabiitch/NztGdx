package com.nzt.gdx.ashley.components;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pools;
import com.nzt.gdx.ashley.base.components.PoolableComponent;
import com.nzt.gdx.transformer.BaseTransformer;


//TODO a reprendre complet
public class TransformersComponent extends PoolableComponent {

    public static final ComponentMapper<TransformersComponent> mapper = ComponentMapper.getFor(TransformersComponent.class);

    public TransformersComponent() {
        transformerArray = new Array<>();
    }

    public Array<BaseTransformer<?>> transformerArray;

    public void addTransformer(BaseTransformer<?> transformer) {
        transformerArray.add(transformer);
    }

    public void update(float dt) {
        for (BaseTransformer<?> transformer : transformerArray) {
            transformer.update(dt);
        }
    }

    @Override
    public void reset() {
        Pools.freeAll(transformerArray);
        transformerArray.clear();
    }

}
