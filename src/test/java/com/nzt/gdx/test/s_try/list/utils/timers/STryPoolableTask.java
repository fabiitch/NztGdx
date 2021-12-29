package com.nzt.gdx.test.s_try.list.utils.timers;

import com.nzt.gdx.test.utils.archi.mains.dev.FastTesterMain;
import com.nzt.gdx.test.utils.archi.screens.ScreenTry;
import com.nzt.gdx.test.utils.screen_selector.TestScreen;

@TestScreen(group = "utils.timers")
public class STryPoolableTask extends ScreenTry {
    public STryPoolableTask(FastTesterMain main) {
        super(main);
        setMsgNotImpl();
    }

    @Override
    public String getTestExplication() {
        return null;
    }

    @Override
    public void renderTestScreen(float dt) {

    }

    @Override
    public void disposeTestScreen() {

    }
}
