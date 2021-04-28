package org.example.design_pattern_23.bridge.car2;

import org.junit.Test;

public class CarTest {
    @Test
    public void test() {
        Car bus = new Bus();
        bus.install2000Engine();
        bus.install2200Engine();
        bus.install2400Engine();
    }
}
