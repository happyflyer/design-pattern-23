package org.example.design_pattern_23.proxy;

/**
 * @author lifei
 */
public class ProxySubject implements Subject {
    private Subject realSubject;

    @Override
    public void sellBook() {
        this.daZhe();
        if (this.realSubject == null) {
            this.realSubject = new RealSubject();
        }
        this.realSubject.sellBook();
        this.give();
    }

    public void daZhe() {
        System.out.println("打折");
    }

    public void give() {
        System.out.println("赠送代金券");
    }
}
