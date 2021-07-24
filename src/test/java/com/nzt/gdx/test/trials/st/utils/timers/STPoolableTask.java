package com.nzt.gdx.test.trials.st.utils.timers;

import com.nzt.gdx.test.trials.tester.archi.main.FastTesterMain;
import com.nzt.gdx.test.trials.tester.archi.screens.TestScreen;
import com.nzt.gdx.test.trials.tester.selector.TestScreenList;

@TestScreenList(group = "utils.timers")
public class STPoolableTask extends TestScreen {
    public STPoolableTask(FastTesterMain main) {
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
