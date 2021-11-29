package com.nzt.gdx.debug;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.ObjectMap.Entry;
import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.Pools;
import com.nzt.gdx.debug.hud.core.HudDebug;
import com.nzt.gdx.logger.TagLoggerBlockUtils;
import com.nzt.gdx.logger.tag.LogTagsBase;
import com.nzt.gdx.logger.tag.TagLogger;
import com.nzt.gdx.utils.Strings;

import java.lang.reflect.Field;

public class PoolsDebug {

    private PoolsDebug() {

    }

    public static <T> void displayHudDebug(int position, Color color) {
        ObjectMap<Class<T>, Pool<T>> pools = getPools();

        for (Entry<Class<T>, Pool<T>> entry : pools.entries()) {
            Class<T> key = entry.key;
            Pool<T> pool = entry.value;
            boolean exist = HudDebug.exist("Pool " + key.getSimpleName());
            StringBuilder sb = Strings.getBuilder();
            sb.append("Max=").append(pool.max).append(" peak=").append(pool.peak);
            if (exist) {
                HudDebug.update("Pool " + key.getSimpleName(), sb.toString());
            } else {
                HudDebug.addItem("Pool " + key.getSimpleName(), sb.toString(), position, color);
            }
            sb.setLength(0);
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
        TagLoggerBlockUtils.startBlock(logLevel, LogTagsBase.MEMORY, "Pools Debug");
        for (Entry<Class<T>, Pool<T>> entry : typePools.entries()) {
            Class<T> key = entry.key;
            Pool<T> pool = entry.value;
            TagLogger.logWithLevel(logLevel, LogTagsBase.MEMORY, key.getSimpleName(),
                    "max=" + pool.max + ", peak=" + pool.peak);
        }
        TagLoggerBlockUtils.endBlock(logLevel, LogTagsBase.MEMORY, "Pools Debug");
    }
}
