package org.example.design_pattern_23.visitor;

/**
 * @author lifei
 */
public class Park implements ParkElement {
    private String name;
    private final ParkA parkA;
    private final ParkB parkB;

    public Park() {
        this.parkA = new ParkA();
        this.parkB = new ParkB();
        this.parkA.setName("A");
        this.parkB.setName("B");
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
        this.parkA.accept(visitor);
        this.parkB.accept(visitor);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
