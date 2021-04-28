package org.example.design_pattern_23.simple_factory;

/**
 * @author lifei
 */
public class FruitFactory1 {
    public Fruit getApple() {
        return new Apple();
    }

    public Fruit getBanana() {
        return new Banana();
    }
}
