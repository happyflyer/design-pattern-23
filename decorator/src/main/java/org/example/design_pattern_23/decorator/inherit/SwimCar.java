package org.example.design_pattern_23.decorator.inherit;

/**
 * @author lifei
 */
public class SwimCar implements Car {
    @Override
    public void run() {
        System.out.println("可以跑");
    }

    public void swim() {
        System.out.println("可以游");
    }

    @Override
    public void show() {
        this.run();
        this.swim();
    }
}
