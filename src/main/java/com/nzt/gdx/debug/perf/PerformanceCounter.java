package com.nzt.gdx.debug.perf;

import com.nzt.gdx.math.Percentage;

class PerformanceCounter {

	public long startNanoTime;

	public float minTime;
	public float maxTime;
	public float average;

	public long execTime;

	public float percentFrameCurrent;
	public float percentFrameAverage;

	public void end() {
		long stopTime = System.nanoTime();
		execTime = stopTime - startNanoTime;

		minTime = Math.min(minTime, execTime);
		maxTime = Math.max(minTime, execTime);
		average = (average + execTime) / 2;
	}

	public void endFrame(long timeLastFrame, long timeAverageFrame) {

		System.out.println("timeLastFrame" + timeLastFrame);
		System.out.println("timeAverageFrame" + timeAverageFrame);
		percentFrameCurrent = Percentage.getPercent(execTime, timeLastFrame);
		percentFrameAverage = Percentage.getPercent(average, timeAverageFrame);
	}

	@Override
	public String toString() {
		return "execTime=" + execTime + " | average=" + average + "  / percentFrameAverage=" + percentFrameAverage;

	}
}
