package com.nzt.gdx.test.tester.selector;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface TestScreen {
    final String DEFAULT_NAME = "DEFAULT_NAME";

    String name() default DEFAULT_NAME;

    String[] groupName();
}
