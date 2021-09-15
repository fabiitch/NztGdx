package com.nzt.gdx.ashley.systems.logic;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.nzt.gdx.ashley.NztSystemsOrder;
import com.nzt.gdx.ashley.base.systems.NzIteratingSystem;
import com.nzt.gdx.ashley.components.TransformersComponent;

//TODO
// pas fini , modifier avec interpolation sur entity
public class TransformerSystem extends NzIteratingSystem {

    private final static ComponentMapper<TransformersComponent> transformMapper = TransformersComponent.mapper;

    public TransformerSystem() {
        this(NztSystemsOrder.CALCUL);
    }

    public TransformerSystem(int order) {
        super(Family.one(TransformersComponent.class).get(), order);
    }


    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        transformMapper.get(entity).update(deltaTime);
    }

}
