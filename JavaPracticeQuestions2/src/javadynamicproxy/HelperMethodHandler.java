package javadynamicproxy;

import java.lang.reflect.Method;

import javassist.util.proxy.MethodHandler;

public class HelperMethodHandler implements MethodHandler{

	private HelperInterface target;
	
	
	public HelperMethodHandler(HelperInterface target) {

		this.target = target;
	}


	@Override
	public Object invoke(Object arg0, Method arg1, Method arg2, Object[] arg3) throws Throwable {
      
        System.out.println("Proxy is performing pre-action.");
        
        Object result = arg1.invoke(target, arg3);
        
        System.out.println("Proxy is performing post-action.");
        
        return result;

	}

}
