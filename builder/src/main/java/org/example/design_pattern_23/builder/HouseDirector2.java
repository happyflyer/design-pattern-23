package org.example.design_pattern_23.builder;

/**
 * @author lifei
 */
public class HouseDirector2 {
    public void makeHouse(HouseBuilder builder) {
        builder.makeFloor();
        builder.makeWall();
        builder.makeCeiling();
    }
}
