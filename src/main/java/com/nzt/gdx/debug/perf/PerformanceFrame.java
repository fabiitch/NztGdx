package com.nzt.gdx.debug.perf;

import java.util.HashMap;
import java.util.Map.Entry;

public class PerformanceFrame {

	public static PerformanceFrame instance;

	private HashMap<String, PerformanceCounter> map;
	private long timeLastFrame;
	private long timeFrameAverage;

	private long tmpStart;

	private PerformanceFrame() {
		this.map = new HashMap<>();
	}

	public static void init() {
		instance = new PerformanceFrame();
	}

	public void start(String action) {
		PerformanceCounter perfAction = map.get(action);
		if (perfAction == null) {
			perfAction = new PerformanceCounter();
			map.put(action, perfAction);
		}
		perfAction.startNanoTime = System.nanoTime();
	}

	public void end(String action) {
		PerformanceCounter perfAction = map.get(action);
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

	public static void printConsole() {
		if (instance != null) {
			for (Entry<String, PerformanceCounter> entry : instance.map.entrySet()) {
				System.out.println(entry.getKey() + "  " + entry.getValue().toString());
			}
		}
	}

}
