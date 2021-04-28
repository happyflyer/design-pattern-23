package org.example.design_pattern_23.abstract_factory;

/**
 * @author lifei
 */
public class WenshiFruitFactory implements FruitFactory {
    @Override
    public Fruit getApple() {
        return new WenshiApple();
    }

    @Override
    public Fruit getBanana() {
        return new WenshiBanana();
    }
}
