package com.nzt.gdx.test.api.utils;

import com.badlogic.gdx.utils.Array;
import com.nzt.gdx.utils.arrays.GdxArrayUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GdxArrayUtilsTest {

    @Test
    public void addIfNotPresentTest() {
        Array<Integer> array = new Array<>();
        array.add(1, 2, 3);
        Assertions.assertEquals(3, array.size);
        GdxArrayUtils.addIfNotPresent(array, Integer.valueOf(4));
        Assertions.assertEquals(4, array.size);
        GdxArrayUtils.addIfNotPresent(array, Integer.valueOf(4));
        Assertions.assertEquals(4, array.size);
    }
}
