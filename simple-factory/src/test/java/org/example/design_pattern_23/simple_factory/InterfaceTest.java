package org.example.design_pattern_23.simple_factory;

import org.junit.Test;

public class InterfaceTest {
    @Test
    public void test() {
        Fruit apple = new Apple();
        Fruit banana = new Banana();
        apple.get();
        banana.get();
    }
}
