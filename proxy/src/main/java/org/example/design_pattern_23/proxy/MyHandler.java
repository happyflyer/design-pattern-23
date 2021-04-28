package org.example.design_pattern_23.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author lifei
 */
public class MyHandler implements InvocationHandler {
    private Subject realSubject;

    public void setRealSubject(Subject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        Object result = null;
        daZhe();
        try {
            result = method.invoke(realSubject, args);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        give();
        return result;
    }

    public void daZhe() {
        System.out.println("打折");
    }

    public void give() {
        System.out.println("赠送代金券");
    }
}
