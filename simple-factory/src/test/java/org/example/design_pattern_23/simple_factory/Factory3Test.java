package org.example.design_pattern_23.simple_factory;

import org.junit.Test;

public class Factory3Test {
    @Test
    public void test() {
        try {
            Fruit apple = FruitFactory3.getFruit("apple");
            Fruit banana = FruitFactory3.getFruit("banana");
            assert apple != null;
            apple.get();
            assert banana != null;
            banana.get();
            Fruit orange = FruitFactory3.getFruit("orange");
            assert orange == null;
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}
