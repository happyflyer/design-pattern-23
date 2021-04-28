package org.example.design_pattern_23.proxy;

import org.junit.Test;

import java.lang.reflect.Proxy;

public class HandlerTest {
    @Test
    public void test() {
        Subject realSubject = new RealSubject();
        MyHandler handler = new MyHandler();
        handler.setRealSubject(realSubject);
        Subject proxySubject = (Subject) Proxy.newProxyInstance(
                RealSubject.class.getClassLoader(),
                realSubject.getClass().getInterfaces(),
                handler
        );
        proxySubject.sellBook();
    }
}
