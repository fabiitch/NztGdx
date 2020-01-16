package com.nzt.gdx.transformer;

import static com.badlogic.gdx.utils.Pools.obtain;

import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.utils.Pools;
import com.badlogic.gdx.utils.Pool.Poolable;

public abstract class BaseTransformer<T> implements Poolable {
	public float duration, time;
	public Interpolation interpolation;
	public boolean reverse, began, complete;
	public T value, target;

	
	//TODO a finir
	public static <T extends BaseTransformer<V>, V> T getTransformer(Class<T> cl, float duration, V value,
			V target, Interpolation interpolation) {
		T transformer = obtain(cl);
		initTransformer(transformer, duration, value, target, interpolation);
		return transformer;
	}
	private static <T extends BaseTransformer<V>, V> void initTransformer(T transformer, float duration, V value,
			V target, Interpolation interpolation) {
		transformer.value = value;
		transformer.target = target;
		transformer.duration = duration;
		transformer.interpolation = interpolation;
	}
	
	public boolean update(float delta) {
		if (complete)
			return true;
		if (!began) {
			begin();
			began = true;
		}
		time += delta;
		complete = time >= duration;
		float percent = complete ? 1 : time / duration;
		if (interpolation != null)
			percent = interpolation.apply(percent);
		act(reverse ? 1 - percent : percent);
		if (complete)
			end();
		return complete;
	}

	abstract protected void act(float percent);

	@Override
	public void reset() {
		time = duration = 0;
		reverse = began = complete = false;
		interpolation = null;
		value = target = null;
		restart();
	}

	/** Sets the state of the action so it can be run again. */
	public abstract void restart();

	/**
	 * Called the first time {@link #act(float)} is called. This is a good place to
	 * query the {@link #actor actor's} starting state.
	 */
	protected void begin() {
	}

	/** Called the last time {@link #act(float)} is called. */
	protected void end() {
	}
}
