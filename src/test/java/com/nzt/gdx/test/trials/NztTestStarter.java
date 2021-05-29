package com.nzt.gdx.test.trials;

import com.nzt.gdx.test.trials.st.b2D.collisions.STCollisionFilterWithMask;
import com.nzt.gdx.test.trials.st.ecs.STDebugDisplaySystem;
import com.nzt.gdx.test.trials.tester.archi.main.FastTesterMain;
import com.nzt.gdx.test.trials.tester.archi.main.StarterTestConfig;
import com.nzt.gdx.test.trials.tester.archi.main.StarterType;
import com.nzt.gdx.test.trials.tester.archi.utils.Lwjgl3TestConfiguration;

/*
Use it for Test one class with screenTestClass
 */
public class NztTestStarter {
	private static Class screenTestClass = STDebugDisplaySystem.class;
	private static StarterType starterType = StarterType.Lwjgl;

	private static int witdh = 800;
	private static int height = 500;

	public static void main(String args[]) {
		if (starterType == StarterType.Lwjgl) {
			StarterTestConfig.startLwjgl(new FastTesterMain(screenTestClass), witdh, height);
		} else if (starterType == StarterType.Lwjgl3) {
			try {
				Lwjgl3TestConfiguration.removeConfigLwjgl();
			} catch (Exception e) {
				e.printStackTrace();
			}
			StarterTestConfig.startLwjgl3(new FastTesterMain(screenTestClass), witdh, height);
		}
	}
}
