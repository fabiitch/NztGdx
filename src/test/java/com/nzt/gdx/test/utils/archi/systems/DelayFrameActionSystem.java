package com.nzt.gdx.test.utils.archi.systems;

import com.badlogic.ashley.core.EntitySystem;

import java.util.HashMap;
import java.util.concurrent.Callable;

/**
 * use this for call functions after X frames.
 */
public class DelayFrameActionSystem extends EntitySystem {

    private long loopCount = 0;
    private final HashMap<Long, Callable> functionToCalls = new HashMap<>();

    public DelayFrameActionSystem() {
        super();
    }

    public DelayFrameActionSystem(int priority) {
        super(priority);
    }

    public void addFunctionToCall(long loopCount, Callable<Boolean> fct) {
        functionToCalls.put(loopCount, fct);
    }

    public void reset() {

    }

    @Override
    public void update(float dt) {
        loopCount++;
        Callable functionToCall = functionToCalls.get(loopCount);
        if (functionToCall != null) {
            try {
                functionToCall.call();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (loopCount == Long.MAX_VALUE)
            loopCount = 0;

    }

}
