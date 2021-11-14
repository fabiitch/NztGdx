//package com.nzt.gdx.utils.arrays;
//
//import com.badlogic.gdx.math.Vector2;
//import com.badlogic.gdx.utils.Array;
//
//import java.util.Iterator;
//import java.util.Spliterator;
//import java.util.function.Consumer;
//
///**
// * Array qui ne se clean jamais
// * @param <T>
// */
//public class ArrayNoClean<T> implements Iterable<T>{
//    public Array<T> array;
//
//    boolean sizeFaked = false;
//    int fakeSize = 0;
//    int realSize = 0;
//
//    public ArrayNoClean(int size) {
//        this.array = new Array<>(size);
//        grow(size);
//    }
//
//    public int getSize() {
//        return fakeSize;
//    }
//
//    public int getMaxSize() {
//        return array.size;
//    }
//
//    public Vector2 get(int index) {
//        return array.get(index);
//    }
//
//    public void add(Vector2 v2) {
//        this.add(v2.x, v2.y);
//    }
//
//    public void add(float x, float y) {
//        trueSize();
//        array.get(fakeSize++).set(x, y);
//    }
//
//
//    public void grow(int size) {
//        trueSize();
//        for (int i = 0; i < size; i++)
//            array.add(new Vector2());
//    }
//
//
//    public void clear() {
//        array.clear();
//    }
//
//    public void remove(int index) {
//        trueSize();
//        array.removeIndex(index);
//        fakeSize--;
//    }
//
//    public void decrease(int size) {
//        trueSize();
//        array.setSize(array.size - size);
//    }
//
//    private void fakeSize() {
//        if (!sizeFaked) {
//            realSize = array.size;
//            array.size = fakeSize;
//            sizeFaked = true;
//        }
//    }
//
//    private void trueSize() {
//        if (sizeFaked) {
//            array.size = realSize;
//            sizeFaked = false;
//        }
//    }
//
//    @Override
//    public Iterator<T> iterator() {
//        fakeSize();
//        return array.iterator();
//    }
//
//    @Override
//    public void forEach(Consumer<? super T> action) {
//        fakeSize();
//        array.forEach(action);
//    }
//
//    @Override
//    public Spliterator<T> spliterator() {
//        fakeSize();
//        return array.spliterator();
//    }
//}
