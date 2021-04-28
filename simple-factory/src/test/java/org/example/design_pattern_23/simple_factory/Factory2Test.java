package org.example.design_pattern_23.simple_factory;

import org.junit.Test;

public class Factory2Test {
    @Test
    public void test() {
        Fruit apple = FruitFactory2.getApple();
        Fruit banana = FruitFactory2.getBanana();
        apple.get();
        banana.get();
    }
}
