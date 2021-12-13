package com.nzt.gdx.test.s_try;

import com.nzt.gdx.test.utils.archi.mains.StarterTestConfig;
import com.nzt.gdx.test.utils.screen_selector.screen.ScreenSelectorTestMain;

/**
 * Open Test chooser
 */
public class ScreenTryListStarter {
    private static final int witdh = 800;
    private static final int height = 500;

    public static void main(String[] args) {
        StarterTestConfig.startLwjgl3(new ScreenSelectorTestMain(ScreenTryListStarter.class,
                        "com.nzt.gdx.test.s_try.list"), witdh, height);
    }
}
