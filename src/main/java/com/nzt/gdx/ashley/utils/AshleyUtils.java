package com.nzt.gdx.ashley.utils;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.utils.ImmutableArray;
import com.nzt.gdx.logger.TagLoggerBlockUtils;
import com.nzt.gdx.logger.tag.LogTagsBase;
import com.nzt.gdx.logger.tag.TagLogger;

public class AshleyUtils {

    public static void debugEntity(Entity entity) {
        TagLoggerBlockUtils.startBlockDebug(LogTagsBase.DEBUG, "Entity");
        ImmutableArray<Component> components = entity.getComponents();
        for (Component component : components) {
            TagLogger.debug(LogTagsBase.DEBUG, component.getClass().getSimpleName(), component.toString());
        }
        TagLoggerBlockUtils.endBlockDebug(LogTagsBase.DEBUG, "Entity");
    }
}
