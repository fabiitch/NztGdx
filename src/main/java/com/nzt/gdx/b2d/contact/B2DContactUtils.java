package com.nzt.gdx.b2d.contact;
//package com.nzt.gdx.b2d.contact;
//
//import com.nzt.gdx.entitys.concept.AbstractBodyGameObject;
//import com.nzt.gdx.entitys.concept.GameObjectType;
//import com.nzt.gdx.entitys.concept.UserDataWrapper;
//
//public class B2DContactUtils<B, E extends B> {
//
//	
//	public static boolean testContact(B type1, B type2, UserDataWrapper userData1,
//			UserDataWrapper userData2) {
//		if (type1 == userData1.bodyGameObject.gameObjectType && type2 == userData2.bodyGameObject.gameObjectType
//				|| type2 == userData1.bodyGameObject.gameObjectType && type1 == userData2.bodyGameObject.gameObjectType) {
//			return true;
//		}
//		return false;
//	}
//	public static boolean testContactSingle(GameObjectType type1, UserDataWrapper userData1,
//			UserDataWrapper userData2) {
//		if (type1 == userData1.bodyGameObject.gameObjectType || type1 == userData2.bodyGameObject.gameObjectType) {
//			return true;
//		}
//		return false;
//	}
//
//	@SuppressWarnings("unchecked")
//	public static <T extends AbstractBodyGameObject> T getType(GameObjectType type, UserDataWrapper userData1,
//			UserDataWrapper userData2) {
//		if (userData1.bodyGameObject.gameObjectType == type) {
//			return (T) userData1.bodyGameObject;
//		} else {
//			return (T) userData2.bodyGameObject;
//		}
//	}
//}
