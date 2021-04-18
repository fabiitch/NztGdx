package com.nzt.gdx.debug;

import java.lang.reflect.Field;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.ObjectMap.Entry;
import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.Pools;
import com.nzt.gdx.debug.hud.base.HudDebug;
import com.nzt.gdx.logger.LoggerTagBlockUtils;
import com.nzt.gdx.logger.tag.LogTagsBase;
import com.nzt.gdx.logger.tag.TagLogger;

public class PoolsDebug {

	private PoolsDebug() {

	}

    /**
     * Display in HudDebug
     * @param position
     */
	public static <T> void displayHud(int position) {
        ObjectMap<Class<T>, Pool<T>> pools = getPools();
        for (Entry<Class<T>, Pool<T>> entry : pools.entries()) {
            Class<T> key = entry.key;
            Pool<T> pool = entry.value;
            boolean exist = HudDebug.exist(key.getSimpleName());
            StringBuffer sb = new StringBuffer();
            sb.append("Max=" + pool.max + " peak=" + pool.peak);
            if (exist) {
                HudDebug.update(key.getSimpleName(), sb.toString());
            }else{
                HudDebug.addItem(position, key.getSimpleName(), sb.toString());
            }
        }

    }
	/**
	 * debug pools
     */
    public static <T> ObjectMap<Class<T>, Pool<T>> getPools() {
        ObjectMap<Class<T>, Pool<T>> typePools = null;
        try {
            Field poolsMap = Pools.class.getDeclaredField("typePools");
            poolsMap.setAccessible(true);
            typePools = (ObjectMap<Class<T>, Pool<T>>) poolsMap.get(null);
        } catch (Exception e) {
            Gdx.app.error("PoolsDebug", "error when get pools");
        }
        return typePools;
    }

	/**
	 * debug pools
	 */
	public static <T> void debugPools(int logLevel) {
		ObjectMap<Class<T>, Pool<T>> typePools = getPools();
		LoggerTagBlockUtils.startBlock(logLevel, LogTagsBase.MEMORY, "Pools Debug");
		for (Entry<Class<T>, Pool<T>> entry : typePools.entries()) {
			Class<T> key = entry.key;
			Pool<T> pool = entry.value;
			TagLogger.logWithLevel(logLevel, LogTagsBase.MEMORY, key.getSimpleName(),
					"max=" + pool.max + ", peak=" + pool.peak);
		}
		LoggerTagBlockUtils.endBlock(logLevel, LogTagsBase.MEMORY, "Pools Debug");
	}
}
