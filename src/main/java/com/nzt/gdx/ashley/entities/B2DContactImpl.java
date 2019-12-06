package com.nzt.gdx.ashley.entities;

/**
 * visitor pattern
 * @author foccelli
 *
 * @param <C>
 */
public interface B2DContactImpl<C extends BaseGameObject> {

	void accept(C baseEntity);


}
