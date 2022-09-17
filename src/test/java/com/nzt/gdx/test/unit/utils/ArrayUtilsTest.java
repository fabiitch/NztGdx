package com.nzt.gdx.test.unit.utils;

import com.badlogic.gdx.utils.Array;
import com.nzt.gdx.utils.arrays.ArrayUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayUtilsTest {

    @Test
    public void addIfNotPresentValueTest() {
        Array<Integer> array = new Array<>();
        array.add(1, 2, 3);
        Assertions.assertEquals(3, array.size);
        ArrayUtils.addIfNotPresent(array, Integer.valueOf(4));
        Assertions.assertEquals(4, array.size);
        ArrayUtils.addIfNotPresent(array, Integer.valueOf(4));
        Assertions.assertEquals(4, array.size);
    }

    @Test
    public void addIfNotPresentArrayGdxTest() {
        Array<Integer> arrayBase = new Array<>();
        Integer one = 1, three = 3, nine = 9;
        arrayBase.add(one, 2, three, nine);

        Assertions.assertEquals(4, arrayBase.size);

        Array<Integer> arrayAdd = new Array<>();
        arrayAdd.add(one, 10, three);

        ArrayUtils.addIfNotPresent(arrayBase, arrayAdd);
        Assertions.assertEquals(5, arrayBase.size);
    }

    @Test
    public void addIfNotPresentArrayTest() {
        Array<Integer> arrayBase = new Array<>();
        Integer one = 1, three = 3, nine = 9;
        arrayBase.add(one, 2, three, nine);
        Assertions.assertEquals(4, arrayBase.size);

        Integer[] arrayAdd = new Integer[]{one, 55, nine};
        ArrayUtils.addIfNotPresent(arrayBase, arrayAdd);
        Assertions.assertEquals(5, arrayBase.size);
    }
}
