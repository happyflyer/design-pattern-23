package org.example.design_pattern_23.bridge.car2;

/**
 * @author lifei
 */
public class Bus implements Car {
    @Override
    public void install2000Engine() {
        System.out.println("给Bus安装2000cc发动机");
    }

    @Override
    public void install2200Engine() {
        System.out.println("给Bus安装2200cc发动机");
    }

    @Override
    public void install2400Engine() {
        System.out.println("给Bus安装2400cc发动机");
    }
}
