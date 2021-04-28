package org.example.design_pattern_23.simple_factory;

import org.junit.Test;

public class ClassTest {
    @Test
    public void test() {
        Apple apple = new Apple();
        Banana banana = new Banana();
        apple.get();
        banana.get();
    }
}
