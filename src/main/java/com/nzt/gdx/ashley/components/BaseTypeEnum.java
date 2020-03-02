package com.nzt.gdx.ashley.components;

public enum BaseTypeEnum {
	NONE(0)
	;

	public short mask;

	BaseTypeEnum(int mask) {
		this.mask = (short) mask;
	}
}
