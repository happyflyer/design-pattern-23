package org.example.design_pattern_23.visitor;

import org.junit.Test;

public class VisitorTest {
    @Test
    public void test() {
        Park park = new Park();
        park.setName("越秀公园");
        Visitor visitorA = new VisitorA();
        park.accept(visitorA);
        Visitor visitorB = new VisitorB();
        park.accept(visitorB);
        Visitor visitorManager = new VisitorManager();
        park.accept(visitorManager);
    }
}
