package org.example.design_pattern_23.factory_application.factory_method;

/**
 * @author lifei
 */
public abstract class Operation {
    private double num1;
    private double num2;

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    /**
     * getResult
     *
     * @return double
     */
    public abstract double getResult();
}
