package org.example.design_pattern_23.visitor;

/**
 * @author lifei
 */
public class VisitorA implements Visitor {
    @Override
    public void visit(Park park) {
    }

    @Override
    public void visit(ParkA parkA) {
        System.out.println("清洁工A：完成公园" + parkA.getName() + "的卫生");
    }

    @Override
    public void visit(ParkB parkB) {
    }
}
