package com.nzt.gdx.test.trials;

import com.nzt.gdx.test.trials.st.ecs.STDebugDisplaySystemTest;
import com.nzt.gdx.test.trials.tester.archi.main.FastTesterMain;
import com.nzt.gdx.test.trials.tester.archi.main.StarterTestConfig;

/*
Use it for Test one class with screenTestClass
 */
public class NztTestStarter {
	private static final Class screenTestClass = STDebugDisplaySystemTest.class;

	private static final int witdh = 800;
	private static final int height = 500;

	public static void main(String[] args) {
		StarterTestConfig.startLwjgl3(new FastTesterMain(screenTestClass), witdh, height);
	}
}
