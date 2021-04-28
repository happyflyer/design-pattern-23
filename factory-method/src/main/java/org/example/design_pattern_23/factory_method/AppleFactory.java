package org.example.design_pattern_23.factory_method;

/**
 * @author lifei
 */
public class AppleFactory implements FruitFactory {
    @Override
    public Fruit getFruit() {
        return new Apple();
    }
}
