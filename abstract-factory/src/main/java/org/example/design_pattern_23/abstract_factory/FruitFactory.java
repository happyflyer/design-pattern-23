package org.example.design_pattern_23.abstract_factory;

/**
 * @author lifei
 */
public interface FruitFactory {
    /**
     * getApple
     *
     * @return Fruit
     */
    Fruit getApple();

    /**
     * getBanana
     *
     * @return Fruit
     */
    Fruit getBanana();
}
