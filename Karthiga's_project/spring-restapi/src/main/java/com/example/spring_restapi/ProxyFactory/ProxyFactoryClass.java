package com.example.spring_restapi.ProxyFactory;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

import com.example.spring_restapi.v1.handler.CrudHandler;

public class ProxyFactoryClass {

	private static final String LATEST_VERSION = "V2";
	
	public static String currentVersion;
	
	public static Class<?> clazz;

	public static CrudHandler createProxy(ApplicationContext context, String version, String service)
			throws BeansException {
		String serviceName = service+"Handler"+ version.toUpperCase();
		try {
			ProxyFactory factory = new ProxyFactory();
			factory.setTarget(context.getBean(serviceName));
			currentVersion=version;
			clazz = Class.forName("com.example.spring_restapi."+currentVersion+".model."+service.toUpperCase().charAt(0)+service.substring(1));
			return (CrudHandler) factory.getProxy();
		} catch (BeansException | ClassNotFoundException e) {

			try {
				ProxyFactory factory = new ProxyFactory();
				factory.setTarget(context.getBean(service+"Handler"+LATEST_VERSION));
				currentVersion=LATEST_VERSION.toLowerCase();
				clazz = Class.forName("com.example.spring_restapi."+currentVersion+".model."+service.toUpperCase().charAt(0)+service.substring(1));
				return (CrudHandler) factory.getProxy();
			} catch (BeansException | ClassNotFoundException ex) {
				throw new RuntimeException("Default service class not found", ex);
			}

		}
	}
	
}
