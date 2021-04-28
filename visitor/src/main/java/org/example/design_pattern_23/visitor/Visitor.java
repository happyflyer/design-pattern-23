package org.example.design_pattern_23.visitor;

/**
 * @author lifei
 */
public interface Visitor {
    /**
     * visit
     *
     * @param park park
     */
    void visit(Park park);

    /**
     * visit
     *
     * @param parkA parkB
     */
    void visit(ParkA parkA);

    /**
     * visit
     *
     * @param parkB parkB
     */
    void visit(ParkB parkB);
}
