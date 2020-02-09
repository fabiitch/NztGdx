package com.nzt.gdx.input.base;

import com.badlogic.gdx.InputEventQueue;
import com.badlogic.gdx.InputMultiplexer;

public class BaseInputMultiplexer extends InputMultiplexer{

	public InputEventQueue queue;
	public BaseInputHandler inputHandler;
	
	public BaseInputMultiplexer(BaseInputHandler inputHandler) {
		queue = new InputEventQueue(inputHandler);
		this.addProcessor(queue);
	}

	public void update() {
		queue.drain();
	}
}
