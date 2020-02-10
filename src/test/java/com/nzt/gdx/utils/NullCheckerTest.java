package com.nzt.gdx.utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Test class for {@link NullChecker}
 * @author fabiitch
 *
 */
public class NullCheckerTest {
	@Test
	public void isNullTest() {

		Object nullObject = null;
		Object notNullObject = new Object();

		assertTrue(NullChecker.isNull(nullObject));
		assertFalse(NullChecker.isNull(notNullObject));

		assertTrue(NullChecker.isNull(nullObject, nullObject));
		assertFalse(NullChecker.isNull(notNullObject, nullObject));
	}
	@Test
	public void isNotNullTest() {

		Object nullObject = null;
		Object notNullObject = new Object();

		assertFalse(NullChecker.isNotNull(nullObject));
		assertTrue(NullChecker.isNotNull(notNullObject));

		assertFalse(NullChecker.isNotNull(nullObject, nullObject));
		assertTrue(NullChecker.isNotNull(notNullObject, notNullObject));
	}
}
