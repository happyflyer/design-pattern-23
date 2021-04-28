package org.example.design_pattern_23.adapter;

/**
 * @author lifei
 */
public class Adapter2 {
    private final Current current;

    public Adapter2(Current current) {
        this.current = current;
    }

    public void use18V() {
        this.current.use220V();
        System.out.println("输入220V，输出18V");
    }
}
