package org.example.design_pattern_23.chain.example1;

import org.junit.Test;

public class CarHandlerTest {
    @Test
    public void test() {
        CarHeadHandler head = new CarHeadHandler();
        CarBodyHandler body = new CarBodyHandler();
        CarTailHandler tail = new CarTailHandler();
        head.handleCar();
        body.handleCar();
        tail.handleCar();
    }
}
