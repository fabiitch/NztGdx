package com.nzt.gdx.logger.debug;

import java.lang.reflect.Field;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.ObjectMap.Entry;
import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.Pools;
import com.nzt.gdx.logger.LoggerUtils;

public class PoolsDebug {

	/**
	 * debug pools
	 */
	public static void debugPools() {
		ObjectMap<Class, Pool> typePools = null;
		try {
			Field poolsMap = Pools.class.getDeclaredField("typePools");
			poolsMap.setAccessible(true);
			typePools = (ObjectMap<Class, Pool>) poolsMap.get(null);
		} catch (Exception e) {
			Gdx.app.error("PoolsDebug", "error when get pools");
		}
		LoggerUtils.logSeparator("Pools Debug");
		for (Entry<Class, Pool> entry : typePools.entries()) {
			Class key = entry.key;
			Pool pool = entry.value;
			Gdx.app.log(key.getSimpleName(), "max=" + pool.max + ", peak=" + pool.peak);
		}
		LoggerUtils.logSeparator("Pools Debug");
	}
}
