package org.example.design_pattern_23.bridge.car3;

/**
 * @author lifei
 */
public class Jeep extends Car {
    public Jeep(Engine engine) {
        super(engine);
    }

    @Override
    public void installEngine() {
        System.out.print("Jeep：");
        this.getEngine().displayEngine();
    }
}
