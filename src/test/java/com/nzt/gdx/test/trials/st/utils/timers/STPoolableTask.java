package com.nzt.gdx.test.trials.st.utils.timers;

import com.nzt.gdx.test.trials.tester.archi.main.FastTesterMain;
import com.nzt.gdx.test.trials.tester.archi.screens.TestScreenWithHudDebug;
import com.nzt.gdx.test.trials.tester.selector.TestScreen;

@TestScreen(group = "utils.timers")
public class STPoolableTask extends TestScreenWithHudDebug {
    public STPoolableTask(FastTesterMain main) {
        super(main);
      setMsgNotImpl();


    }

    @Override
    public void renderAfterHud(float dt) {

    }
}
