package com.nzt.gdx.test.trials.tester.selector;

import com.nzt.gdx.test.trials.NztTestListStarter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * use this on TestScreen, the class will appears on {@link NztTestListStarter}
 * Group represent folder case, use . for specify path ex : group="input.camera"
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface TestScreenList {
    String SEPARATOR = "\\.";
    String group() default "";
}
