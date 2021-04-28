package com.nzt.gdx.logger.utils;

/**
 * Utils class for get {@link NzLoggable} Not thread safe, return same instance
 * of NzLoggable
 *
 * @author fabiitch
 */
public class NzLoggableUtils {

    private static NzLoggableSimple temp = new NzLoggableSimple();

    public static NzLoggable create(final String tag, final String value) {
        temp.tag = tag;
        temp.value = value;
        return temp;
    }

    public static NzLoggable create(Object object) {
        temp.tag = object.getClass().getSimpleName();
        temp.value = object.toString();
        return temp;
    }

    public static NzLoggable creates(Object... objects) {
        return create(objects);
    }

    public static NzLoggable create(Object[] objects) {
        temp.tag = "";
        temp.value = "";
        for (int i = 0, n = objects.length; i < n; i++) {
            temp.tag += objects[i].getClass().getSimpleName();
            temp.value += objects[i].toString();
            if (i < n - 1) {
                temp.tag += ",";
                temp.value += ",";
            }
        }

        return temp;
    }
}
