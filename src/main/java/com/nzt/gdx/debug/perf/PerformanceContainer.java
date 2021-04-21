package com.nzt.gdx.debug.perf;

import java.util.HashMap;

import com.badlogic.gdx.utils.Array;

class PerformanceContainer {
	private HashMap<String, PerformanceAction> map;
	private Array<PerformanceAction> arrayOrdered;

	public Array<PerformanceAction> getActions() {
		arrayOrdered.sort();
		return arrayOrdered;
	}

	public PerformanceContainer() {
		this.map = new HashMap<>();
		this.arrayOrdered = new Array<>();
	}

	public void add(String action) {
		PerformanceAction perfAction = map.get(action);
		if (perfAction == null) {
			perfAction = new PerformanceAction(action);
			map.put(action, perfAction);
			arrayOrdered.add(perfAction);
		}
	}

	public void remove(String action) {
		PerformanceAction perfAction = map.get(action);
		if (perfAction != null) {
			map.remove(action);
			arrayOrdered.removeValue(perfAction, true);
			perfAction = null;
		}
	}

	public void startAction(String action) {
		map.get(action).start();
	}

	public void endAction(String action) {
		map.get(action).end();
	}

	public void endFrame(long frameTime) {
		for (PerformanceAction count : map.values()) {
			count.endFrame(frameTime);
		}
	}

	public void reset() {
		map.clear();
		arrayOrdered.clear();
	}
}
