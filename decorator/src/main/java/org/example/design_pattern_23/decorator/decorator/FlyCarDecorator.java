package org.example.design_pattern_23.decorator.decorator;

/**
 * @author lifei
 */
public class FlyCarDecorator extends CarDecorator {
    public FlyCarDecorator(Car car) {
        super(car);
    }

    @Override
    public void run() {
    }

    @Override
    public void show() {
        this.getCar().show();
        this.fly();
    }

    public void fly() {
        System.out.println("可以飞");
    }
}
