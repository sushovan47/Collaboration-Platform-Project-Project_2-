package com.coll.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{

	@Override
	protected Class<?>[] getRootConfigClasses() 
	{
		System.out.println("====Get RootConfigClass Generated Successfully====");
		return new Class[] {WebResolver.class,DBConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses()
	{
		System.out.println("====Get ServletConfigClass Generated Successfully====");
		return null;
	}

	@Override
	protected String[] getServletMappings() 
	{
		System.out.println("=====Get ServletMappingConfigClass Generated Successfully====");
		return new String[] {"/"};
	}

}
