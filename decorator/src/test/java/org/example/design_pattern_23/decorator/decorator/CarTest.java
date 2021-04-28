package org.example.design_pattern_23.decorator.decorator;

import org.junit.Test;

public class CarTest {
    @Test
    public void test1() {
        Car car = new RunCar();
        Car flyCar = new FlyCarDecorator(car);
        flyCar.show();
    }

    @Test
    public void test2() {
        Car car = new RunCar();
        Car flyCar = new FlyCarDecorator(car);
        flyCar.show();
        System.out.println("==========");
        Car swimCar = new SwimCarDecorator(car);
        swimCar.show();
    }

    @Test
    public void test3() {
        Car car = new RunCar();
        car.show();
        System.out.println("==========");
        Car flyCar = new FlyCarDecorator(car);
        flyCar.show();
        System.out.println("==========");
        Car flySwimCar = new SwimCarDecorator(flyCar);
        flySwimCar.show();
    }
}
