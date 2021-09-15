package com.nzt.gdx.test.api.fake;

public interface TestConditions {

    String name();

    /**
     * @return true if ok, false if ok, null if nothing
     */
    Boolean ok();
}
