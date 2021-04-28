package org.example.design_pattern_23.visitor;

/**
 * @author lifei
 */
public class VisitorManager implements Visitor {
    @Override
    public void visit(Park park) {
        System.out.println("管理员：负责检查" + park.getName() + "卫生");
    }

    @Override
    public void visit(ParkA parkA) {
        System.out.println("管理员：负责检查公园" + parkA.getName() + "的卫生");
    }

    @Override
    public void visit(ParkB parkB) {
        System.out.println("管理员：负责检查公园" + parkB.getName() + "的卫生");
    }
}
