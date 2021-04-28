package org.example.design_pattern_23.abstract_factory;

/**
 * @author lifei
 */
public class SouthFruitFactory implements FruitFactory {
    @Override
    public Fruit getApple() {
        return new SouthBanana();
    }

    @Override
    public Fruit getBanana() {
        return new SouthBanana();
    }
}
