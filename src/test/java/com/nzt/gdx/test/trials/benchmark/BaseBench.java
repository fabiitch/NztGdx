package com.nzt.gdx.test.trials.benchmark;

public abstract class BaseBench {

    protected final static int MILLION = 1_000_000;
    protected final static int MILLE = 1000;

    public abstract void methodA();

    public abstract void methodB();

    public void testMillion() {
        test(MILLION);
    }

    public void testMille() {
        test(MILLE);
    }

    public void test(int nbIteration) {
        long startA = System.currentTimeMillis();
        for (int i = 0; i < nbIteration; i++) {
            methodA();
        }
        long endA = System.currentTimeMillis();

        long startB = System.currentTimeMillis();
        for (int i = 0; i < nbIteration; i++) {
            methodB();
        }
        long endB = System.currentTimeMillis();

        long timeA = endA - startA;
        long timeB = endB - startB;
        System.out.println("====================");
        System.out.println("====================");
        System.out.println("Method A");
        System.out.println("total time : " + timeA + "ms" + " | " + timeA / 1000 + "s");
        System.out.println("Average : " + timeA / nbIteration + "ms" + " | " + timeA / nbIteration / 1000 + "s");
        System.out.println("Method B");
        System.out.println("total time : " + timeB + "ms" + " | " + timeB / 1000 + "s");
        System.out.println("Average : " + timeB / nbIteration + "ms" + " | " + timeB / nbIteration / 1000 + "s");
        System.out.println("====================");
        System.out.println("====================");
    }
}
