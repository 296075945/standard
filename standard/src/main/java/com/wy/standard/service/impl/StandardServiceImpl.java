package com.wy.standard.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wy.common.datasource.DataSource;
import com.wy.common.datasource.TargetDataSource;
import com.wy.standard.dao.StandardMapper;
import com.wy.standard.model.Standard;
import com.wy.standard.model.StandardTree;
import com.wy.standard.service.StandardService;

@Service
public class StandardServiceImpl implements StandardService {

	@Autowired
	StandardMapper standardMapper;
	@Override
	public void save(Standard standard) {
		standardMapper.insert(standard);
	}
	@Override
	@TargetDataSource(name=DataSource.TEST)
	public StandardTree getTree(Map<String, Object> modal) {
		List<Standard> list = standardMapper.getList(modal);
		//StandardTree standardTree = new StandardTree();
		Map<Integer, StandardTree> map =new HashMap<Integer, StandardTree>();
		StandardTree root = null;
		for(Standard s :list){
			StandardTree st = new StandardTree();
			st.setStandard(s);
			map.put(s.getId(), st);
		}
		for(Map.Entry<Integer, StandardTree> entry :map.entrySet()){
			
			Integer id = entry.getKey();
			StandardTree st = entry.getValue();
			if(st.getStandard().getParentId()==null){
				root =st;
			}else{
				map.get(st.getStandard().getParentId()).getChildren().add(st);
			}
		}
		return root;
	}

}
