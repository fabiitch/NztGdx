package com.nzt.gdx.input;

public abstract class SimpleClickInputHandler extends BaseGameInputHandler{

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
