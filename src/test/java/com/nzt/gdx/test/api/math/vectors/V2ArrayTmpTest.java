package com.nzt.gdx.test.api.math.vectors;

import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.math.vectors.V2TmpArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class V2ArrayTmpTest {
    V2TmpArray array;

    @Test
    public void testCreate() {
        array = new V2TmpArray(10);
        Assertions.assertEquals(0, array.getSize());
        Assertions.assertEquals(10, array.getMaxSize());
        for (int i = 0; i < 10; i++) {
            Vector2 v = array.get(i);
            assertTrue(v.isZero());
        }
        assertThrows(IndexOutOfBoundsException.class, () -> array.get(11));
        assertThrows(IndexOutOfBoundsException.class, () -> array.get(50));
    }

    @Test
    public void testAdd() {
        array = new V2TmpArray(10);
        array.add(10, 10);
        array.add(20, 20);
        VTestUtils.assertEquals(10, 10, array.get(0));
        VTestUtils.assertEquals(20, 20, array.get(1));

        Assertions.assertEquals(2, array.getSize());
        Assertions.assertEquals(10, array.getMaxSize());
    }

    @Test
    public void testGrow() {
        testCreate();
        Assertions.assertEquals(0, array.getSize());
        Assertions.assertEquals(10, array.getMaxSize());
        array.grow(10);
        assertTrue(array.get(11).isZero());
        assertTrue(array.get(19).isZero());
        Assertions.assertEquals(0, array.getSize());
        Assertions.assertEquals(20, array.getMaxSize());
    }

    @Test
    public void testDecrease() {
        array = new V2TmpArray(10);
        array.decrease(5);

        Assertions.assertEquals(0, array.getSize());
        Assertions.assertEquals(5, array.getMaxSize());

        array.add(10, 10);
        Assertions.assertEquals(1, array.getSize());
        Assertions.assertEquals(5, array.getMaxSize());
    }
}
