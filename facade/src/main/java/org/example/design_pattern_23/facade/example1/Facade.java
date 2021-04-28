package org.example.design_pattern_23.facade.example1;

/**
 * @author lifei
 */
public class Facade {
    private final SystemA systemA;
    private final SystemB systemB;
    private final SystemC systemC;

    public Facade() {
        this.systemA = new SystemA();
        this.systemB = new SystemB();
        this.systemC = new SystemC();
    }

    public void doAbc() {
        this.systemA.doSomething();
        this.systemB.doSomething();
        this.systemC.doSomething();
    }

    public void doAb() {
        this.systemA.doSomething();
        this.systemB.doSomething();
    }
}
