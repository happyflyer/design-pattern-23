package org.example.design_pattern_23.builder;

import org.junit.Test;

public class BuilderTest {
    @Test
    public void test() {
        HouseBuilder builder = new PingFangBuilder();
        builder.makeFloor();
        builder.makeWall();
        builder.makeCeiling();
        House house = builder.getHouse();
        System.out.println(house);
    }
}
