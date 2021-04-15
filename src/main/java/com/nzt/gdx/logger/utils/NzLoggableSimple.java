package com.nzt.gdx.logger.utils;

import com.badlogic.gdx.utils.Pools;
import com.badlogic.gdx.utils.Pool.Poolable;

/**
 * Simple wrapper for {@link NzLoggable}
 *
 * @author fabiitch
 */
public class NzLoggableSimple implements NzLoggable {

    public String tag;
    public String value;

    public NzLoggableSimple() {

    }

    public NzLoggableSimple(String tag, String value) {
        this.tag = tag;
        this.value = value;
    }

    @Override
    public String gdxLogTag() {
        return tag;
    }

    @Override
    public String gdxLogValue() {
        return value;
    }

    @Override
    public void reset() {
        tag = null;
        value = null;
    }

    public static NzLoggableSimple getNew() {
        return Pools.get(NzLoggableSimple.class).obtain();
    }

    public static NzLoggableSimple getNew(String tag, String value) {
        NzLoggableSimple loggable = NzLoggableSimple.getNew();
        loggable.tag = tag;
        loggable.value = value;
        return loggable;
    }
}
