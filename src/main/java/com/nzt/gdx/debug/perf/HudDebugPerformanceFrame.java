package com.nzt.gdx.debug.perf;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.Array;
import com.nzt.gdx.debug.hud.HudDebugPosition;
import com.nzt.gdx.debug.hud.core.HudDebug;
import com.nzt.gdx.debug.utils.DebugDisplayUtils;
import com.nzt.gdx.math.Percentage;

import java.util.concurrent.TimeUnit;

public class HudDebugPerformanceFrame {

    private static final String KEY = "PerfFrame-";

    public DT_Tracker dt_tracker;
    private int nbActions = 0;
    private final int positionOnStage;
    private final Color color;

    public HudDebugPerformanceFrame(int positionOnStage, Color color) {
        this(positionOnStage, color, true);
    }

    public HudDebugPerformanceFrame(int positionOnStage, Color color, boolean dt_Tracker) {
        this.positionOnStage = positionOnStage;
        this.color = color;
        if (dt_Tracker)
            dt_tracker = new DT_Tracker(positionOnStage, color);
    }

    public HudDebugPerformanceFrame() {
        this(HudDebugPosition.BOT_LEFT, Color.WHITE);
    }

    public void removeFromHudDebug() {
        HudDebug.removeGroup(KEY);
    }

    private void addRemoveActionOnHudDebug(int newNbActions) {
        if (newNbActions > nbActions) {
            for (int i = nbActions; i < newNbActions; i++)
                HudDebug.add(KEY + i, "5000", 5000, positionOnStage, color);
        } else if (newNbActions < nbActions) {
            for (int i = nbActions; i > newNbActions; i--)
                HudDebug.remove(KEY + i);
        }
        this.nbActions = newNbActions;
    }

    private float internalTimer = 0;

    public void update(float dt) {
        if (!PerformanceFrame.enabled)
            return;
        Array<PerformanceAction> actions = PerformanceFrame.getActions();
        addRemoveActionOnHudDebug(actions.size);
        internalTimer += dt;

        if (internalTimer > 0.5) {
            for (int i = 0, n = actions.size; i < n; i++) {
                PerformanceAction performanceAction = actions.get(i);
                HudDebug.update(KEY + i, performanceAction.action,
                        DebugDisplayUtils.printFloat(performanceAction.percentFrameAverage) + " %");
            }
            internalTimer = 0f;
        }
    }
}
