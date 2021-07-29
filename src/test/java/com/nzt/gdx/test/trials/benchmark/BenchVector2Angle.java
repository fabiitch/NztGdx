package com.nzt.gdx.test.trials.benchmark;

import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.math.vectors.V2;

public class BenchVector2Angle extends BaseBench {
    Vector2 v = new Vector2(100, 100);

    public static void main(String[] args) {
        BenchVector2Angle test = new BenchVector2Angle();
        test.testMillion();
    }

    @Override
    public void methodA() {
        v.angleDeg();
    }

    @Override
    public void methodB() {
        V2.angleDeg(v);
    }
}
