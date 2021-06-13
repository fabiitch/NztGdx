package com.nzt.gdx.test.trials.st.utils.timers;

import com.badlogic.gdx.utils.Timer;
import com.nzt.gdx.debug.hud.HudDebugPosition;
import com.nzt.gdx.debug.hud.core.HudDebug;
import com.nzt.gdx.test.trials.tester.archi.main.FastTesterMain;
import com.nzt.gdx.test.trials.tester.archi.screens.TestScreen;
import com.nzt.gdx.test.trials.tester.selector.TestScreenList;

@TestScreenList(group = "utils.timers")
public class STSimpleTimer extends TestScreen {

    private int loopCount = 1;
    Timer.Task task1, task2, taskRepeat;

    public STSimpleTimer(FastTesterMain main) {
        super(main);
        task1 = new Timer.Task() {
            @Override
            public void run() {
                HudDebug.update("ST_Timer", "2 S");
            }
        };
        task2 = new Timer.Task() {
            @Override
            public void run() {
                HudDebug.update("ST_Timer", "5 S");
            }
        };
        taskRepeat = new Timer.Task() {
            @Override
            public void run() {
                loopCount++;
                HudDebug.update("LoopCount", loopCount);
            }
        };

        Timer.schedule(task1,2);
        Timer.schedule(task2,5);
        Timer.schedule(taskRepeat,1,1);

        HudDebug.addItem("Task1", "0 s", HudDebugPosition.BOT_LEFT);
        HudDebug.addItem("getExecuteTimeMillis1", task1.getExecuteTimeMillis(), HudDebugPosition.BOT_LEFT);
        HudDebug.addItem("task1.isScheduled()", task1.isScheduled(), HudDebugPosition.BOT_LEFT);

        HudDebug.addItem("Task2", "0 s", HudDebugPosition.RIGHT_MIDDLE);
        HudDebug.addItem("getExecuteTimeMillis2", task2.getExecuteTimeMillis(), HudDebugPosition.RIGHT_MIDDLE);
        HudDebug.addItem("task2.isScheduled()", task2.isScheduled(), HudDebugPosition.RIGHT_MIDDLE);

        HudDebug.addItem("LoopCount", loopCount, HudDebugPosition.TOP_LEFT);
        HudDebug.addItem("getExecuteTimeMillistaskRepeat", taskRepeat.getExecuteTimeMillis(), HudDebugPosition.TOP_LEFT);
        HudDebug.addItem("taskRepeat.isScheduled()", taskRepeat.isScheduled(), HudDebugPosition.TOP_LEFT);
    }

    @Override
    public String getExplication() {
        return "Test timer api";
    }

    @Override
    public void renderTestScreen(float dt) {
        HudDebug.update("getExecuteTimeMillis1", task1.getExecuteTimeMillis());
        HudDebug.update("task1.isScheduled()", task1.isScheduled());
        HudDebug.update("getExecuteTimeMillis2", task2.getExecuteTimeMillis());
        HudDebug.update("task2.isScheduled()", task2.isScheduled());

        HudDebug.update("getExecuteTimeMillistaskRepeat", taskRepeat.getExecuteTimeMillis());
        HudDebug.update("taskRepeat.isScheduled()", taskRepeat.isScheduled());
    }

    @Override
    public void disposeTestScreen() {

    }
}
