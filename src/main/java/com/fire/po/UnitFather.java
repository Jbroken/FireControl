package com.fire.po;

import java.util.List;

public class UnitFather {
	
	private String type;
	
	private List<UnitType> children;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<UnitType> getChildren() {
		return children;
	}

	public void setChildren(List<UnitType> children) {
		this.children = children;
	}
	
	
	
}
