package org.example.design_pattern_23.template_method;

import org.junit.Test;

public class MakeCarTest {
    @Test
    public void test1() {
        MakeCar bus = new MakeBus();
        bus.makeHead();
        bus.makeBody();
        bus.makeTail();
        System.out.println("==========");
        MakeCar jeep = new MakeJeep();
        jeep.makeHead();
        jeep.makeBody();
        jeep.makeTail();
    }

    @Test
    public void test2() {
        MakeCar bus = new MakeBus();
        bus.make();
        System.out.println("==========");
        MakeCar jeep = new MakeJeep();
        jeep.make();
    }
}
