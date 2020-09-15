package com.yueqian.spBootMybatis;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.Vector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ResourceBundleMessageSource;

@SpringBootApplication
@Import({MyBatisConfiguration.class})
public class SpBootMybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpBootMybatisApplication.class, args);
		
		ArrayList list = null;
		Vector vec = null;
		LinkedList<String> linkList = null;
		
		TreeSet set = null;
	}
	
	@Bean("messageSource")
	public ResourceBundleMessageSource getMessage() {
		ResourceBundleMessageSource message = new ResourceBundleMessageSource();
		message.setBasename("msg");
		return message;
	}

}
