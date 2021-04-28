package org.example.design_pattern_23.proxy;

import org.junit.Test;

public class Subject1Test {
    @Test
    public void test() {
        Subject subject = new RealSubject();
        subject.sellBook();
    }
}
