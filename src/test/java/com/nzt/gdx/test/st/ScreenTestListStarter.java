package com.nzt.gdx.test.st;

import com.nzt.gdx.test.s_try.ScreenTryListStarter;
import com.nzt.gdx.test.utils.archi.mains.StarterTestConfig;
import com.nzt.gdx.test.utils.screen_selector.screen.ScreenSelectorTestMain;

public class ScreenTestListStarter {
    private static final int witdh = 800;
    private static final int height = 500;

    public static void main(String[] args) {
        StarterTestConfig.startLwjgl3(new ScreenSelectorTestMain(ScreenTryListStarter.class,
                "com.nzt.gdx.test.st.list"), witdh, height);
    }
}
