package com.nzt.gdx.debug.perf;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.Array;
import com.nzt.gdx.debug.hud.core.HudDebug;
import com.nzt.gdx.debug.utils.DebugDisplayUtils;
import com.nzt.gdx.math.Percentage;

import java.util.concurrent.TimeUnit;

public class HudDebugPerformanceFrame {

	private static final String KEY = "PerfFrame-";
	private static final String TOTAL_TIME = "Total Time";
	private static final String TOTAL_TIME_PERCENT = "Total Time Percent";

	private int nbActions = 0;
	private final int positionOnStage;
	private final Color color;

	public HudDebugPerformanceFrame(int positionOnStage, Color color) {
		this.positionOnStage = positionOnStage;
		this.color = color;
		HudDebug.addItem(TOTAL_TIME, 1000f, positionOnStage, Color.RED);
		HudDebug.addItem(TOTAL_TIME_PERCENT, "100%", positionOnStage, Color.RED);
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
			HudDebug.update(TOTAL_TIME, DebugDisplayUtils.printNanoToMs(PerformanceFrame.timeLastFrame));
			HudDebug.update(TOTAL_TIME_PERCENT,
					Percentage.getPercent(PerformanceFrame.timeLastFrame, TimeUnit.SECONDS.toNanos(1) / 80f) + " %");
			
			for (int i = 0, n = actions.size; i < n; i++) {
				PerformanceAction performanceAction = actions.get(i);
				HudDebug.update(KEY + i, performanceAction.action,
						DebugDisplayUtils.printFloat(performanceAction.percentFrameAverage) + " %");
			}
			internalTimer = 0f;
		}
	}
}
