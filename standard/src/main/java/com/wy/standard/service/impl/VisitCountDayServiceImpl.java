package com.wy.standard.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wy.standard.dao.VisitCountDayDao;
import com.wy.standard.model.VisitChannel;
import com.wy.standard.model.VisitCount;
import com.wy.standard.model.VisitCountDay;
import com.wy.standard.service.VisitCountDayService;

@Service
public class VisitCountDayServiceImpl implements VisitCountDayService {

	@Autowired
	VisitCountDayDao visitCountDayDao;
	
	@Override
	public List<VisitCountDay> getList(Map<String, Object> modal) {
		return visitCountDayDao.getList(modal);
	}

	@Override
	public List<VisitChannel> getVisitCount(Map<String, Object> modal) {
		//list 按countTime 频道 来源  排序
		List<VisitCountDay> list=visitCountDayDao.getList(modal);
		List<VisitChannel> resultList = new ArrayList<>();
		Date nowCountTime = null;
		VisitChannel vc=null;
		Map<String, VisitCount> channelMap = null;
		for(VisitCountDay vcd :list){
			//如果不是当前countTime 新建一行
			if(nowCountTime==null||vcd.getCountTime().getTime()!=nowCountTime.getTime()){
				vc=new VisitChannel();
				vc.setDate(vcd.getCountTime());
				resultList.add(vc);
				channelMap=new HashMap<String, VisitCount>();
				vc.setChannelMap(channelMap);
				nowCountTime=vcd.getCountTime();
			}
			VisitCount nowVC=channelMap.get(vcd.getChannel());
			if(nowVC==null){
				nowVC = new VisitCount();
				channelMap.put(vcd.getChannel(), nowVC);
			}
			if(vcd.getSource()==1){
				nowVC.setPc(vcd);
			}else{
				nowVC.setM(vcd);
			}
			
		}
		return resultList;
	}

}
