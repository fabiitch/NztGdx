package com.nzt.gdx.transformer.factory;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Pools;
import com.nzt.gdx.transformer.BaseTransformer;
import com.nzt.gdx.transformer.impl.ColorGradientTransfomer;
import com.nzt.gdx.transformer.impl.MoveToTransformer;

public class TransformerFactory {

	private static <T extends BaseTransformer<V>, V> T getTransformer(Class<T> cl) {
		return Pools.obtain(cl);
	}

	public static MoveToTransformer moveTo(float duration, Vector2 value, Vector2 target, Interpolation interpolation) {
		MoveToTransformer aa = getTransformer(MoveToTransformer.class);
		initTransformer(aa, duration, value, target, interpolation);
		return aa;
	}

	public static ColorGradientTransfomer colorGradient(float duration, Color value, Color target, Interpolation interpolation) {
		ColorGradientTransfomer aa = getTransformer(ColorGradientTransfomer.class);
		initTransformer(aa, duration, value, target, interpolation);
		return aa;
	}

	private static <T extends BaseTransformer<V>, V> void initTransformer(T transformer, float duration, V value,
			V target, Interpolation interpolation) {
		transformer.value = value;
		transformer.target = target;
		transformer.duration = duration;
		transformer.interpolation = interpolation;
	}
}
