package com.nzt.gdx.test.trials.tester.selector;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface TestScreen {
	String DEFAULT_NAME = "DEFAULT_NAME";
	public String SEPARATOR = "\\.";

	String group()

	default DEFAULT_NAME;

}
