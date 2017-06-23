package com.wy.standard.web;



import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.wy.standard.model.Standard;
import com.wy.standard.model.StandardTree;
import com.wy.standard.service.StandardService;

@RestController
@EnableAutoConfiguration
public class StandardController {
	
	@Autowired
	StandardService standardService;
	@RequestMapping("/add")
	String list(@ModelAttribute Standard standard){
		standardService.save(standard);
		return "hello world";
	}
	@RequestMapping("/tree")
	@ResponseBody
	JSONPObject tree(String callbackparam){
		Map<String, Object> modal = new HashMap<String, Object>();
		return new  JSONPObject(callbackparam,standardService.getTree(modal));
	}
}
