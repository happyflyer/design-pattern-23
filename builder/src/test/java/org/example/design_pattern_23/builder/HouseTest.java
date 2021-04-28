package org.example.design_pattern_23.builder;

import org.junit.Test;

public class HouseTest {
    @Test
    public void test() {
        House house = new House();
        house.setFloor("地板");
        house.setWall("墙");
        house.setCeiling("屋顶");
        System.out.println(house);
    }
}
