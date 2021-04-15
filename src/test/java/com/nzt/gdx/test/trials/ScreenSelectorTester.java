package com.nzt.gdx.test.trials;

import com.nzt.gdx.test.trials.tester.archi.main.StarterTestConfig;
import com.nzt.gdx.test.trials.tester.selector.ScreenSelectorTestMain;

/**
 * Open Test chooser
 */
public class ScreenSelectorTester {
    private static int witdh = 800;
    private static int height = 500;


    public static void main(String args[]) {
        StarterTestConfig.startLwjgl(new ScreenSelectorTestMain(ScreenSelectorTester.class), witdh, height);
    }
}
