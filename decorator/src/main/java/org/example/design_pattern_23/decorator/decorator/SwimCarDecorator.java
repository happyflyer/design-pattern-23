package org.example.design_pattern_23.decorator.decorator;

/**
 * @author lifei
 */
public class SwimCarDecorator extends CarDecorator {
    public SwimCarDecorator(Car car) {
        super(car);
    }

    @Override
    public void run() {
    }

    @Override
    public void show() {
        this.getCar().show();
        this.swim();
    }

    public void swim() {
        System.out.println("可以游");
    }
}
