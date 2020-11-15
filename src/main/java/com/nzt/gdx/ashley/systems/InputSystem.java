package com.nzt.gdx.ashley.systems;

import com.badlogic.ashley.core.EntitySystem;
import com.nzt.gdx.ashley.NztSystemsOrder;
import com.nzt.gdx.input.base.BaseInputMultiplexer;

//TODO a revoir
public class InputSystem extends EntitySystem {

    protected BaseInputMultiplexer inputMultiplexer;

    public InputSystem(BaseInputMultiplexer inputMultiplexer) {
        this(inputMultiplexer, NztSystemsOrder.INPUT);
    }

    public InputSystem(BaseInputMultiplexer inputMultiplexer, int priority) {
        super(priority);
        this.inputMultiplexer = inputMultiplexer;
    }

    @Override
    public void update(float dt) {
        super.update(dt);//TODO vraiement utile ?
        inputMultiplexer.update();
    }

}
