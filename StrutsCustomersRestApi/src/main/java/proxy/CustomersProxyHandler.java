package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import restdao.CustomersInterface;

public class CustomersProxyHandler implements InvocationHandler {

	 private final CustomersInterface target;

	    public CustomersProxyHandler(CustomersInterface target) {
	        this.target = target;
	    }

	    @Override
	    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
	        HttpServletRequest request = ServletActionContext.getRequest();
	        String version = request.getRequestURI().contains("/v2/") ? "v2" : "v1";

	        System.out.println("Before proxy execution :"+method.getName());

	        if ("v2".equals(version) && "getTotalCutomers".equals(method.getName())) {
	            Method version2Method = target.getClass().getMethod("getTotalCutomersVersion2", method.getParameterTypes());
	            return version2Method.invoke(target, args);
	        }

	        if ("v2".equals(version) && "getCustomerById".equals(method.getName())) {
	            Method version2Method = target.getClass().getMethod("getCutomerByIDversion2", method.getParameterTypes());
	            return version2Method.invoke(target, args);
	        }

	        Object result = method.invoke(target, args);

	        return result;
	    }
	}
