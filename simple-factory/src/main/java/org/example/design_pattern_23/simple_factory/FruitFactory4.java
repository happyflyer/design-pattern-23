package org.example.design_pattern_23.simple_factory;

/**
 * @author lifei
 */
public class FruitFactory4 {
    public static Fruit getFruit(String type) throws ClassNotFoundException,
            IllegalAccessException, InstantiationException {
        Class fruit = Class.forName(type);
        return (Fruit) fruit.newInstance();
    }
}
