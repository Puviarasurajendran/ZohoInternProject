package javadynamicproxy;

import java.lang.reflect.InvocationHandler;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


interface MyInterface {
    void someMethod();
    void anotherMethod(String arg);
}

class MyInterfaceImpl implements MyInterface {
    public void someMethod() {
        System.out.println("Inside someMethod");
    }

    public void anotherMethod(String arg) {
        System.out.println("Inside anotherMethod with argument: " + arg);
    }
}


class MethodInvocationHandler implements InvocationHandler {
    private final Object target;

    public MethodInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Executing method: " + method.getName());
        return method.invoke(target, args);
    }
}

public class Main {
    public static void main(String[] args) {
    	
        MyInterface realObject = new MyInterfaceImpl();
        
        MyInterface proxy = (MyInterface) Proxy.newProxyInstance(
                MyInterface.class.getClassLoader(),
                new Class[]{MyInterface.class},
                new MethodInvocationHandler(realObject)
        );

        proxy.someMethod();
        proxy.anotherMethod("test");
    }
}

