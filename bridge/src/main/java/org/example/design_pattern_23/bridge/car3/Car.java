package org.example.design_pattern_23.bridge.car3;

/**
 * @author lifei
 */
public abstract class Car {
    private final Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }

    public Engine getEngine() {
        return engine;
    }

    /**
     * installEngine
     */
    public abstract void installEngine();
}
