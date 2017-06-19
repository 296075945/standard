package com.wy.standard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wy.standard.dao.StandardMapper;
import com.wy.standard.model.Standard;
import com.wy.standard.service.StandardService;

@Service
public class StandardServiceImpl implements StandardService {

	@Autowired
	StandardMapper standardMapper;
	@Override
	public void save(Standard standard) {
		standardMapper.insert(standard);
	}

}
