package com.nzt.gdx.test.trials.tester.archi.screens;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.graphics.Color;
import com.nzt.gdx.ashley.base.factories.BaseEntityFactory;
import com.nzt.gdx.debug.hud.HudDebugPosition;
import com.nzt.gdx.debug.hud.core.HudDebug;
import com.nzt.gdx.debug.perf.HudDebugPerformanceFrame;
import com.nzt.gdx.debug.perf.PerformanceFrame;
import com.nzt.gdx.test.trials.tester.archi.main.FastTesterMain;
import com.nzt.gdx.test.trials.tester.archi.systems.DelayFrameActionSystem;

import java.util.concurrent.Callable;


public abstract class BaseSystemTestScreen extends TestScreen {

    protected Engine engine;
    protected DelayFrameActionSystem delayActionSystem;
    protected BaseEntityFactory baseEntityFactory;
    protected HudDebugPerformanceFrame hudDebugPerformanceFrame;

    public BaseSystemTestScreen(FastTesterMain main) {
        super(main);
        this.engine = new Engine();
        baseEntityFactory = new BaseEntityFactory(engine);
        hudDebugPerformanceFrame = new HudDebugPerformanceFrame(HudDebugPosition.BOT_LEFT, Color.WHITE);

        PerformanceFrame.enabled = true;
        this.delayActionSystem = new DelayFrameActionSystem();
        engine.addSystem(delayActionSystem);
    }

    public void addFunctionToCall(long loopCount, Callable<Boolean> fct) {
        delayActionSystem.addFunctionToCall(loopCount, fct);
    }

    protected void activePerfFrame(boolean active) {
        PerformanceFrame.enabled = active;
        hudDebugPerformanceFrame.removeFromHudDebug();
    }

    @Override
    public void renderTestScreen(float dt) {
        engine.update(dt);
        hudDebugPerformanceFrame.update(dt);
    }
}
