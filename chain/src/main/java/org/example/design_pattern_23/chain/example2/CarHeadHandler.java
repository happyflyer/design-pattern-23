package org.example.design_pattern_23.chain.example2;

/**
 * @author lifei
 */
public class CarHeadHandler extends CarHandler {
    @Override
    public void handleCar() {
        System.out.println("组装车头");
        if (this.nextHandler != null) {
            this.nextHandler.handleCar();
        }
    }
}
