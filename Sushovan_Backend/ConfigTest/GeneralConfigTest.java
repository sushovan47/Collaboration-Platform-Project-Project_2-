package com.coll.ConfigTest;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class GeneralConfigTest 
{

	public static void main(String[] args) 
	{
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		context.scan("com.coll");
		context.refresh();
		
	}

}
