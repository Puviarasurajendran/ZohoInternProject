package javadynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class HelperInvocationHandler implements InvocationHandler {
	
	private final HelperInterface target ;
	

	public HelperInvocationHandler(HelperInterface target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
	    if (method.getName().equals("method1")) {
	    	
            System.out.println("Executing method: method1");
            System.out.println("Switching to method2");
            
            target.method2(); 
            
        } else {
            System.out.println("Executing method: " + method.getName());
            method.invoke(target, args);
        }
        return null;
	}

}
