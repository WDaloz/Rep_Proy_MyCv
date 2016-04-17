package com.daloz.mycv.managedbean.helper;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

public class SpringUtil
{
	//Devuelve cualquier clase sin necesida
	//de pasarlo como parametro, solo devuelve.
	@SuppressWarnings("unchecked")
	public static <T> T getSpringBean(String beanName)
	{
		WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
		T myT = (T)webApplicationContext.getBean(beanName);
		return myT;
	}
}
