package com.nzt.gdx.math.shape.builders;

//TODO a voir ya un new dans get();
public class TriangleBuilder {

	
	private TriangleBuilder() {
	}

	public static TriangleBuilder get() {
		return new TriangleBuilder();
	}

	public TriangleBuilder angle() {
		return this;
	}
}
