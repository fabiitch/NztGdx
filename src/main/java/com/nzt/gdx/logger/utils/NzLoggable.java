package com.nzt.gdx.logger.utils;

import com.badlogic.gdx.utils.Pool;

/**
 * Interface for log events (tag and values)
 *
 * @author fabiitch
 */
public interface NzLoggable extends Pool.Poolable {

    String gdxLogTag();

    String gdxLogValue();

}
