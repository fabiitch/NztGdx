package com.nzt.gdx.tester.screen;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.nzt.gdx.ashley.components.physx.B2DBodyComponent;
import com.nzt.gdx.ashley.systems.b2d.B2DApplyEventsSystem;
import com.nzt.gdx.ashley.systems.b2d.B2DWorldSystem;
import com.nzt.gdx.ashley.systems.render.B2DDebugSystem;
import com.nzt.gdx.b2d.factory.BaseBodyFactory;
import com.nzt.gdx.main.AbstractMain;
import com.nzt.gdx.screen.b2d.B2DTestConstants;

public class BaseB2DScreen extends BaseSystemScreen {
    public World world;
    public Camera camera;
    public BaseBodyFactory bodyFactory;

    public BaseB2DScreen(AbstractMain main) {
        super(main);
        this.camera = new OrthographicCamera(B2DTestConstants.WIDTH_PPM, B2DTestConstants.HEIGHT_PPM);
        this.camera.position.set(0, 0, 0);
        this.camera.lookAt(0, 0, 0);

        this.world = new World(Vector2.Zero, true);
        B2DWorldSystem worldSystem = new B2DWorldSystem(world, true);
        B2DApplyEventsSystem b2DApplyEventsSystem = new B2DApplyEventsSystem(world);
        B2DDebugSystem debugSystem = new B2DDebugSystem(world, camera);

        bodyFactory = new BaseBodyFactory(world, B2DTestConstants.PPM);

        engine.addSystem(worldSystem);
        engine.addSystem(b2DApplyEventsSystem);
        engine.addSystem(debugSystem);
    }

    public Entity addEntityBody(Body body) {
        Entity entity = engine.createEntity();
        engine.addEntity(entity);
        B2DBodyComponent box2dBodyComponent = engine.createComponent(B2DBodyComponent.class);
        box2dBodyComponent.body = body;
        entity.add(box2dBodyComponent);

        return entity;
    }
}
