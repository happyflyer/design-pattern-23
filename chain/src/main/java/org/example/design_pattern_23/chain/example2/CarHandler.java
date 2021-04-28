package org.example.design_pattern_23.chain.example2;

/**
 * @author lifei
 */
public abstract class CarHandler {
    protected CarHandler nextHandler;

    public CarHandler setNextHandler(CarHandler nextHandler) {
        this.nextHandler = nextHandler;
        return this.nextHandler;
    }

    /**
     * handleCar
     */
    public abstract void handleCar();
}
