package com.nzt.gdx.test.api.utils;

import com.nzt.gdx.debug.utils.DebugDisplayUtils;
import com.nzt.gdx.utils.NullChecker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * Test class for {@link NullChecker}
 *
 * @author fabiitch
 */
public class NullCheckerTest {
    @Test
    public void isNullTest() {

        System.out.println(DebugDisplayUtils.printValue(2.53213213123f));
        System.out.println(DebugDisplayUtils.printValue(222));
        System.out.println(DebugDisplayUtils.printValue(44l));
        System.out.println(DebugDisplayUtils.printValue("ttt"));

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
