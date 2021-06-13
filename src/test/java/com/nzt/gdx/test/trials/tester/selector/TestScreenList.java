package com.nzt.gdx.test.trials.tester.selector;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface TestScreenList {
    String SEPARATOR = "\\.";
    String group();

}
