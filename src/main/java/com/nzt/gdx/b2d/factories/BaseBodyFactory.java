package com.nzt.gdx.b2d.factories;

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
import com.nzt.gdx.b2d.FixtureDefWrapper;
import com.nzt.gdx.b2d.utils.B2DConverterHelper;
import com.nzt.gdx.logger.tag.LogTagsBase;
import com.nzt.gdx.logger.tag.TagLogger;
import com.nzt.gdx.logger.utils.NzLoggableUtils;

/**
 * base body factory for create circle/rect body //TODO less new BodyDef TODO
 * public static BodyDef set(BodyDef bodyDef, Body body) { demertfan bloquer
 * rotation sur les body direct body.isFixedRotation();
 * 
 * @author fabiitch
 *
 */
public class BaseBodyFactory {

	protected World world;
	public float ppm;
	public B2DConverterHelper b2DConverter;

	public BaseBodyFactory(World world, float ppm) {
		super();
		this.world = world;
		this.ppm = ppm;
		this.b2DConverter = new B2DConverterHelper(ppm);
	}

	public Body createRectangleBody(Rectangle rectangle, FixtureDefWrapper fixtureDefWrapper) {
		if (fixtureDefWrapper.toPPM)
			rectangle = b2DConverter.toPPM(rectangle);

		BodyDef bdef = new BodyDef();
		PolygonShape shape = new PolygonShape();
		FixtureDef fdef = fixtureDefWrapper.apply();
		bdef.type = fixtureDefWrapper.bodyType;
		bdef.position.set((rectangle.getX()), (rectangle.getY()));
		Body body = world.createBody(bdef);
		shape.setAsBox(rectangle.getWidth() / 2, rectangle.getHeight() / 2);
		fdef.shape = shape;
		body.createFixture(fdef);
		TagLogger.infoBlock(LogTagsBase.B2D_CREATION, "FixtureDefWrapper", NzLoggableUtils.create(rectangle),
				fixtureDefWrapper);
		return body;
	}

	public Body createRectangleBody(Vector2 position, float witdh, float height,
			FixtureDefWrapper fixtureDefWrapper) {
		if (fixtureDefWrapper.toPPM) {
			witdh = b2DConverter.toPPM(witdh);
			height = b2DConverter.toPPM(height);
		}

		BodyDef bdef = new BodyDef();
		PolygonShape shape = new PolygonShape();
		FixtureDef fdef = fixtureDefWrapper.apply();
		bdef.type = fixtureDefWrapper.bodyType;
		bdef.position.set(position.x, position.y);
		shape.setAsBox(witdh / 2, height / 2);
		fdef.shape = shape;
		Body body = world.createBody(bdef);
//		body.createFixture(fdef);
		TagLogger.infoBlock(LogTagsBase.B2D_CREATION, "fixtureDefWrapper",
				NzLoggableUtils.create(bdef.position, witdh, height), fixtureDefWrapper);
		return body;
	}

	public Body createCircleBody(Vector2 position, float rayon, FixtureDefWrapper fixtureDefWrapper) {
		if (fixtureDefWrapper.toPPM) {
			rayon = b2DConverter.toPPM(rayon);
		}

		Body body = createBody(position.x, position.y, fixtureDefWrapper.bodyType);
		FixtureDef fdef = fixtureDefWrapper.apply();
		CircleShape shape = new CircleShape();
		shape.setRadius(rayon);
		fdef.shape = shape;

		TagLogger.infoBlock(LogTagsBase.B2D_CREATION, "fixtureDefWrapper", NzLoggableUtils.create(position, rayon),
				fixtureDefWrapper);
		Fixture fixture = body.createFixture(fdef);
		return body;
	}

	private Body createBody(float x, float y, BodyType bodyType) {
		BodyDef bodyDef = new BodyDef(); //TODO a mettre en cache
		bodyDef.position.set(x, y);
		bodyDef.type = bodyType;
		Body body = world.createBody(bodyDef);
		return body;
	}
	
//	public Body createTriangleBody(Vector2 a, Vector2 b, Vector2 c, FixtureDefWrapper fixtureDefWrapper) {
////		Body body = createBody(position.x, position.y, fixtureDefWrapper.bodyType);
//	}

	// TODO not finish
	public Body createPolygonBody(Vector2[] vertices, FixtureDefWrapper fixtureDefWrapper) {
		Body body = createBody(0, 0, fixtureDefWrapper.bodyType);
		FixtureDef fdef = fixtureDefWrapper.apply();
		PolygonShape shape = new PolygonShape();
		shape.set(vertices);
		fdef.shape = shape;
		Fixture fixture = body.createFixture(fdef);
		return body;
	}

}
