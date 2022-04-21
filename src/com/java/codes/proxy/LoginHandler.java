package com.java.codes.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class LoginHandler implements InvocationHandler {

    private final Object target;
    private Map<String, Integer> calls = new HashMap<>();

    public LoginHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        calls.merge(methodName, 1, Integer::sum);
        if(methodName.contains("toString")){
            return calls.toString();
        }
        return method.invoke(target, args);
    }

    public static <T> T withLogging(T target, Class<T> clazz) {
        return (T)Proxy.newProxyInstance(clazz.getClassLoader(), new Class<?>[]{clazz}, new LoginHandler(target));
    }
}
/*
Human human = LoginHandler.withLogging(new Person(), Human.class);
human.talk(1);
human.walk(1);
 */
