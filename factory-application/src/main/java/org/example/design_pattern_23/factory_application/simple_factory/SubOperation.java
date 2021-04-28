package org.example.design_pattern_23.factory_application.simple_factory;

/**
 * @author lifei
 */
public class SubOperation extends Operation {
    @Override
    public double getResult() {
        return this.getNum1() - this.getNum2();
    }
}
