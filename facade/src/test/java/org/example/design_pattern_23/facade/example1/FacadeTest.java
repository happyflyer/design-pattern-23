package org.example.design_pattern_23.facade.example1;

import org.junit.Test;

public class FacadeTest {
    @Test
    public void test() {
        Facade facade = new Facade();
        facade.doAbc();
        System.out.println("==========");
        facade.doAb();
    }
}
