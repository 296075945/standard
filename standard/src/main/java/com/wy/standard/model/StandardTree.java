package com.wy.standard.model;

import java.util.ArrayList;
import java.util.List;

public class StandardTree {
	private Standard standard;
	private List<StandardTree> children = new ArrayList<>(); 
	public Standard getStandard() {
		return standard;
	}
	public void setStandard(Standard standard) {
		this.standard = standard;
	}
	public List<StandardTree> getChildren() {
		return children;
	}
	public void setChildren(List<StandardTree> children) {
		this.children = children;
	}
	
	
}
