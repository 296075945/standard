package com.wy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.wy.common.datasource.DynamicDataSourceRegister;


/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableScheduling
@Import({ DynamicDataSourceRegister.class })
public class StandardApp 
{
	public static void main(String[] args) {
		SpringApplication.run(StandardApp.class, args);
	}
}
