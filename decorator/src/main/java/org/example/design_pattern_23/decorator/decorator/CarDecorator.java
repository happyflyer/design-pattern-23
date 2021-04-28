package org.example.design_pattern_23.decorator.decorator;

/**
 * @author lifei
 */
public abstract class CarDecorator implements Car {
    private final Car car;

    public CarDecorator(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }

    /**
     * run
     */
    @Override
    public abstract void run();

    /**
     * show
     */
    @Override
    public abstract void show();
}
