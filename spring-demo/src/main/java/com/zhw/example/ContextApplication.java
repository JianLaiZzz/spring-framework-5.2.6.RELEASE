package com.zhw.example;

import com.zhw.example.config.ContextConfig;
import com.zhw.example.service.IUserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ContextApplication {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				ContextConfig.class
		);
		IUserService bean = context.getBean(IUserService.class);
		System.out.println(bean);
	}
}
