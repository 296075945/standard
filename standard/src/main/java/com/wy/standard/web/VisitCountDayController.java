package com.wy.standard.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.github.abel533.echarts.Legend;
import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.Tooltip;
import com.github.abel533.echarts.axis.Axis;
import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.code.AxisType;
import com.wy.standard.model.VisitChannel;
import com.wy.standard.model.VisitCountDay;
import com.wy.standard.service.VisitCountDayService;

@RestController
@EnableAutoConfiguration
public class VisitCountDayController {

	@Autowired
	VisitCountDayService visitCountDayService;
//	@RequestMapping("/test")
	@ResponseBody
	JSONPObject test(String callbackparam){
		Option option = new Option();
		Tooltip tt= new Tooltip();
		tt.setShow(true);
		option.setTooltip(tt);
		Legend legend = new Legend();
		List<String> list = new ArrayList<>();
		list.add("销量");
		legend.setData(list);
		option.setLegend(legend);
		List<Axis> xAxis = new  ArrayList<>();
		Axis<CategoryAxis> axix = new CategoryAxis();
		String [] data = {"衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"};
		axix.setData(Arrays.asList(data));
		xAxis.add(axix);
		option.setxAxis(xAxis);
		
		return new  JSONPObject(callbackparam,option);
	}
	@RequestMapping("/test")
	List<VisitChannel> aa(){
		Map<String, Object> modal = new HashMap<String, Object>();
		return visitCountDayService.getVisitCount(modal);
		
	}
}
