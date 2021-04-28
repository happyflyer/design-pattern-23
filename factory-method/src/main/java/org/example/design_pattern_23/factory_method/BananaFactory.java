package org.example.design_pattern_23.factory_method;

/**
 * @author lifei
 */
public class BananaFactory implements FruitFactory {
    @Override
    public Fruit getFruit() {
        return new Banana();
    }
}
