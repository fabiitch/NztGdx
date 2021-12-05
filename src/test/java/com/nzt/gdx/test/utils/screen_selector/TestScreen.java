package com.nzt.gdx.test.utils.screen_selector;

import com.nzt.gdx.test.s_try.NztSTryListStarter;

import java.lang.annotation.*;

/**
 * ST = Screen test
 * use this on TestScreen, the class will appears on {@link NztSTryListStarter}
 * Group represent folder case, use . for specify path ex : group="input.camera"
 */
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Target(ElementType.TYPE)
public @interface TestScreen {
    String SEPARATOR = "\\.";

    String group() default "";

}
