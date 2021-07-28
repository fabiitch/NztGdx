package com.nzt.gdx.test.trials;

import com.nzt.gdx.test.trials.tester.archi.main.StarterTestConfig;
import com.nzt.gdx.test.trials.tester.selector.screen.ScreenSelectorTestMain;

/**
 * Open Test chooser
 */
public class NztTestListStarter {
    private static final int witdh = 800;
    private static final int height = 500;

    public static void main(String[] args) {
        StarterTestConfig.startLwjgl3(new ScreenSelectorTestMain(NztTestListStarter.class,
                        "com.nzt.gdx.test"),
                witdh, height);
    }
}
