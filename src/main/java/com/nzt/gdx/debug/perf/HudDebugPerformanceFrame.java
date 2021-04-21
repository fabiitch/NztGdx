package com.nzt.gdx.debug.perf;

import java.util.concurrent.TimeUnit;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.Array;
import com.nzt.gdx.debug.hud.base.HudDebug;
import com.nzt.gdx.debug.utils.DebugDisplayUtils;
import com.nzt.gdx.math.Percentage;

public class HudDebugPerformanceFrame {

	private static final String TOTAL_TIME = "Total Time";
	private static final String TOTAL_TIME_PERCENT = "Total Time Percent";

	private int nbAction = 0;
	private int positionOnStage;
	private Color color;

	public HudDebugPerformanceFrame(int positionOnStage, Color color) {
		this.positionOnStage = positionOnStage;
		this.color = color;
		HudDebug.addItem(TOTAL_TIME, 1000f, positionOnStage, Color.RED);
		Array<PerformanceAction> actions = PerformanceFrame.getActions();

		for (PerformanceAction action : actions) {
			addActionToHudDebug(action);
		}
	}

	private void addActionToHudDebug(PerformanceAction action) {
		if (!HudDebug.exist(action.action))
			HudDebug.add(action.action, action.maxTime, positionOnStage, color);
		nbAction++;
	}

	private float internalTimer = 0;

	public void update(float dt) {
		if (!PerformanceFrame.enabled)
			return;

		Array<PerformanceAction> actions = PerformanceFrame.getActions();
		boolean checkAdd = actions.size != nbAction;

		internalTimer += dt;
		if (internalTimer > 0.5) {
			HudDebug.update(TOTAL_TIME, DebugDisplayUtils.printNanoToMs(PerformanceFrame.timeLastFrame));
			HudDebug.update(TOTAL_TIME_PERCENT,
					Percentage.getPercent(PerformanceFrame.timeFrameAverage, TimeUnit.SECONDS.toNanos(1) / 80f) + " %");

			for (PerformanceAction action : actions) {
				if (checkAdd)
					addActionToHudDebug(action);

				HudDebug.update(action.action, action.percentFrameAverage + " %");
			}

		}
	}
}
