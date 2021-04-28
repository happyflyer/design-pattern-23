package org.example.design_pattern_23.builder;

/**
 * @author lifei
 */
public class GongYuBuilder implements HouseBuilder {
    House house = new House();

    @Override
    public void makeFloor() {
        house.setFloor("公寓-->地板");
    }

    @Override
    public void makeWall() {
        house.setWall("公寓-->墙");
    }

    @Override
    public void makeCeiling() {
        house.setCeiling("公寓-->屋顶");
    }

    @Override
    public House getHouse() {
        return house;
    }
}
