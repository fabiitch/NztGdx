package com.nzt.gdx.test.javat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class JavaT_IncrementsTest {

    @Test
    public void reassigneRefTest() {
        int count = 1;
        int count2 = count++;

        Assertions.assertEquals(2, count);
        Assertions.assertEquals(1, count2);
    }

    @Test
    public void incrementAssign() {
        int a = 5;
        int b = 1;

        b = ++a;
        Assertions.assertEquals(6, b);
    }
}
