package javadynamicproxy;

import javassist.util.proxy.ProxyFactory;

import java.lang.reflect.InvocationTargetException;

import javassist.util.proxy.Proxy;

public class MainProxyFactory {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {

		ProxyFactory factory = new ProxyFactory();

		factory.setSuperclass(HelperInterImpClass.class);

		Class<?> proxyClass = factory.createClass();

		HelperInterface proxy = (HelperInterface) proxyClass.getDeclaredConstructor().newInstance();

		((Proxy) proxy).setHandler(new HelperMethodHandler(new HelperInterImpClass()));

		proxy.method1();

	}

}
