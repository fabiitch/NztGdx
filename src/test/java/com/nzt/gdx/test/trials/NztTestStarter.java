package com.nzt.gdx.test.trials;

import com.nzt.gdx.test.trials.st.math.shapes.circle.STCircleReflexionRay;
import com.nzt.gdx.test.trials.tester.archi.main.FastTesterMain;
import com.nzt.gdx.test.trials.tester.archi.main.StarterTestConfig;

/*
Use it for Test one class with screenTestClass
 */
public class NztTestStarter {
    private static final Class screenTestClass = STCircleReflexionRay.class;

    public static void startScreen(Class screenTestClass) {
        StarterTestConfig.startLwjgl3(new FastTesterMain(screenTestClass),
                TestContants.BASIC_WITDH, TestContants.BASIC_HEIGHT);
    }

    public static void startScreen(Class screenTestClass, int witdh, int height) {
        StarterTestConfig.startLwjgl3(new FastTesterMain(screenTestClass),
                witdh, height);
    }

    public static void main(String[] args) {
        StarterTestConfig.startLwjgl3(new FastTesterMain(screenTestClass),
                TestContants.BASIC_WITDH, TestContants.BASIC_HEIGHT);
    }
}
