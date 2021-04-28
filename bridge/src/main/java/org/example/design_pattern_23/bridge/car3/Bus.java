package org.example.design_pattern_23.bridge.car3;

/**
 * @author lifei
 */
public class Bus extends Car {
    public Bus(Engine engine) {
        super(engine);
    }

    @Override
    public void installEngine() {
        System.out.print("Bus：");
        this.getEngine().displayEngine();
    }
}
