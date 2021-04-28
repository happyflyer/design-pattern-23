package org.example.design_pattern_23.bridge.car3;

import org.junit.Test;

public class CarTest {
    @Test
    public void test1() {
        Engine engine2000 = new Engine2000();
        Engine engine2200 = new Engine2200();
        Car bus1 = new Bus(engine2000);
        bus1.installEngine();
        Car bus2 = new Bus(engine2200);
        bus2.installEngine();
        Car jeep1 = new Jeep(engine2000);
        jeep1.installEngine();
        Car jeep2 = new Jeep(engine2200);
        jeep2.installEngine();
    }

    @Test
    public void test2() {
        Engine engine2000 = new Engine2000();
        Engine engine2200 = new Engine2200();
        Car truck1 = new Truck(engine2000);
        truck1.installEngine();
        Car truck2 = new Truck(engine2200);
        truck2.installEngine();
    }
}
