package com.nzt.gdx.test.runnable;

import com.nzt.gdx.test.s_try.NztSTryListStarter;
import com.nzt.gdx.test.utils.archi.mains.StarterTestConfig;
import com.nzt.gdx.test.utils.screen_selector.screen.ScreenSelectorTestMain;

public class NztTestsStarter {
    private static final int witdh = 800;
    private static final int height = 500;

    public static void main(String[] args) {
        StarterTestConfig.startLwjgl3(new ScreenSelectorTestMain(NztSTryListStarter.class,
                "com.nzt.gdx.test.runnable.list"), witdh, height);
    }
}
