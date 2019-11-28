package com.nzt.gdx.ashley.entities.visitor;

import com.nzt.gdx.ashley.entities.B2DContactImpl;

public interface VisitorContactImpl extends B2DContactImpl<VisitorBaseEntity> {
	/**
	 * visitor pattern
	 * @author foccelli
	 *
	 * @param <C>
	 */
	void doActionWith(VisitorFloor floor);

	void doActionWith(VisitorPlayer player);
}
