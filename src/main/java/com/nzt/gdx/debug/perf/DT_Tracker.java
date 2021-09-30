package com.nzt.gdx.debug.perf;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.nzt.gdx.debug.hud.HudDebugPosition;
import com.nzt.gdx.debug.hud.core.HudDebug;
import com.nzt.gdx.debug.utils.DebugDisplayUtils;
import com.nzt.gdx.math.Percentage;

import java.util.concurrent.TimeUnit;

public class DT_Tracker {

    private static final String TOTAL_TIME = "Total Time";
    private static final String TOTAL_TIME_PERCENT = "Percent time ";
    private static final String MAX_FPS_POSSIBLE = "Max Fps";
    private static final String DT_SEPARATOR = "-----";

    private static final int FPS_DEFAULT = 100;

    public int[] fpsTargets;

    public DT_Tracker(int positionOnStage, Color color, int... fpsTargets) {
        this.fpsTargets = fpsTargets;
        HudDebug.addItem(TOTAL_TIME, 100000f, positionOnStage, color);
        for (int fpsTarget : fpsTargets) {
            HudDebug.addItem(TOTAL_TIME_PERCENT + " Target=" + fpsTarget, "100%", positionOnStage, color);
        }
        HudDebug.addItem(MAX_FPS_POSSIBLE, 500, positionOnStage, color);
        HudDebug.addItem(DT_SEPARATOR, DT_SEPARATOR, positionOnStage, color);
    }

    public DT_Tracker() {
        this(HudDebugPosition.TOP_LEFT, Color.WHITE, FPS_DEFAULT);
    }

    public DT_Tracker(int... fpsTargets) {
        this(HudDebugPosition.TOP_LEFT, Color.WHITE, fpsTargets);
    }

    private float internalTimer = 0;

    public void update() {
        internalTimer += Gdx.graphics.getDeltaTime();
        if (internalTimer < 1)
            return;
        internalTimer = 0;

        HudDebug.update(TOTAL_TIME, DebugDisplayUtils.printNanoToMs(PerformanceFrame.timeLastFrameNano));
        for (int fpsTarget : fpsTargets) {
            HudDebug.update(TOTAL_TIME_PERCENT,
                    Percentage.getPercent(PerformanceFrame.timeLastFrameNano, TimeUnit.SECONDS.toNanos(1) / fpsTarget) + " %");
        }
        long maxFps = TimeUnit.SECONDS.toNanos(1) / PerformanceFrame.timeLastFrameNano;
        HudDebug.update(MAX_FPS_POSSIBLE, maxFps);
    }

    public void remove() {
        for (int fpsTarget : fpsTargets) {
            HudDebug.remove(TOTAL_TIME_PERCENT + fpsTarget + "FPS");
        }
        HudDebug.remove(TOTAL_TIME_PERCENT);
        HudDebug.remove(MAX_FPS_POSSIBLE);
        HudDebug.remove(DT_SEPARATOR);
    }

}
