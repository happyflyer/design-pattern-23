package org.example.design_pattern_23.abstract_factory;

import org.junit.Test;

public class FactoryTest {
    @Test
    public void test() {
        FruitFactory northFruitFactory = new NorthFruitFactory();
        Fruit apple1 = northFruitFactory.getApple();
        apple1.get();
        Fruit banana1 = northFruitFactory.getBanana();
        banana1.get();
        FruitFactory southFruitFactory = new SouthFruitFactory();
        Fruit apple2 = southFruitFactory.getApple();
        apple2.get();
        Fruit banana2 = southFruitFactory.getBanana();
        banana2.get();
    }

    @Test
    public void test2() {
        FruitFactory wenshiFruitFactory = new WenshiFruitFactory();
        Fruit apple3 = wenshiFruitFactory.getApple();
        apple3.get();
        Fruit banana3 = wenshiFruitFactory.getBanana();
        banana3.get();
    }
}
