package com.nzt.gdx.math.vectors;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

/**
 * Array Vector who only copy values inside him
 *
 */
public class V2TmpArray {
    public Array<Vector2> array;

    int fakeSize = 0;

    public V2TmpArray(int size) {
        this.array = new Array<>(size);
        grow(size);
    }

    public int getSize() {
        return fakeSize;
    }

    public int getMaxSize() {
        return array.size;
    }

    public Vector2 get(int index) {
        return array.get(index);
    }

    public void add(Vector2 v2) {
        array.get(fakeSize++).set(v2);
    }

    public void add(float x, float y) {
        array.get(fakeSize++).set(x, y);
    }


    public void grow(int size) {
        for (int i = 0; i < size; i++)
            array.add(new Vector2());
    }

    public void clear() {
        array.clear();
    }

    public void remove(int index) {
        array.removeIndex(index);
    }

    public void decrease(int size) {
        array.setSize(array.size - size);
    }
}
