package com.nzt.gdx.debug.hud;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.Array;
import com.nzt.gdx.debug.hud.base.HudDebug;
import com.nzt.gdx.debug.perf.frame.PerformanceFrameUtils;
import com.nzt.gdx.logger.utils.NzLoggable;

public class HudDebugPerformanceFrame {

	public HudDebugPerformanceFrame(Color color, int positionHud) {
		if (!PerformanceFrameUtils.log) {
			return;
		}
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
			Array<NzLoggable> loggableAveragePercent = PerformanceFrameUtils.getLoggableAveragePercent();
			loggableAveragePercent.setSize(10);
			if (loggableAveragePercent != null) {
				for (NzLoggable logbbale : loggableAveragePercent) {
					HudDebug.update(logbbale.gdxLogTag(), logbbale.gdxLogValue());
				}
			}
			internalTimer = 0;
		}
	}
}
