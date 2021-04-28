package org.example.design_pattern_23.builder;

/**
 * @author lifei
 */
public class PingFangBuilder implements HouseBuilder {
    House house = new House();

    @Override
    public void makeFloor() {
        house.setFloor("平房-->地板");
    }

    @Override
    public void makeWall() {
        house.setWall("平房-->墙");
    }

    @Override
    public void makeCeiling() {
        house.setCeiling("平房-->屋顶");
    }

    @Override
    public House getHouse() {
        return house;
    }
}
