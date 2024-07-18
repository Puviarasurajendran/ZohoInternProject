package proxy;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import javassist.util.proxy.MethodHandler;
//import javassist.util.proxy.Proxy;
import javassist.util.proxy.ProxyFactory;





public class ProxyFactoryUtil {

	 private static final Map<String, String> versionClassMapping;
	    static {
	        versionClassMapping = new HashMap<>();
	        versionClassMapping.put("v1", "restdao.CustomersDAO");
	        versionClassMapping.put("v2", "restdao.CustomersDAOVersion2");
	    }


	    public static Object createProxy() {
	        HttpServletRequest request = ServletActionContext.getRequest();
	        String uri = request.getRequestURI();
	        String version = uri.contains("/v2/") ? "v2" : "v1";

	        String className = versionClassMapping.get(version);
	        System.out.println("Inside ProxyFactoryUtil className :"+className);
	        if (className == null) {
	        	className= versionClassMapping.get("v1");
	           // throw new IllegalArgumentException("No class mapping found for version: " + version);
	        }
	        Object target;
	        try {
	            Class<?> clazz = Class.forName(className);
	            target = clazz.getDeclaredConstructor().newInstance();
	        } catch (Exception e) {
	            throw new RuntimeException("Failed to instantiate class dynamically", e);
	        }
	        System.out.println("Inside ProxyFactoryUtil target :"+target.getClass().getName());
	        ProxyFactory factory = new ProxyFactory();
	        factory.setSuperclass(target.getClass()); // Use superclass as superclass
	        Class<?> proxyClass = factory.createClass();
	        Object proxy;
	        try {
	            proxy = proxyClass.getDeclaredConstructor().newInstance();
	        } catch (Exception e) {
	            throw new RuntimeException("Failed to instantiate proxy", e);
	        }

	        return proxy;
	    }

	}


