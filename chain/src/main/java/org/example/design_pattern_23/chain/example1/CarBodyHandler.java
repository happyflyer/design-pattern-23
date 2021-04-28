package org.example.design_pattern_23.chain.example1;

/**
 * @author lifei
 */
public class CarBodyHandler extends CarHandler {
    @Override
    public void handleCar() {
        System.out.println("组装车身");
    }
}
