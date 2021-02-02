package com.nzt.gdx.input.base;

import com.badlogic.gdx.InputEventQueue;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;

//TODO a revoir
public class BaseInputMultiplexer extends InputMultiplexer {

    public Array<InputEventQueue> queues;
    public BaseInputHandler inputHandler;

    public BaseInputMultiplexer() {
        super();
        queues = new Array<>();
    }

    public BaseInputMultiplexer(Stage stage) {
        super(stage);
        queues = new Array<>();
    }

    public BaseInputMultiplexer(Stage stage, BaseInputHandler inputHandler) {
        super(stage);
        queues = new Array<>();
        InputEventQueue inputEventQueue = new InputEventQueue();
        queues.add(inputEventQueue);
        this.addProcessor(inputHandler);
    }

    public void update() {
        for (int i = 0, n = queues.size; i < n; i++) {
            queues.get(i).drain(this);
        }
    }
}
