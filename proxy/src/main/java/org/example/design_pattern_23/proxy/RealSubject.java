package org.example.design_pattern_23.proxy;

/**
 * @author lifei
 */
public class RealSubject implements Subject {
    @Override
    public void sellBook() {
        System.out.println("卖书");
    }
}
