package com.nzt.gdx.math.shape;

import com.badlogic.gdx.math.Shape2D;
import com.badlogic.gdx.math.Vector2;

//TODO a viré je crois
public class Triangle implements Shape2D {

	private float x, y, z;
	private float originX, originY;
	private float rotation;
	private float scaleX = 1, scaleY = 1;
	private boolean dirty = true;
	
	
	public Triangle(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	
	@Override
	public boolean contains(Vector2 point) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(float x, float y) {
		// TODO Auto-generated method stub
		return false;
	}

}
