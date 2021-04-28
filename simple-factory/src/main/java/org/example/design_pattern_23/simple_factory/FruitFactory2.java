package org.example.design_pattern_23.simple_factory;

/**
 * @author lifei
 */
public class FruitFactory2 {
    public static Fruit getApple() {
        return new Apple();
    }

    public static Fruit getBanana() {
        return new Banana();
    }
}
