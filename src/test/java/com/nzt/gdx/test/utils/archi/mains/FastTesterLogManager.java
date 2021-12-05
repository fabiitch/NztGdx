package com.nzt.gdx.test.utils.archi.mains;

import com.nzt.gdx.logger.tag.TagLogger;
import com.nzt.gdx.screen.manager.impl.FastDevLogManager;

public class FastTesterLogManager extends FastDevLogManager {
    public static FastTesterLogManager instance = new FastTesterLogManager();

    public FastTesterLogManager() {
    }

    @Override
    public void configureTags() {
        TagLogger.DONT_LOG = true;
    }
}
