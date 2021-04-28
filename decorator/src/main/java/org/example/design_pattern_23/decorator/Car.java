package org.example.design_pattern_23.decorator;

/**
 * @author lifei
 */
public class Car {
    public void run() {
        System.out.println("可以跑");
    }

    public void fly() {
        System.out.println("可以飞");
    }

    public void swim() {
        System.out.println("可以游");
    }

    public void show() {
        System.out.println("拥有的功能");
        this.run();
        this.fly();
        this.swim();
    }
}
