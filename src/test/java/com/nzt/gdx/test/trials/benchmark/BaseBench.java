package com.nzt.gdx.test.trials.benchmark;

import com.badlogic.gdx.utils.TimeUtils;

/**
 * ne vaut pas grand chose
 */
public abstract class BaseBench {

    protected final static int MILLION = 1_000_000;
    protected final static int MILLE = 1000;

    public abstract void methodA();

    public abstract void methodB();

    public void testMillion() {
        test(MILLION);
    }

    public void test10Million() {
        test(MILLION * 10);
    }

    public void testMille() {
        test(MILLE);
    }

    public void test(int nbIteration) {
        long startA = System.nanoTime();
        for (int i = 0; i < nbIteration; i++) {
            methodA();
        }
        long endA = System.nanoTime();

        long startB = System.nanoTime();
        for (int i = 0; i < nbIteration; i++) {
            methodB();
        }
        long endB = System.nanoTime();

        long timeA =  TimeUtils.nanosToMillis(endA - startA);
        long timeB =  TimeUtils.nanosToMillis(endB - startB);
        System.out.println("====================");
        System.out.println("Method A");
        System.out.println("total time : " + timeA + "ms" + " | " + timeA / 1000 + "s");
        System.out.println("Average : " + timeA / nbIteration + "ms" + " | " + timeA / nbIteration / 1000 + "s");
        System.out.println("------------------------");
        System.out.println("Method B");
        System.out.println("total time : " + timeB + "ms" + " | " + timeB / 1000 + "s");
        System.out.println("Average : " + timeB / nbIteration + "ms" + " | " + timeB / nbIteration / 1000 + "s");
        System.out.println("====================");
    }
}
