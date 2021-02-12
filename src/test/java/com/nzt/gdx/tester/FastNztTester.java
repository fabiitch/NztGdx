package com.nzt.gdx.tester;

import com.nzt.gdx.screens.t3d.Basic3DTestScreen;
import com.nzt.gdx.tester.main.FastTesterMain;
import com.nzt.gdx.tester.main.StarterTestConfig;
import com.nzt.gdx.tester.main.StarterType;
import com.nzt.gdx.tester.utils.Lwjgl3TestConfiguration;

public class FastNztTester {
    private static Class screentestClass = Basic3DTestScreen.class;
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
