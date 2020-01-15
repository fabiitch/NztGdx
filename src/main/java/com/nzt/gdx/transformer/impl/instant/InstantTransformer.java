package com.nzt.gdx.transformer.impl.instant;

import com.nzt.gdx.transformer.BaseTransformer;

public abstract class InstantTransformer<T> extends BaseTransformer<T> {
	protected abstract void begin();

	protected abstract void end();

	@Override
	protected void act(float percent) {

	}

}
