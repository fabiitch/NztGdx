//package com.nzt.gdx.ashley.systems.physx;
//
//import com.badlogic.ashley.core.ComponentMapper;
//import com.badlogic.ashley.core.Entity;
//import com.badlogic.gdx.math.Vector2;
//import com.badlogic.gdx.math.Vector3;
//import com.badlogic.gdx.utils.Array;
//import com.nzt.gdx.ashley.components.mvt.PositionComponent;
//import com.nzt.gdx.ashley.components.mvt.Velocity2DComponent;
//import com.nzt.gdx.ashley.components.physx.PhysXComponent;
//
//public class PhysX {
//    private static ComponentMapper<PositionComponent> posMapper = PositionComponent.mapper;
//    private static ComponentMapper<PhysXComponent> shapeMapper = PhysXComponent.mapper;
//    private static ComponentMapper<Velocity2DComponent> velocityMapper = Velocity2DComponent.mapper;
//    public Array<Entity> staticBodies;
//    public Array<Entity> dynamicBodies;
//
//    public PhysX() {
//        this.staticBodies = new Array<>();
//        this.dynamicBodies = new Array<>();
//    }
//
//
//    public void step(float dt) {
//        for (int i = 0, n = dynamicBodies.size; i < n; i++) {
//            Entity entity = dynamicBodies.get(i);
//            PositionComponent positionComponent = posMapper.get(entity);
//            PhysXComponent physxComponent = shapeMapper.get(entity);
//            Velocity2DComponent velocity2DComponent = velocityMapper.get(entity);
////            positionComponent.position.add(velocity2DComponent.velocity.x * dt, velocity2DComponent.velocity.y * dt, positionComponent.position.x);
//
//            Vector2 velScaled = velocity2DComponent.velocity.cpy().scl(dt);
//            Vector3 position = positionComponent.position;
//
//            //collideX
//            position.x += velScaled.x;
//            float xTouch;
//            boolean moveToRight = velScaled.x > 0;
//            if (moveToRight) {
//                xTouch = physxComponent.nzShape.getXMax();
//            } else {
//                xTouch = physxComponent.nzShape.getXMin();
//            }
//            float xCollision = collideStaticX(new Vector2(xTouch, position.y), moveToRight);
//            if (xCollision != 0) {
//                if (moveToRight) {
//                    position.x = xCollision - physxComponent.nzShape.getXMaxShape();
//                } else {
//                    position.x = xCollision + physxComponent.nzShape.getXMaxShape();
//                }
//            }
//            position.y += velScaled.y;
//            float yTouch;
//            boolean moveToTop = velScaled.y > 0;
//            if (moveToTop) {
//                yTouch = physxComponent.nzShape.getYMax();
//            } else {
//                yTouch = physxComponent.nzShape.getYMin();
//            }
//            float yCollision = collideStaticY(new Vector2(position.x, yTouch), moveToTop);
//            if (yCollision != 0) {
//                if (moveToTop) {
//                    position.y = yCollision - physxComponent.nzShape.getYMinShape();
//                } else {
//                    position.y = yCollision + physxComponent.nzShape.getYMaxShape();
//                }
//            }
////            position.y += velScaled.y;
//
//
//            physxComponent.nzShape.updatePosition(positionComponent.getPosition());
//        }
//    }
//    public float collideStaticY(Vector2 pos, boolean moveToTop) {
//        for (int i = 0, n = staticBodies.size; i < n; i++) {
//            Entity entity = staticBodies.get(i);
//            PhysXComponent physxComponent = shapeMapper.get(entity);
//            boolean contains = physxComponent.nzShape.contains(pos);
//            if (contains)
//                if (moveToTop) {
//                    return physxComponent.nzShape.getYMin();
//                } else {
//                    return physxComponent.nzShape.getYMax();
//                }
//        }
//        return 0;
//    }
//
//    public float collideStaticX(Vector2 pos, boolean moveToRight) {
//        for (int i = 0, n = staticBodies.size; i < n; i++) {
//            Entity entity = staticBodies.get(i);
//            PhysXComponent physxComponent = shapeMapper.get(entity);
//
//            boolean contains = physxComponent.nzShape.contains(pos);
//            if (contains)
//                if (moveToRight) {
//                    return physxComponent.nzShape.getXMin();
//                } else {
//                    return physxComponent.nzShape.getXMax();
//                }
//        }
//        return 0;
//    }
//}
