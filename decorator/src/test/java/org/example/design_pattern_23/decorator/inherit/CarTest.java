package org.example.design_pattern_23.decorator.inherit;

import org.junit.Test;

public class CarTest {
    @Test
    public void test() {
        Car runCar = new RunCar();
        runCar.show();
        System.out.println("==========");
        Car flyCar = new FlyCar();
        flyCar.show();
        System.out.println("==========");
        Car swimCar = new SwimCar();
        swimCar.show();
    }
}
