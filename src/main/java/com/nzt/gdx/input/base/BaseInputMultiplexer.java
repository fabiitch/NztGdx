package com.nzt.gdx.input.base;

import com.badlogic.gdx.InputEventQueue;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class BaseInputMultiplexer extends InputMultiplexer {

	public InputEventQueue queue;
	public BaseInputHandler inputHandler;

	public BaseInputMultiplexer(Stage stage, BaseInputHandler inputHandler) {
		super(stage);
		queue = new InputEventQueue(inputHandler);
		this.addProcessor(queue);

	}

	public void update() {
		queue.drain();
	}
}
