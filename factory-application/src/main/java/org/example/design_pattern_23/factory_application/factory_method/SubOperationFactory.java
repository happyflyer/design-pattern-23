package org.example.design_pattern_23.factory_application.factory_method;

/**
 * @author lifei
 */
public class SubOperationFactory implements OperationFactory {
    @Override
    public Operation getOperation() {
        return new SubOperation();
    }
}
