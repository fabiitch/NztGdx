package com.nzt.gdx.test.unit.counter;

import com.nzt.gdx.counter.IntCounter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IntCounterTest {

    @Test
    public void intCounterTest() {
        IntCounter intCounter = new IntCounter();
        intCounter.add(50);
        intCounter.add(100);
        intCounter.add(75);

        Assertions.assertEquals(3, intCounter.count);
        Assertions.assertEquals(225, intCounter.total);
        Assertions.assertEquals(75, intCounter.current);
        Assertions.assertEquals(50, intCounter.min);
        Assertions.assertEquals(100, intCounter.max);
        Assertions.assertEquals(75, intCounter.average);
    }
}
