package com.nzt.gdx.test.api.utils;

import com.nzt.gdx.utils.ArrayUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ArrayUtilsTest {

    @Test
    public void clearValuesTest(){
        Integer[] array = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        ArrayUtils.clearValues(array);
        Assertions.assertEquals(10, array.length);
        Arrays.stream(array).forEach(i-> Assertions.assertNull(i));
    }

    @Test
    public void removeAndDecalTest() {

        Integer[] array = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        ArrayUtils.removeAndDecal(array, 5);

        Assertions.assertEquals(10, array.length);

        Assertions.assertEquals(0, array[0]);
        Assertions.assertEquals(1, array[1]);
        Assertions.assertEquals(2, array[2]);
        Assertions.assertEquals(3, array[3]);
        Assertions.assertEquals(4, array[4]);
        Assertions.assertEquals(6, array[5]);
        Assertions.assertEquals(7, array[6]);
        Assertions.assertEquals(8, array[7]);
        Assertions.assertEquals(9, array[8]);
        Assertions.assertEquals(null, array[9]);
    }
}
