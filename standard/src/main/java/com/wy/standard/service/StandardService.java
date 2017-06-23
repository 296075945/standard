package com.wy.standard.service;

import java.util.Map;

import com.wy.standard.model.Standard;
import com.wy.standard.model.StandardTree;

public interface StandardService {
	void save(Standard standard);
	StandardTree getTree(Map<String, Object> model);
}
