package com.nzt.gdx.test.s_try;

import com.nzt.gdx.test.s_try.list.math.shapes.polygons.STryPolygonIntersector;
import com.nzt.gdx.test.utils.TestContants;
import com.nzt.gdx.test.utils.archi.mains.mains.SingleScreenTestMain;
import com.nzt.gdx.test.utils.archi.mains.StarterTestConfig;

/*
Use it for Test one class with screenTestClass
 */
public class NztSTryStarter {
    private static final Class screenTestClass = STryPolygonIntersector.class;

    public static void main(String[] args) {
        StarterTestConfig.startLwjgl3(new SingleScreenTestMain(screenTestClass),
                TestContants.BASIC_WITDH, TestContants.BASIC_HEIGHT);
    }
}
