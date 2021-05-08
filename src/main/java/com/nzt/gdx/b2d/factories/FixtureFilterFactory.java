package com.nzt.gdx.b2d.factories;

import com.badlogic.gdx.physics.box2d.Filter;
import com.badlogic.gdx.physics.box2d.FixtureDef;

public class FixtureFilterFactory {

    private FixtureFilterFactory() {

    }

    public static Filter get(FixtureDef fixtureDef, short categoryBits, short maskBits, short groupIndex) {
        Filter filter = fixtureDef.filter;
        filter.categoryBits = categoryBits;
        filter.maskBits = maskBits;
        filter.groupIndex = groupIndex;
        return filter;
    }

    public static Filter get(short categoryBits, short maskBits, short groupIndex) {
        Filter filter = new Filter();
        filter.categoryBits = categoryBits;
        filter.maskBits = maskBits;
        filter.groupIndex = groupIndex;
        return filter;
    }
}
