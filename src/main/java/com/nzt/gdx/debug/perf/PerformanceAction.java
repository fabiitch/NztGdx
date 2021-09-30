package com.nzt.gdx.debug.perf;

import com.nzt.gdx.math.Percentage;

/**
 * simple class for stock perf time
 * Time are in nano
 */
class PerformanceAction implements Comparable<PerformanceAction> {

    public String action;
    private long startNanoTime;
    private long currentExecTime;

    public long minTime;
    public long maxTime;
    public long averageTime;

    public float percentFrameCurrent;
    public float percentFrameAverage;

    public PerformanceAction(String action) {
        this.action = action;
    }

    public void start() {
        startNanoTime = System.nanoTime();
    }

    public void end() {
        long stopTime = System.nanoTime();
        currentExecTime += stopTime - startNanoTime;
    }

    public void endFrame(long frameTime) {
        minTime = Math.min(minTime, currentExecTime);
        maxTime = Math.max(maxTime, currentExecTime);
        averageTime = (averageTime + currentExecTime) / 2;

        percentFrameCurrent = Percentage.getPercent(currentExecTime, frameTime);

        if (percentFrameAverage == 0f) {
            percentFrameAverage = (percentFrameAverage + percentFrameCurrent) / 2;
        } else {
            percentFrameAverage = (percentFrameAverage + percentFrameCurrent) / 2;
        }

        currentExecTime = 0;
    }

    public String getPercentLastFrame() {
        return percentFrameCurrent + " %";
    }

    public String getPercentFrameAverage() {
        return percentFrameAverage + " %";
    }

    @Override
    public String toString() {
        return "execTime=" + currentExecTime + " | average=" + averageTime + "  / percentFrameAverage="
                + percentFrameAverage;

    }

    @Override
    public int compareTo(PerformanceAction o) {
        return Float.compare(averageTime, o.averageTime);
    }
}
