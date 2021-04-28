package org.example.design_pattern_23.adapter;

/**
 * @author lifei
 */
public class Adapter1 extends Current {
    public void use18V() {
        this.use220V();
        System.out.println("输入220V，输出18V");
    }
}
