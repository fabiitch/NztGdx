package com.nzt.gdx.test.trials;

import com.nzt.gdx.test.trials.st.math.shapes.polygons.STPolygonIntersector;
import com.nzt.gdx.test.trials.tester.archi.mains.SingleScreenTestMain;
import com.nzt.gdx.test.trials.tester.archi.mains.StarterTestConfig;

/*
Use it for Test one class with screenTestClass
 */
public class NztTestStarter {
    private static final Class screenTestClass = STPolygonIntersector.class;

    public static void startScreen(Class screenTestClass) {
        StarterTestConfig.startLwjgl3(new SingleScreenTestMain(screenTestClass),
                TestContants.BASIC_WITDH, TestContants.BASIC_HEIGHT);
    }

    public static void startScreen(Class screenTestClass, int witdh, int height) {
        StarterTestConfig.startLwjgl3(new SingleScreenTestMain(screenTestClass),
                witdh, height);
    }

    public static void main(String[] args) {
        StarterTestConfig.startLwjgl3(new SingleScreenTestMain(screenTestClass),
                TestContants.BASIC_WITDH, TestContants.BASIC_HEIGHT);
    }
}
