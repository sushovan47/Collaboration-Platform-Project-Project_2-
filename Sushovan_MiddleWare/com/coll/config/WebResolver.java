package com.coll.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.coll")
public class WebResolver 
{
	@Bean
	public InternalResourceViewResolver getViewResolver()
	{
		InternalResourceViewResolver resolver=new InternalResourceViewResolver();
		
		resolver.setPrefix("/WEB-INF/jsp");
		resolver.setSuffix(".jsp");
		System.out.println("=====InternalViewResolver Object  Works Fine====");
		System.out.println("*******Collaboration Project MiddleWare Works Fine******");
		return resolver;
	}
}
