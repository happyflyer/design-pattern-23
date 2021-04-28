package org.example.design_pattern_23.builder;

/**
 * @author lifei
 */
public class HouseDirector1 {
    private final HouseBuilder builder;

    public HouseDirector1(HouseBuilder builder) {
        this.builder = builder;
    }

    public void makeHouse() {
        builder.makeFloor();
        builder.makeWall();
        builder.makeCeiling();
    }
}
