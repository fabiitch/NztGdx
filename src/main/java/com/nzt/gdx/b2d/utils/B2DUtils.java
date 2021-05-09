package com.nzt.gdx.b2d.utils;

import com.badlogic.gdx.physics.box2d.Filter;

public class B2DUtils {
    public static String toString(Filter filter) {
        return "categoryBits=" + filter.categoryBits + ", maskBits=" + filter.maskBits + ", groupIndex=" + filter.groupIndex;
    }

}
