package com.nzt.gdx.utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Test class for {@link NZ}
 * @author fabiitch
 *
 */
public class NzTest {
	@Test
	public void isNullTest() {

		Object nullObject = null;
		Object notNullObject = new Object();

		assertTrue(NZ.isNull(nullObject));
		assertFalse(NZ.isNull(notNullObject));

		assertTrue(NZ.isNull(nullObject, nullObject));
		assertFalse(NZ.isNull(notNullObject, nullObject));
	}
	@Test
	public void isNotNullTest() {

		Object nullObject = null;
		Object notNullObject = new Object();

		assertFalse(NZ.isNotNull(nullObject));
		assertTrue(NZ.isNotNull(notNullObject));

		assertFalse(NZ.isNotNull(nullObject, nullObject));
		assertTrue(NZ.isNotNull(notNullObject, notNullObject));
	}
}
