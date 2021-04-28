package org.example.design_pattern_23.facade.example1;

import org.junit.Test;

public class SystemTest {
    @Test
    public void test() {
        SystemA systemA = new SystemA();
        systemA.doSomething();
        SystemB systemB = new SystemB();
        systemB.doSomething();
        SystemC systemC = new SystemC();
        systemC.doSomething();
    }
}
