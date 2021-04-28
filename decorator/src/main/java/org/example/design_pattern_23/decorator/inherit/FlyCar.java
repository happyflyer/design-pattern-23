package org.example.design_pattern_23.decorator.inherit;

/**
 * @author lifei
 */
public class FlyCar implements Car {
    @Override
    public void run() {
        System.out.println("可以跑");
    }

    public void fly() {
        System.out.println("可以飞");
    }

    @Override
    public void show() {
        this.run();
        this.fly();
    }
}
