package com.nzt.gdx.input.impl;

import com.nzt.gdx.input.base.BaseInputHandler;

public abstract class SimpleClickInputHandler extends BaseInputHandler{

	@Override
	public boolean doKeyDown(int keycode) {
		return false;
	}

	@Override
	public boolean doKeyUp(int keycode) {
		return false;
	}

	@Override
	public boolean doKeyTyped(char character) {
		return false;
	}


	@Override
	public boolean doTouchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean doMouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean doScrolled(int amount) {
		return false;
	}

}
