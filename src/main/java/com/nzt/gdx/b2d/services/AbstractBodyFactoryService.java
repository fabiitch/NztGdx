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
		return body;
	}

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
		return body;
	}

	/**
	 * circle body from rectangle
	 * 
	 * @param rect
	 * @param bodyType
	 * @return
	 */
	public Body createCircleBody(Rectangle rect, FixtureDefWrapper fixtureDefWrapper) {
		Body body = createBody(rect.getX(), rect.getY(), fixtureDefWrapper.bodyType);
		FixtureDef fdef = fixtureDefWrapper.apply();

		CircleShape shape = new CircleShape();
		shape.setRadius(rect.getWidth() / 2);
		fdef.shape = shape;
		// fixtureDef.isSensor = true;
		Fixture fixture = body.createFixture(fdef);
		// fixture.setUserData(gameObjectType.toString().toLowerCase());
		return body;
	}

	/**
	 * circle body from rectangle
	 * 
	 * @param rect
	 * @param bodyType
	 * @return
	 */
	public Body createCircleBody(Vector2 position, float rayon, FixtureDefWrapper fixtureDefWrapper) {
		Body body = createBody(position.x, position.y, fixtureDefWrapper.bodyType);
		FixtureDef fdef = fixtureDefWrapper.apply();
		CircleShape shape = new CircleShape();
		System.out.println("createCircleBody rayon" + rayon);
		shape.setRadius(rayon);
		fdef.shape = shape;
		fdef.friction = 0;
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
