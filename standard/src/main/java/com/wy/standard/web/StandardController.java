package com.wy.standard.web;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wy.standard.model.Standard;
import com.wy.standard.service.StandardService;

@RestController
@EnableAutoConfiguration
public class StandardController {
	
	@Autowired
	StandardService standardService;
	@RequestMapping("/add")
	String list(){
		Standard standard = new Standard();
		standard.setParentId(1);
		standard.setTitle("123");
		standard.setText("123");
		standardService.save(standard);
		return "hello world";
	}
}
