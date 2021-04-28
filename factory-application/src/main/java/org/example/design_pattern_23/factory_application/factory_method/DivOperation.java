package org.example.design_pattern_23.factory_application.factory_method;

/**
 * @author lifei
 */
public class DivOperation extends Operation {
    @Override
    public double getResult() {
        return this.getNum1() / this.getNum2();
    }
}
