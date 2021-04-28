package org.example.design_pattern_23.factory_application.factory_method;

/**
 * @author lifei
 */
public class AddOperationFactory implements OperationFactory {
    @Override
    public Operation getOperation() {
        return new AddOperation();
    }
}
