package org.example.reflection.advance;
import java.lang.reflect.*;

interface Greeting {
    void sayHello(String name);
}

class GreetingImpl implements Greeting {
    @Override
    public void sayHello(String name) {
        System.out.println("Hello, " + name + "!");
    }
}

class LoggingProxy implements InvocationHandler {

    private final Object target;

    //Constructor to initialize the target object
    public LoggingProxy(Object target) {
        this.target = target;
    }

    //This method is called whenever a method on the proxy is invoked
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("Method " + method.getName() + " is being invoked");

        //invoke the real method on the target object
        return method.invoke(target, args);
    }
}

public class CustomLogging{
    public static void main(String[] args) {
        //Create a real Greeting object
        Greeting greeting = new GreetingImpl();

        //Create a logging proxy for the Greeting interface
        Greeting proxyInstance = (Greeting) Proxy.newProxyInstance(
                Greeting.class.getClassLoader(),
                new Class<?>[] { Greeting.class },
                new LoggingProxy(greeting)
        );

        //Use the proxy instance to call the method
        proxyInstance.sayHello("John");
    }
}
