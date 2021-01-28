package com.nzt.gdx.debug.hud;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.Array;
import com.nzt.gdx.debug.hud.base.HudDebug;
import com.nzt.gdx.debug.perf.frame.PerformanceFrameUtils;
import com.nzt.gdx.logger.utils.NzLoggable;

public class HudDebugPerformanceFrame {

	private Color color;
	private int positionHud;
	private boolean init = false;

	public HudDebugPerformanceFrame(Color color, int positionHud) {
		this.color = color;
		this.positionHud = positionHud;
	}

	public void init() {
		init = false;
		Array<NzLoggable> loggableAveragePercent = PerformanceFrameUtils.getLoggableAveragePercent();
		if (loggableAveragePercent != null) {
			for (NzLoggable logbbale : loggableAveragePercent) {
				HudDebug.addItem(positionHud, logbbale.gdxLogTag(), logbbale.gdxLogValue(), color);
			}
		}
	}

	public void update(float dt) {
		if (!init)
			init();
		Array<NzLoggable> loggableAveragePercent = PerformanceFrameUtils.getLoggableAveragePercent();
		if (loggableAveragePercent != null) {
			for (NzLoggable logbbale : loggableAveragePercent) {
				HudDebug.update(logbbale.gdxLogTag(), logbbale.gdxLogValue());
			}
		}
	}
}
