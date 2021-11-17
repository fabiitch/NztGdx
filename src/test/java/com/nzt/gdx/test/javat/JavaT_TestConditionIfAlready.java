package com.nzt.gdx.test.javat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


 class JavaT_TestConditionIfAlready {


    int count = 0;

    @BeforeEach
    public void resetCount() {
        count = 0;
    }

    private boolean isPair(int n) {
        count++;
        return n % 2 == 0;
    }

    @Test
    public void sameIfTest() {
        boolean b = isPair(12) && isPair(3) && isPair(6);
        Assertions.assertEquals(2, count);
    }

    @Test
    public void multiLineTestEqualAnd() {
        boolean b = isPair(12) && isPair(3);
        b &= isPair(6);
        Assertions.assertEquals(3, count);
    }

    @Test
    public void multiLineTestBAnd() {
        boolean b = isPair(12) && isPair(3);
        b = b && isPair(22);
        Assertions.assertEquals(2, count);
    }

}
