package com.nzt.gdx.test.tester.archi.screens.systems;

import java.util.HashMap;
import java.util.concurrent.Callable;

import com.badlogic.ashley.core.Engine;
import com.nzt.gdx.test.tester.archi.main.FastTesterMain;
import com.nzt.gdx.test.tester.archi.screens.SimpleTestScreen;

public abstract class BaseSystemScreen extends SimpleTestScreen {

	protected Engine engine;

	long loopCount = 0;

	HashMap<Long, Callable> functionToCalls = new HashMap<>();

	public void addFunctionToCall(long loopCount, Callable<Boolean> fct) {
		functionToCalls.put(loopCount, fct);
	}

	public BaseSystemScreen(FastTesterMain main) {
		super(main);
		this.engine = new Engine();
	}

	@Override
	protected void renderScreen(float dt) {
		loopCount++;
		Callable functionToCall = functionToCalls.get(loopCount);
		if (functionToCall != null) {
			try {
				functionToCall.call();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		engine.update(dt);
	}
}
