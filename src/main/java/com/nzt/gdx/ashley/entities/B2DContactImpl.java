package com.nzt.gdx.ashley.entities;

/**
 * visitor pattern
 * @author foccelli
 *
 * @param <C>
 */
public interface B2DContactImpl<C extends BaseEntity> {

	void accept(C baseEntity);


}
