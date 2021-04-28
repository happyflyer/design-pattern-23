package org.example.design_pattern_23.simple_factory;

/**
 * @author lifei
 */
public class FruitFactory3 {
    public static Fruit getFruit(String type)
            throws IllegalAccessException, InstantiationException {
        if ("apple".equalsIgnoreCase(type)) {
            return Apple.class.newInstance();
        } else if ("banana".equalsIgnoreCase(type)) {
            return Banana.class.newInstance();
        } else {
            System.out.println("找不到响应的实例化类");
            return null;
        }
    }
}
