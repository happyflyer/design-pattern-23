package org.example.design_pattern_23.visitor;

/**
 * @author lifei
 */
public class ParkB implements ParkElement {
    private String name;

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
