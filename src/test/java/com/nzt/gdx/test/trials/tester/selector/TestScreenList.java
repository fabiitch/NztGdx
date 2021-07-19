package com.nzt.gdx.test.trials.tester.selector;

import com.nzt.gdx.test.trials.NztTestListStarter;

import java.lang.annotation.*;

/**
 * use this on TestScreen, the class will appears on {@link NztTestListStarter}
 * Group represent folder case, use . for specify path ex : group="input.camera"
 */
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Target(ElementType.TYPE)
public @interface TestScreenList {
    String SEPARATOR = "\\.";

    String group() default "";
}
