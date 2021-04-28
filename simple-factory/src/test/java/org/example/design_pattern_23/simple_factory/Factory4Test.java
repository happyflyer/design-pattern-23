package org.example.design_pattern_23.simple_factory;

import org.junit.Test;

public class Factory4Test {
    @Test
    public void test() {
        try {
            Fruit apple = FruitFactory4.getFruit("org.example.design_pattern_23.simple_factory.Apple");
            Fruit banana = FruitFactory4.getFruit("org.example.design_pattern_23.simple_factory.Banana");
            apple.get();
            banana.get();
            Fruit orange = FruitFactory4.getFruit("org.example.design_pattern_23.simple_factory.Orange");
        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
