package org.example.design_pattern_23.template_method;

/**
 * @author lifei
 */
public class MakeJeep extends MakeCar {
    @Override
    public void makeHead() {
        System.out.println("jeep: 组装车头");
    }

    @Override
    public void makeBody() {
        System.out.println("jeep: 组装车身");
    }

    @Override
    public void makeTail() {
        System.out.println("jeep: 组装车尾");
    }
}
