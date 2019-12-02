package com.nzt.gdx.b2d.services;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.nzt.gdx.archi.AbstractGameService;
import com.nzt.gdx.b2d.FixtureDefWrapper;
import com.nzt.gdx.box2D.helpers.Box2DConverter;
import com.nzt.gdx.utils.logger.LogTagBase;
import com.nzt.gdx.utils.logger.NzLoggableUtils;
import com.nzt.gdx.utils.logger.TagLogger;

public class AbstractBodyFactoryService extends AbstractGameService {

	protected World world;
	protected float PPM;

	@Override
	public void dispose() {
	}

	public AbstractBodyFactoryService(World world, float ppm) {
		super();
//		new Box2DJointCreator(world, ppm);
		this.world = world;
		this.PPM = ppm;
		Box2DConverter.initMetrics(ppm);
	}

	/**
	 * create rectangle body from rect position
	 * 
	 * @param rectangle
	 * @param fixtureDefWrapper
	 * @return
	 */
	public Body createRectangleBody(Rectangle rectangle, FixtureDefWrapper fixtureDefWrapper) {
		BodyDef bdef = new BodyDef();
		PolygonShape shape = new PolygonShape();
		FixtureDef fdef = fixtureDefWrapper.apply();
		bdef.type = fixtureDefWrapper.bodyType;
		bdef.position.set((rectangle.getX()), (rectangle.getY()));
		Body body = world.createBody(bdef);
		shape.setAsBox(rectangle.getWidth() / 2, rectangle.getHeight() / 2);
		fdef.shape = shape;
		body.createFixture(fdef);
		TagLogger.logBlock(LogTagBase.B2D_CREATION, NzLoggableUtils.create(rectangle), fixtureDefWrapper);
		return body;
	}

	/**
	 * create rect body from position
	 * @param position
	 * @param witdh
	 * @param height
	 * @param fixtureDefWrapper
	 * @return
	 */
	public Body createRectangleBody(Vector2 position, float witdh, float height, FixtureDefWrapper fixtureDefWrapper) {
		BodyDef bdef = new BodyDef();
		PolygonShape shape = new PolygonShape();
		FixtureDef fdef = fixtureDefWrapper.apply();
		bdef.type = fixtureDefWrapper.bodyType;
		bdef.position.set(position.x, position.y);
		shape.setAsBox(witdh / 2, height / 2);
		fdef.shape = shape;
		Body body = world.createBody(bdef);
		body.createFixture(fdef);
		TagLogger.logBlock(LogTagBase.B2D_CREATION, NzLoggableUtils.create(bdef.position), fixtureDefWrapper);
		return body;
	}

	/**
	 * create circle body
	 * 
	 * @param position
	 * @param rayon
	 * @param fixtureDefWrapper
	 * @return
	 */
	public Body createCircleBody(Vector2 position, float rayon, FixtureDefWrapper fixtureDefWrapper) {
		Body body = createBody(position.x, position.y, fixtureDefWrapper.bodyType);
		FixtureDef fdef = fixtureDefWrapper.apply();
		CircleShape shape = new CircleShape();
		shape.setRadius(rayon);
		fdef.shape = shape;

		TagLogger.logBlock(LogTagBase.B2D_CREATION, NzLoggableUtils.create(position), fixtureDefWrapper);
		Fixture fixture = body.createFixture(fdef);
		return body;
	}

	private Body createBody(float x, float y, BodyType bodyType) {
		BodyDef bodyDef = new BodyDef();
		bodyDef.position.set(x, y);
		bodyDef.type = bodyType;
		Body body = world.createBody(bodyDef);
		return body;
	}

	private Body createPolygonBody(Vector2[] vertices, FixtureDefWrapper fixtureDefWrapper) {
		Body body = createBody(0, 0, fixtureDefWrapper.bodyType);
		FixtureDef fdef = fixtureDefWrapper.apply();
		PolygonShape shape = new PolygonShape();
		shape.set(vertices);

		Fixture fixture = body.createFixture(fdef);
		// fixture.setUserData(GameObjectType.BAT.toString().toLowerCase());
		body.setActive(false);
		return body;
	}

}
