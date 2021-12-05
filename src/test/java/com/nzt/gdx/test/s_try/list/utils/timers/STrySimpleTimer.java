package com.nzt.gdx.test.s_try.list.utils.timers;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.Timer;
import com.nzt.gdx.debug.hud.HudDebugPosition;
import com.nzt.gdx.debug.hud.core.HudDebug;
import com.nzt.gdx.test.utils.archi.mains.mains.FastTesterMain;
import com.nzt.gdx.test.utils.archi.screens.ScreenTry;
import com.nzt.gdx.test.utils.screen_selector.TestScreen;

@TestScreen(group = "utils.timers")
public class STrySimpleTimer extends ScreenTry {

    private int loopCount = 1;
    Timer.Task task1, task2, taskRepeat;

    public STrySimpleTimer(FastTesterMain main) {
        super(main);
        task1 = new Timer.Task() {
            @Override
            public void run() {
                HudDebug.addBotLeft("task1", "Done", Color.RED);
            }
        };
        task2 = new Timer.Task() {
            @Override
            public void run() {
                HudDebug.addMiddleRight("task2", "Done", Color.RED);
            }
        };
        taskRepeat = new Timer.Task() {
            @Override
            public void run() {
                loopCount++;
                HudDebug.update("LoopCount", loopCount);
            }
        };

        Timer.schedule(task1, 2);
        Timer.schedule(task2, 5);
        Timer.schedule(taskRepeat, 1, 1);

        HudDebug.add("Task1", "0 s", HudDebugPosition.BOT_LEFT);
        HudDebug.add("getExecuteTimeMillis1", task1.getExecuteTimeMillis(), HudDebugPosition.BOT_LEFT);
        HudDebug.add("task1.isScheduled()", task1.isScheduled(), HudDebugPosition.BOT_LEFT);

        HudDebug.add("Task2", "0 s", HudDebugPosition.RIGHT_MIDDLE);
        HudDebug.add("getExecuteTimeMillis2", task2.getExecuteTimeMillis(), HudDebugPosition.RIGHT_MIDDLE);
        HudDebug.add("task2.isScheduled()", task2.isScheduled(), HudDebugPosition.RIGHT_MIDDLE);

        HudDebug.add("LoopCount", loopCount, HudDebugPosition.TOP_LEFT);
        HudDebug.add("getExecuteTimeMillistaskRepeat", taskRepeat.getExecuteTimeMillis(), HudDebugPosition.TOP_LEFT);
        HudDebug.add("taskRepeat.isScheduled()", taskRepeat.isScheduled(), HudDebugPosition.TOP_LEFT);
    }

    @Override
    public String getTestExplication() {
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
