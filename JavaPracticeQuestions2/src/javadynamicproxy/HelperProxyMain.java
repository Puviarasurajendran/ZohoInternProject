package javadynamicproxy;

import java.lang.reflect.Proxy;

public class HelperProxyMain {
	
	public static void main(String[] args) {
		
		HelperInterface objInter= new HelperInterImpClass();
		
		HelperInterface proxy= (HelperInterface) Proxy.newProxyInstance(HelperInterface.class.getClassLoader(), 
				new Class[]{HelperInterface.class},new HelperInvocationHandler(objInter));
		
		proxy.method1();
		proxy.method2(); 
		
	}

}
