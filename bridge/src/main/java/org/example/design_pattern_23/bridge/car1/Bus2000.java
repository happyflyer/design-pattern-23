package org.example.design_pattern_23.bridge.car1;

/**
 * @author lifei
 */
public class Bus2000 extends Bus {
    @Override
    public void installEngine() {
        System.out.println("给Bus安装2000cc发动机");
    }
}
