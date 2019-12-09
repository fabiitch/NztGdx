//package com.nzt.gdx.ashley.entities.visitor;
//
//import com.badlogic.ashley.core.Entity;
//import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.physics.box2d.Body;
//import com.nzt.gdx.ashley.components.TransformComponent;
//import com.nzt.gdx.ashley.components.physx.Box2DBodyComponent;
//import com.nzt.gdx.ashley.components.render.SpriteComponent;
//
//public class VisitorPlayer extends VisitorBaseEntity {
//
//	public VisitorPlayer(Entity e, Texture texture, Body body) {
//		super("player", e);
//		e.add(new TransformComponent(e));
//		e.add(new SpriteComponent(e, texture, 200));
//		e.add(new Box2DBodyComponent(e, body));
//	}
//
//	@Override
//	public void accept(VisitorBaseEntity baseEntity) {
//		baseEntity.doActionWith(this);
//	}
//
//	@Override
//	public void doActionWith(VisitorPlayer floor) {
//		System.out.println("player contact with floor");
//
//	}
//
//	@Override
//	public void doActionWith(VisitorFloor floor) {
//		System.out.println("player contact with floor");
//
//	}
//
//}