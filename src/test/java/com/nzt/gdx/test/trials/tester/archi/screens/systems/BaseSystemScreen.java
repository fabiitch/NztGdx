package com.nzt.gdx.test.trials.tester.archi.screens.systems;

import java.util.concurrent.Callable;

import com.badlogic.ashley.core.Engine;
import com.nzt.gdx.test.trials.tester.archi.main.FastTesterMain;
import com.nzt.gdx.test.trials.tester.archi.screens.SimpleTestScreen;
import com.nzt.gdx.test.trials.tester.archi.systems.DelayFrameActionSystem;

public abstract class BaseSystemScreen extends SimpleTestScreen {

	protected Engine engine;
	protected DelayFrameActionSystem delayActionSystem;

	public void addFunctionToCall(long loopCount, Callable<Boolean> fct) {
		delayActionSystem.addFunctionToCall(loopCount, fct);
	}

	public BaseSystemScreen(FastTesterMain main) {
		super(main);
		this.engine = new Engine();

		this.delayActionSystem = new DelayFrameActionSystem();
		engine.addSystem(delayActionSystem);
	}

	@Override
	protected void renderScreen(float dt) {
		engine.update(dt);
	}
}
