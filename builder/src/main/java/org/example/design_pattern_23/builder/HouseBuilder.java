package org.example.design_pattern_23.builder;

/**
 * @author lifei
 */
public interface HouseBuilder {
    /**
     * makeFloor
     */
    void makeFloor();

    /**
     * makeWall
     */
    void makeWall();

    /**
     * makeCeiling
     */
    void makeCeiling();

    /**
     * getHouse
     *
     * @return House
     */
    House getHouse();
}
