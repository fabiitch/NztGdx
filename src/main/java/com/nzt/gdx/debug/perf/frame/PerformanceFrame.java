package com.nzt.gdx.debug.perf.frame;

import java.util.HashMap;

import com.badlogic.gdx.utils.Array;

public class PerformanceFrame {

    private static PerformanceFrame instance;

    private HashMap<String, PerformanceCounter> map;
    private Array<PerformanceCounter> arrayOrdered;

    private long timeLastFrame;
    private long timeFrameAverage;

    private long tmpStart;

    private PerformanceFrame() {
        this.map = new HashMap<>();
        this.arrayOrdered = new Array<>();
    }

    public static void init() {
        instance = new PerformanceFrame();
        PerformanceFrameUtils.init(instance);
    }

    public Array<PerformanceCounter> getArray() {
        instance.arrayOrdered.sort();
        return instance.arrayOrdered;
    }

    public void register(String action) {
        PerformanceCounter perfAction = map.get(action);
        if (perfAction == null) {
            perfAction = new PerformanceCounter(action);
            map.put(action, perfAction);
            arrayOrdered.add(perfAction);
        }
    }

    public void start(String action) {
        PerformanceCounter perfAction = map.get(action);
        if (perfAction != null)
            perfAction.start();
    }

    public void end(String action) {
        PerformanceCounter perfAction = map.get(action);
        if (perfAction != null)
            perfAction.end();
    }

    public void startFrame() {
        tmpStart = System.nanoTime();
        timeLastFrame = 0;
    }

    public void endFrame() {
        long stopTime = System.nanoTime();
        timeLastFrame = stopTime - tmpStart;
        timeFrameAverage = (timeFrameAverage + timeLastFrame) / 2;

        for (PerformanceCounter performanceCounter : map.values()) {
            performanceCounter.endFrame(timeLastFrame, timeFrameAverage);
        }
    }
}
