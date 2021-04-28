package org.example.design_pattern_23.visitor;

/**
 * @author lifei
 */
public interface ParkElement {
    /**
     * 用来接纳访问者
     *
     * @param visitor visitor
     */
    void accept(Visitor visitor);
}
