package com.nzt.gdx.counter;

import com.badlogic.gdx.utils.Pool;

public class IntCounter implements Pool.Poolable {
    public int total;
    public int count;
    public int current;

    public int min = Integer.MAX_VALUE;
    public int max = Integer.MIN_VALUE;
    public float average;

    public void add(int value) {
        if (total >= Integer.MAX_VALUE || count >= Integer.MAX_VALUE) {
            reset();
        }
        count++;
        this.total += value;
        this.current = value;
        this.min = Math.min(min, current);
        this.max = Math.max(max, current);
        this.average = total / count;
    }

    public void addCurrent() {
        this.add(this.current);
    }

    @Override
    public void reset() {
        this.count = 0;
        this.current = 0;
        this.min = 0;
        this.max = 0;
        this.average = 0;
    }

    public String toStringCurrentAverage(String fieldName) {
        return fieldName + ": " + "current=" + current + ", average=" + average;
    }

    public String toStringCurrentAverage() {
        return "current=" + current + ", average=" + average;
    }

    public String toString(String fieldName) {
        return fieldName + "{" +
                "count=" + count +
                ", current=" + current +
                ", min=" + min +
                ", max=" + max +
                ", average=" + average +
                '}';
    }

    @Override
    public String toString() {
        return "IntCounter{" +
                "count=" + count +
                ", current=" + current +
                ", min=" + min +
                ", max=" + max +
                ", average=" + average +
                '}';
    }


}
