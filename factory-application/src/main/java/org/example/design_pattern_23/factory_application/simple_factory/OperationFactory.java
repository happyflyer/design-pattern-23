package org.example.design_pattern_23.factory_application.simple_factory;

/**
 * @author lifei
 */
public class OperationFactory {
    public static Operation getOperation(String operator) {
        if ("+".equals(operator)) {
            return new AddOperation();
        } else if ("-".equals(operator)) {
            return new SubOperation();
        } else if ("*".equals(operator)) {
            return new MultiOperation();
        } else if ("/".equals(operator)) {
            return new DivOperation();
        } else {
            return null;
        }
    }
}
