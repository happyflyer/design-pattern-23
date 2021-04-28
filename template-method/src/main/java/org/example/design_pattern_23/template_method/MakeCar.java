package org.example.design_pattern_23.template_method;

/**
 * @author lifei
 */
public abstract class MakeCar {
    /**
     * makeHead
     */
    public abstract void makeHead();

    /**
     * makeBody
     */
    public abstract void makeBody();

    /**
     * makeTail
     */
    public abstract void makeTail();

    public void make() {
        this.makeHead();
        this.makeBody();
        this.makeTail();
    }
}
