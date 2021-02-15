package com.nzt.gdx.debug.perf.frame;

import com.nzt.gdx.math.Percentage;

/*
 * simple class for stock perf time
 */
class PerformanceCounter implements Comparable<PerformanceCounter> {

	public String action;
	private long startNanoTime;
	private long currentExecTime;

	public long minTime;
	public long maxTime;
	public long averageTime;

	public float percentFrameCurrent;
	public float percentFrameAverage;

	public PerformanceCounter(String action) {
		this.action = action;
	}

	public void start() {
		startNanoTime = System.nanoTime();
	}

	public void end() {
		long stopTime = System.nanoTime();
		currentExecTime += stopTime - startNanoTime;
	}

	public void endFrame(long timeLastFrame, long timeAverageFrame) {
		minTime = Math.min(minTime, currentExecTime);
		maxTime = Math.max(maxTime, currentExecTime);
		averageTime = (averageTime + currentExecTime) / 2;

		percentFrameCurrent = Percentage.getPercent(currentExecTime, timeLastFrame);
		percentFrameAverage = (percentFrameAverage + percentFrameCurrent) / 2;
		currentExecTime = 0;
	}

	@Override
	public String toString() {
		return "execTime=" + currentExecTime + " | average=" + averageTime + "  / percentFrameAverage="
				+ percentFrameAverage;

	}

	@Override
	public int compareTo(PerformanceCounter o) {
		return Float.compare(averageTime, o.averageTime);
	}
}
