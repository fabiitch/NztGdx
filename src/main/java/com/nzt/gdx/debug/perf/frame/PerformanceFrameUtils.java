package com.nzt.gdx.debug.perf.frame;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pools;
import com.nzt.gdx.debug.DebugDisplayUtils;
import com.nzt.gdx.logger.tag.LogTagsBase;
import com.nzt.gdx.logger.tag.TagLogger;
import com.nzt.gdx.logger.utils.NzLoggable;
import com.nzt.gdx.logger.utils.NzLoggableSimple;

public class PerformanceFrameUtils {

	public static boolean log = false;
	public static PerformanceFrame performanceFrame;

	public static void init(PerformanceFrame performanceFrame) {
		PerformanceFrameUtils.log = true;
		PerformanceFrameUtils.performanceFrame = performanceFrame;
	}

	public static void registerAllSystems(Engine engine) {
		if (!log)
			return;
		ImmutableArray<EntitySystem> systems = engine.getSystems();
		for (EntitySystem system : systems) {
			PerformanceFrame.instance.register(system.getClass().getSimpleName());
		}
	}

	public static void startSystem(EntitySystem system) {
		if (log)
			performanceFrame.start(system.getClass().getSimpleName());
	}

	public static void endSystem(EntitySystem system) {
		if (log)
			performanceFrame.end(system.getClass().getSimpleName());
	}

	public static void logAveragePercent() {
		if (!log)
			return;
		Array<NzLoggable> loggableAveragePercent = getLoggableAveragePercent();
		TagLogger.errorBlock(LogTagsBase.PERFORMANCE, "average percent", loggableAveragePercent);
	}

	private static Array<NzLoggable> arrayLoggable = new Array<NzLoggable>();

	public static Array<NzLoggable> getLoggableAveragePercent() {
		if (!log)
			return null;
		Array<PerformanceCounter> arrayPerf = PerformanceFrame.getArray();

		Pools.freeAll(arrayLoggable);
		arrayLoggable.clear();
		for (PerformanceCounter perf : arrayPerf) {
			NzLoggableSimple loggable = NzLoggableSimple.getNew(perf.action,
					DebugDisplayUtils.printFloat(perf.percentFrameAverage) + "%");
			arrayLoggable.add(loggable);
		}
		return arrayLoggable;
	}
}
