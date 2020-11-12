package com.nzt.gdx.logger.tag;

import com.badlogic.gdx.utils.Array;

/**
 * All Base tag for {@link TagLogger} Don't need enum for taglogger, but easyly
 * to use enum create an enum in your game for tag
 *
 * @author fabiitch
 */
public enum LogTagsBase {
    INIT, NET, PERFORMANCE,
    SYSTEMS, INPUT,
    B2D_INFO, B2D_CONTACT, B2D_CREATION,
    SCREEN_ACTIONS,
    UNKNOW,
    DEBUG;

    // SCREEN_ACTIONS is all except render(show, resize, pause, resume, hide)

    public static void activeBasesTags() {
        for (LogTagsBase tag : LogTagsBase.values()) {
            TagLogger.activeTag(tag);
        }
    }

    public static void activeBasesTagsExcept(LogTagsBase... tags) {
        Array<LogTagsBase> array = new Array<LogTagsBase>(tags);
        for (LogTagsBase tag : LogTagsBase.values()) {
            if (tags != null && !array.contains(tag, true))
                TagLogger.activeTag(tag);
        }
    }

    public static void activeBaseTag(LogTagsBase... tags) {
        for (LogTagsBase tag : tags) {
            TagLogger.activeTag(tag);
        }
    }

    public static void desactiveBasesTags() {
        for (LogTagsBase tag : LogTagsBase.values()) {
            TagLogger.desactiveTag(tag);
        }
    }

    public static void desactiveBasesTagsExcept(LogTagsBase... tags) {
        Array<LogTagsBase> array = new Array<LogTagsBase>(tags);
        for (LogTagsBase tag : LogTagsBase.values()) {
            if (tags != null && !array.contains(tag, true))
                TagLogger.desactiveTag(tag);
        }
    }

    public static void desactiveBaseTag(LogTagsBase... tags) {
        for (LogTagsBase tag : tags) {
            TagLogger.desactiveTag(tag);
        }
    }
}
