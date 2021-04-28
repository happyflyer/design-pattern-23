package org.example.design_pattern_23.bridge.car1;

import org.junit.Test;

public class CarTest {
    @Test
    public void test() {
        Car bus2000 = new Bus2000();
        bus2000.installEngine();
        Car bus2200 = new Bus2200();
        bus2200.installEngine();
        Car jeep2000 = new Jeep2000();
        jeep2000.installEngine();
        Car jeep2200 = new Jeep2200();
        jeep2200.installEngine();
    }
}
