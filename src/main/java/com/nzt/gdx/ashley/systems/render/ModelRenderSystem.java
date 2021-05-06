package com.nzt.gdx.ashley.systems.render;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;
import com.nzt.gdx.ashley.NztSystemsOrder;
import com.nzt.gdx.ashley.components.mvt.PositionComponent;
import com.nzt.gdx.ashley.components.renders.Model3DComponent;
import com.nzt.gdx.debug.perf.PerformanceFrame;

public class ModelRenderSystem extends IteratingSystem {
    private ModelBatch modelBatch;
    private Camera camera;

    ComponentMapper<Model3DComponent> modelMapper = Model3DComponent.mapper;
    private ComponentMapper<PositionComponent> positionMapper = PositionComponent.mapper;

    public ModelRenderSystem(Camera camera, ModelBatch modelbatch, int order) {
        super(Family.all(PositionComponent.class, Model3DComponent.class).get(), order);
        this.camera = camera;
        this.modelBatch = modelbatch;
        PerformanceFrame.addSystem(this);
    }

    public ModelRenderSystem(Camera camera, ModelBatch modelbatch) {
        this(camera, modelbatch, NztSystemsOrder.RENDER);
    }

    @Override
    public void update(float deltaTime) {
        PerformanceFrame.startSystem(this);
        modelBatch.begin(camera);
        super.update(deltaTime);
        modelBatch.end();
        PerformanceFrame.endSystem(this);
    }


    private BoundingBox boundingBox = new BoundingBox();

    protected void processEntity(Entity entity, float deltaTime) {
        Model3DComponent model3dComponent = modelMapper.get(entity);
        ModelInstance modelInstance = model3dComponent.modelInstance;

        if (model3dComponent.visible) {
            PositionComponent positionComponent = positionMapper.get(entity);
            Vector3 pos = positionComponent.position;

            modelInstance.transform.setToRotation(Vector3.Z, positionComponent.angleRadian);

            modelInstance.transform.rotate(Vector3.X, 90);
            modelInstance.transform.rotate(Vector3.Y, positionComponent.angleRadian * MathUtils.radiansToDegrees);
            modelInstance.transform.setTranslation(pos.x, pos.y, pos.z);
            modelInstance.calculateTransforms();//TODO

//            if (!camera.frustum.boundsInFrustum(modelInstance.calculateBoundingBox(boundingBox))){//TODO
                modelBatch.render(modelInstance, model3dComponent.environment);// TODO voir le param environement
//            }else{
//                System.out.println("OUUUT");
//            }

        }
    }

}
