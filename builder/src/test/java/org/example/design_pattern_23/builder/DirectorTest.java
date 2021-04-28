package org.example.design_pattern_23.builder;

import org.junit.Test;

public class DirectorTest {
    @Test
    public void test1() {
        HouseBuilder builder = new PingFangBuilder();
        HouseDirector1 director = new HouseDirector1(builder);
        director.makeHouse();
        House house = builder.getHouse();
        System.out.println(house);
    }

    @Test
    public void test2() {
        HouseBuilder builder1 = new PingFangBuilder();
        HouseDirector1 director1 = new HouseDirector1(builder1);
        director1.makeHouse();
        House house = builder1.getHouse();
        System.out.println(house);
        HouseBuilder builder2 = new GongYuBuilder();
        HouseDirector1 director2 = new HouseDirector1(builder2);
        director2.makeHouse();
        House house2 = builder2.getHouse();
        System.out.println(house2);
    }

    @Test
    public void test3() {
        HouseBuilder builder1 = new PingFangBuilder();
        HouseDirector2 director1 = new HouseDirector2();
        director1.makeHouse(builder1);
        House house = builder1.getHouse();
        System.out.println(house);
        HouseBuilder builder2 = new GongYuBuilder();
        HouseDirector2 director2 = new HouseDirector2();
        director2.makeHouse(builder2);
        House house2 = builder2.getHouse();
        System.out.println(house2);
    }
}
