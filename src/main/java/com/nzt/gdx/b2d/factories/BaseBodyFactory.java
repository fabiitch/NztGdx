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
import com.nzt.gdx.b2d.utils.B2DCalcul;
import com.nzt.gdx.b2d.utils.B2DConverter;
import com.nzt.gdx.b2d.utils.B2DConverterHelper;
import com.nzt.gdx.logger.tag.LogTagsBase;
import com.nzt.gdx.logger.tag.TagLogger;
import com.nzt.gdx.logger.utils.NzLoggableUtils;

import java.util.Arrays;

/**
 * base body factory for create circle/rect body //TODO less new BodyDef TODO
 * public static BodyDef set(BodyDef bodyDef, Body body) { demertfan bloquer
 * rotation sur les body direct body.isFixedRotation();
 *
 * @author fabiitch
 */
//TODO a reprendre
public class BaseBodyFactory {

	public final World world;
	public final float ppm;
	public final B2DConverterHelper b2DConverter;

	public BaseBodyFactory(World world, float ppm) {
		super();
		this.world = world;
		this.ppm = ppm;
		this.b2DConverter = new B2DConverterHelper(ppm);
	}

	public Body createRectangleBody(Rectangle rectangle, FixtureDefWrapper fixtureDefWrapper) {
		if (fixtureDefWrapper.toPPM) {
			rectangle = b2DConverter.toPPM(rectangle);
		}
		BodyDef bdef = new BodyDef();
		PolygonShape shape = new PolygonShape();
		FixtureDef fdef = fixtureDefWrapper.apply();
		bdef.type = fixtureDefWrapper.bodyType;
		bdef.position.set((rectangle.getX() + rectangle.getWidth() / 2),
				(rectangle.getY() + rectangle.getHeight() / 2));
		Body body = world.createBody(bdef);
		shape.setAsBox(rectangle.getWidth() / 2, rectangle.getHeight() / 2);
		fdef.shape = shape;

		Fixture fixture = body.createFixture(fdef);
		fixture.setUserData(fixtureDefWrapper.userData);

		TagLogger.infoBlock(LogTagsBase.B2D_CREATION, "FixtureDefWrapper", NzLoggableUtils.create(rectangle),
				fixtureDefWrapper);
		return body;
	}

	public Body createPolygonBody(float[] vertices, FixtureDefWrapper fixtureDefWrapper) {
		Vector2[] arrayVertices = new Vector2[vertices.length / 2];
		for (int i = 0; i < vertices.length / 2; i++) {
			if (fixtureDefWrapper.toPPM) {
				vertices[i] = b2DConverter.toPPM(vertices[i]);
				vertices[i] = b2DConverter.toPPM(vertices[i + 1]);
			}
			arrayVertices[i] = new Vector2(vertices[i], vertices[i + 1]);
		}
		return createPolygonBody(arrayVertices, fixtureDefWrapper);

	}

	public Body createPolygonBody(Vector2[] vertices, FixtureDefWrapper fixtureDefWrapper) {
		if (fixtureDefWrapper.toPPM) {
			Arrays.stream(vertices).forEach(v -> b2DConverter.toPPM(v));
		}
		Body body = createBody(vertices[0].x, vertices[0].y, fixtureDefWrapper.bodyType);
		FixtureDef fdef = fixtureDefWrapper.apply();
		PolygonShape shape = new PolygonShape();
		shape.set(vertices);
		fdef.shape = shape;
		Fixture fixture = body.createFixture(fdef);
		fixture.setUserData(fixtureDefWrapper.userData);
		TagLogger.infoBlock(LogTagsBase.B2D_CREATION, "fixtureDefWrapper", NzLoggableUtils.create(vertices),
				fixtureDefWrapper);

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

		Fixture fixture = body.createFixture(fdef);
		fixture.setUserData(fixtureDefWrapper.userData);

		TagLogger.infoBlock(LogTagsBase.B2D_CREATION, "fixtureDefWrapper", NzLoggableUtils.create(position, rayon),
				fixtureDefWrapper);

		return body;
	}

	private Body createBody(float x, float y, BodyType bodyType) {
		BodyDef bodyDef = new BodyDef(); // TODO a mettre en cache
		bodyDef.position.set(x, y);
		bodyDef.type = bodyType;
		Body body = world.createBody(bodyDef);
		return body;
	}

}
