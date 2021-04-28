package org.example.design_pattern_23.simple_factory;

import org.junit.Test;

public class Factory1Test {
    @Test
    public void test() {
        Fruit apple = new FruitFactory1().getApple();
        Fruit banana = new FruitFactory1().getBanana();
        apple.get();
        banana.get();
    }
}
