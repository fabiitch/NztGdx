package com.nzt.gdx.test.tester;

import com.nzt.gdx.test.screens.t3d.viewer.ST3DModelViewer;
import com.nzt.gdx.test.tester.archi.main.FastTesterMain;
import com.nzt.gdx.test.tester.archi.main.StarterTestConfig;
import com.nzt.gdx.test.tester.archi.main.StarterType;
import com.nzt.gdx.test.tester.archi.utils.Lwjgl3TestConfiguration;

/*
Use it for Test one class with screentestClass
 */
public class FastNztTester {
    private static Class screentestClass = ST3DModelViewer.class;
    private static StarterType starterType = StarterType.Lwjgl;

    private static int witdh = 800;
    private static int height = 500;

    public static void main(String args[]) {
        if (starterType == StarterType.Lwjgl) {
            StarterTestConfig.startLwjgl(new FastTesterMain(screentestClass), witdh, height);
        } else if (starterType == StarterType.Lwjgl3) {
            try {
                Lwjgl3TestConfiguration.removeConfigLwjgl();
            } catch (Exception e) {
                e.printStackTrace();
            }
            StarterTestConfig.startLwjgl3(new FastTesterMain(screentestClass), witdh, height);
        }
    }


}
