package com.nzt.gdx.box2D;

import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.Shape;
import com.nzt.gdx.logger.utils.NzLoggable;

public class FixtureDefWrapper extends FixtureDef implements NzLoggable {
	public BodyType bodyType;

	public FixtureDefWrapper(BodyType bodyType) {
		super();
		this.bodyType = bodyType;
	}

	public FixtureDefWrapper(boolean isSensor, float friction, float restitution, float density, Shape shape,
			BodyType bodyType) {
		super();
		this.shape = shape;
		this.friction = friction;
		this.restitution = restitution;
		this.density = density;
		this.isSensor = isSensor;
		this.bodyType = bodyType;
	}

	public FixtureDefWrapper(Shape shape, BodyType bodyType) {
		super();
		this.shape = shape;
		this.bodyType = bodyType;
	}

	public FixtureDef apply() {
		FixtureDef fdef = new FixtureDef();
		fdef.shape = this.shape;
		fdef.friction = this.friction;
		fdef.restitution = this.restitution;
		fdef.density = this.density;
		fdef.isSensor = this.isSensor;
		fdef.filter.categoryBits = this.filter.categoryBits;
		fdef.filter.maskBits = this.filter.maskBits;
		fdef.filter.groupIndex = this.filter.groupIndex;
		return fdef;
	}

	public FixtureDefWrapper setAllZeroAndSensor(boolean sensor) {
		this.friction = 0;
		this.restitution = 0;
		this.density = 0;
		this.isSensor = sensor;
		return this;
	}

	public FixtureDefWrapper attachRectangleShape(float witdh, float height) {
		PolygonShape newShape = new PolygonShape();
		newShape.setAsBox(witdh / 2, height / 2);
		this.shape = newShape;
		return this;
	}

	public FixtureDefWrapper setFriction(float friction) {
		this.friction = friction;
		return this;
	}

	public FixtureDefWrapper setDensity(float density) {
		this.density = density;
		return this;
	}

	public FixtureDefWrapper setRestitution(float restitution) {
		this.restitution = restitution;
		return this;
	}

	public FixtureDefWrapper setSensor(boolean isSensor) {
		this.isSensor = isSensor;
		return this;
	}

	public FixtureDefWrapper setBodyType(BodyType bodyType) {
		this.bodyType = bodyType;
		return this;
	}

	@Override
	public String gdxLogTag() {
		return "FixtureDefWrapper";
	}

	@Override
	public String gdxLogValue() {
		return "bodyType=" + bodyType + ", shape=" + shape + ", friction=" + friction + ", restitution=" + restitution
				+ ", density=" + density + ", isSensor=" + isSensor + ", filter : categoryBits:"+filter.categoryBits +"|maskBits:"+filter.maskBits+"|groupIndex="+filter.groupIndex ;
	}

}