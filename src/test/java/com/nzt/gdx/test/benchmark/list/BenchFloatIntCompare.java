package com.nzt.gdx.test.benchmark.list;

import com.nzt.gdx.test.benchmark.BaseBench;

/**
 * https://www.grey-panther.net/2016/08/benchmarking-the-cost-of-primitive-operations-on-the-jvm.html
 */
public class BenchFloatIntCompare extends BaseBench {
    int int1 = 1222;
    int int2 = 12213;

    float float1 = 1222f;
    float float2 = 12213f;

    public static void main(String[] args) {
        BenchVector2Angle test = new BenchVector2Angle();
        test.test10Million();
    }

    @Override
    public void methodA() {
        boolean b = int1 == int2;
    }

    @Override
    public void methodB() {
        boolean b = float1 == float2;
    }
}
