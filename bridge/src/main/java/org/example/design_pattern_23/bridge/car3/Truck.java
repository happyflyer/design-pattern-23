package org.example.design_pattern_23.bridge.car3;

/**
 * @author lifei
 */
public class Truck extends Car {
    public Truck(Engine engine) {
        super(engine);
    }

    @Override
    public void installEngine() {
        System.out.print("Truck：");
        this.getEngine().displayEngine();
    }
}
