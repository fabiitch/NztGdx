package com.nzt.gdx.test.trials.st.b2D;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.nzt.gdx.b2d.FixtureDefWrapper;
import com.nzt.gdx.b2d.factories.BaseBodyFactory;
import com.nzt.gdx.test.trials.tester.archi.main.FastTesterMain;
import com.nzt.gdx.test.trials.tester.archi.screens.TestScreenWithHudDebug;
import com.nzt.gdx.test.trials.tester.selector.TestScreen;

@TestScreen(group = "box2D")
public class STMultipleWorld extends TestScreenWithHudDebug {
	private Camera camera;
	private World world1, world2;

	public BaseBodyFactory bodyFactory1, bodyFactory2;
	public Box2DDebugRenderer debugRenderer1, debugRenderer2;

	public STMultipleWorld(FastTesterMain main) {
		super(main);
		world1 = new World(Vector2.Zero, true);
		world2 = new World(Vector2.Zero, true);
		bodyFactory1 = new BaseBodyFactory(world1, B2DTestConstants.PPM);
		bodyFactory2 = new BaseBodyFactory(world2, B2DTestConstants.PPM);

		debugRenderer1 = new Box2DDebugRenderer();
		debugRenderer2 = new Box2DDebugRenderer();

		this.camera = new OrthographicCamera(B2DTestConstants.WIDTH_PPM, B2DTestConstants.HEIGHT_PPM);
		this.camera.position.set(0, 0, 0);
		this.camera.lookAt(0, 0, 0);
		addTriangle(1);
		addTriangle(2);

	}

	@Override
	public void renderAfterHud(float dt) {
		camera.update();
		world1.step(1 / 60f, 2, 6);
		world2.step(1 / 60f, 2, 6);
		debugRenderer1.render(world1, camera.combined);
		debugRenderer2.render(world2, camera.combined);
	}

	@Override
	public void doDispose() {
		super.doDispose();
		world1.dispose();
		world2.dispose();
		debugRenderer1.dispose();
		debugRenderer2.dispose();
	}

	FixtureDefWrapper fixtureDefWrapper = new FixtureDefWrapper(BodyDef.BodyType.DynamicBody).setSensor(false)
			.setDensity(1).setToPPM(false);

	private void addTriangle(int world) {
		Vector2 a = new Vector2(0, 0);
		Vector2 b = new Vector2(1, 0);
		Vector2 c = new Vector2(1, 1);
		Body triangleBody;
		if (world == 1) {
			triangleBody = bodyFactory1.createPolygonBody(new Vector2[] { a, b, c }, fixtureDefWrapper);
			triangleBody.setAngularVelocity(1);
		} else {
			triangleBody = bodyFactory2.createPolygonBody(new Vector2[] { a, b, c }, fixtureDefWrapper);
			triangleBody.setAngularVelocity(-1);
		}
	}
}
