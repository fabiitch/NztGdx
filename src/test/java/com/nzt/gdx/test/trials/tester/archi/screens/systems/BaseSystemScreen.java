package com.nzt.gdx.test.trials.tester.archi.screens.systems;

import java.util.concurrent.Callable;

import com.badlogic.ashley.core.Engine;
import com.nzt.gdx.test.trials.tester.archi.main.FastTesterMain;
import com.nzt.gdx.test.trials.tester.archi.screens.SimpleTestScreen;
import com.nzt.gdx.test.trials.tester.archi.systems.DelayActionSystem;

public abstract class BaseSystemScreen extends SimpleTestScreen {

	protected Engine engine;
	protected DelayActionSystem delayActionSystem;

	public void addFunctionToCall(long loopCount, Callable<Boolean> fct) {
		delayActionSystem.addFunctionToCall(loopCount, fct);
	}

	public BaseSystemScreen(FastTesterMain main) {
		super(main);
		this.engine = new Engine();

		this.delayActionSystem = new DelayActionSystem();
		engine.addSystem(delayActionSystem);
	}

	@Override
	protected void renderScreen(float dt) {
		engine.update(dt);
	}
}
