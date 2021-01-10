package com.nzt.gdx.ashley.systems;

import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.nzt.gdx.ashley.NztSystemsOrder;

public abstract class BaseHudSystem extends EntitySystem {

    public Stage stage;

    public BaseHudSystem(Stage stage) {
        this(stage, NztSystemsOrder.HUD);
    }

    public BaseHudSystem(Stage stage, int order) {
        super(order);
        this.stage = stage;
    }

    public abstract void doUpdate(float dt);

    @Override
    public void update(float dt) {
        super.update(dt);//TODO vraiement utile ?
        doUpdate(dt);
        stage.act(dt);
        stage.draw();
    }

    public void resize(int width, int height) {
        // See below for what true means.
        stage.getViewport().update(width, height);
    }
}
