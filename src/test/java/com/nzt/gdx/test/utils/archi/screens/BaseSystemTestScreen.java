package com.nzt.gdx.test.utils.archi.screens;

import com.badlogic.ashley.core.Engine;
import com.nzt.gdx.ashley.base.factories.BaseEntityFactory;
import com.nzt.gdx.test.utils.archi.mains.mains.FastTesterMain;
import com.nzt.gdx.test.utils.archi.systems.DelayFrameActionSystem;

import java.util.concurrent.Callable;


public abstract class BaseSystemTestScreen extends ScreenTry {

    protected Engine engine;
    protected DelayFrameActionSystem delayActionSystem;
    protected BaseEntityFactory baseEntityFactory;

    public BaseSystemTestScreen(FastTesterMain main) {
        super(main);
        this.engine = new Engine();
        baseEntityFactory = new BaseEntityFactory(engine);

        this.delayActionSystem = new DelayFrameActionSystem();
        engine.addSystem(delayActionSystem);
    }

    public void addFunctionToCall(long loopCount, Callable<Boolean> fct) {
        delayActionSystem.addFunctionToCall(loopCount, fct);
    }

    @Override
    public void renderTestScreen(float dt) {
        engine.update(dt);
    }
}
