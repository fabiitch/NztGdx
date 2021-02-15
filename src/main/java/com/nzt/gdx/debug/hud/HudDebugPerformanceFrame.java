package com.nzt.gdx.debug.hud;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.Array;
import com.nzt.gdx.debug.hud.base.HudDebug;
import com.nzt.gdx.debug.perf.frame.PerformanceFrameUtils;
import com.nzt.gdx.debug.utils.DebugDisplayUtils;
import com.nzt.gdx.logger.utils.NzLoggable;
import com.nzt.gdx.math.Percentage;

import java.util.concurrent.TimeUnit;

public class HudDebugPerformanceFrame {

    private static final String TOTAL_TIME = "Total Time";
    private static final String TOTAL_TIME_PERCENT = "Total Time Percent";

    public HudDebugPerformanceFrame(Color color, int positionHud) {
        if (!PerformanceFrameUtils.log) {
            return;
        }
        HudDebug.addItem(positionHud, TOTAL_TIME, 1000f, Color.BLUE);
        HudDebug.addItem(positionHud, TOTAL_TIME_PERCENT, 1000f, Color.BLUE);
        Array<NzLoggable> loggableAveragePercent = PerformanceFrameUtils.getLoggableAveragePercent();
        if (loggableAveragePercent != null) {
            for (NzLoggable logbbale : loggableAveragePercent) {
                HudDebug.addItem(positionHud, logbbale.gdxLogTag(), logbbale.gdxLogValue(), color);
            }
        }
    }

    float internalTimer = 0;

    public void update(float dt) {
        if (!PerformanceFrameUtils.log) {
            return;
        }
        internalTimer += dt;
        if (internalTimer > 0.5) {
            HudDebug.update(TOTAL_TIME, DebugDisplayUtils.printNanoToMs(PerformanceFrameUtils.performanceFrame.timeFrameAverage));
            HudDebug.update(TOTAL_TIME_PERCENT, Percentage.getPercent(PerformanceFrameUtils.performanceFrame.timeFrameAverage, TimeUnit.SECONDS.toNanos(1) / 80f) + " %");

            Array<NzLoggable> loggableAveragePercent = PerformanceFrameUtils.getLoggableAveragePercent();
            loggableAveragePercent.setSize(10);
            if (loggableAveragePercent != null) {
                for (NzLoggable logbbale : loggableAveragePercent) {
                    if (logbbale != null)
                        HudDebug.update(logbbale.gdxLogTag(), logbbale.gdxLogValue());
                }
            }
            internalTimer = 0;
        }
    }
}
