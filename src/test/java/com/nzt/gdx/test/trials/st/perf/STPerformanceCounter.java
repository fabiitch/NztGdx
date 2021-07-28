package com.nzt.gdx.test.trials.st.perf;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.PerformanceCounter;
import com.badlogic.gdx.utils.PerformanceCounters;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import com.nzt.gdx.debug.hud.core.HudDebug;
import com.nzt.gdx.test.trials.tester.archi.main.FastTesterMain;
import com.nzt.gdx.test.trials.tester.selector.TestScreenList;

/**
 * Test class PerformanceCounters
 */
@TestScreenList(group = "utils.perf")
public class STPerformanceCounter extends com.nzt.gdx.test.trials.tester.archi.screens.TestScreen {
	private final PerformanceCounters counters;
	PerformanceCounter counter1, counter2, counter3;

	private boolean startUpdateOther = false;

	public STPerformanceCounter(FastTesterMain main) {
		super(main);
		counters = new PerformanceCounters();
		counter1 = counters.add("Math.sqrt");
		counter2 = counters.add("Vector2Nor");
		counter3 = counters.add("Vector3Nor");

		HudDebug.addTopLeft("Math.sqrt", counter1.time);
		HudDebug.addTopLeft("Vector2Nor", counter2.time);
		HudDebug.addTopLeft("Vector3Nor", counter2.time);

		HudDebug.addBotLeft("Math.sqrtBotMax", counter1.time.max);
		HudDebug.addBotLeft("Vector2NorMax", counter2.time.max);
		HudDebug.addBotLeft("Vector3NorMax", counter2.time.max);
		counter1.start();
		counter2.start();
		counter3.start();
		glProfiler.removeHudDebug();

		Timer.schedule(new Task() {
			@Override
			public void run() {
				startUpdateOther = true;
				counter1.stop();
				counter2.stop();
				counter3.stop();
				counters.tick();
			}
		}, 2f);
	}

	@Override
	public String getTestExplication() {
		return "";
	}

	@Override
	public void renderTestScreen(float dt) {
		if (startUpdateOther) {
			counter1.start();
			for (int i = 0; i < 1000; i++) {
				Math.sqrt(i);
			}
			counter1.stop();

			counter2.start();
			for (int i = 0; i < 1000; i++) {
				new Vector2(100, 2220).nor();
			}
			counter2.stop();

			counter3.start();
			for (int i = 0; i < 1000; i++) {
				new Vector3(100, 2220, 1515).nor();
			}
			counter3.stop();
			counters.tick(dt);

			HudDebug.update("Math.sqrt", counter1.time);
			HudDebug.update("Vector2Nor", counter2.time);
			HudDebug.update("Vector3Nor", counter2.time);

			HudDebug.update("Math.sqrtBotMax", counter1.time.max);
			HudDebug.update("Vector2NorMax", counter2.time.max);
			HudDebug.update("Vector3NorMax", counter2.time.max);
		}
	}

	@Override
	public void disposeTestScreen() {

	}

}
