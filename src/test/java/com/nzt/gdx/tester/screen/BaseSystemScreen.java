package com.nzt.gdx.tester.screen;

import com.badlogic.ashley.core.Engine;
import com.nzt.gdx.main.AbstractMain;
import com.nzt.gdx.screen.SimpleScreen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.function.Function;

public class BaseSystemScreen extends SimpleScreen {

    protected Engine engine;

    long loopCount = 0;

    HashMap<Long, Callable> functionToCalls = new HashMap<>();


    public void addFunctionToCall(long loopCount, Callable<Boolean> fct) {
        functionToCalls.put(loopCount, fct);
    }

    public BaseSystemScreen(AbstractMain main) {
        super(main);
        this.engine = new Engine();
    }

    @Override
    protected void renderScreen(float dt) {
        loopCount++;
        Callable functionToCall = functionToCalls.get(loopCount);
        if (functionToCall != null) {
            try {
                functionToCall.call();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        engine.update(dt);
    }
}
