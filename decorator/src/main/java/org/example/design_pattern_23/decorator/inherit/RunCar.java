package org.example.design_pattern_23.decorator.inherit;

/**
 * @author lifei
 */
public class RunCar implements Car {
    @Override
    public void run() {
        System.out.println("可以跑");
    }

    @Override
    public void show() {
        this.run();
    }
}
