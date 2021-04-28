package org.example.design_pattern_23.factory_method;

import org.junit.Test;

public class FactoryTest {
    @Test
    public void test() {
        FruitFactory appleFactory = new AppleFactory();
        Fruit apple = appleFactory.getFruit();
        apple.get();
        FruitFactory bananaFactory = new BananaFactory();
        Fruit banana = bananaFactory.getFruit();
        banana.get();
    }
}
