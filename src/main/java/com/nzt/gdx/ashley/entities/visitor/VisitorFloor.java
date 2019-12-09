//package com.nzt.gdx.ashley.entities.visitor;
//
//import com.badlogic.ashley.core.Entity;
//import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.physics.box2d.Body;
//import com.nzt.gdx.ashley.components.TransformComponent;
//import com.nzt.gdx.ashley.components.physx.Box2DBodyComponent;
//import com.nzt.gdx.ashley.components.render.SpriteComponent;
//
///**
// * visitor pattern
// * 
// * @author foccelli
// *
// * @param <C>
// */
//public class VisitorFloor extends VisitorBaseEntity {
//
//	public VisitorFloor(Entity e, Texture texture, Body body) {
//		super("floor", e);
//		e.add(new TransformComponent(e));
//		e.add(new SpriteComponent(e, texture, 200, 10));
//		e.add(new Box2DBodyComponent(e, body));
//	}
//
//	@Override
//	public void doActionWith(VisitorFloor floor) {
//		System.out.println("floor contact with floor");
//
//	}
//
//	@Override
//	public void doActionWith(VisitorPlayer player) {
//		System.out.println("floor contact with player");
//	}
//
//	@Override
//	public void accept(VisitorBaseEntity baseEntity) {
//		baseEntity.doActionWith(this);
//	}
//
//}
