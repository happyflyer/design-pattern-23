package org.example.design_pattern_23.chain.example2;

import org.junit.Test;

public class CarHandlerTest {
    @Test
    public void test() {
        CarHeadHandler head = new CarHeadHandler();
        CarBodyHandler body = new CarBodyHandler();
        CarTailHandler tail = new CarTailHandler();
        head.setNextHandler(body);
        body.setNextHandler(tail);
        head.handleCar();
        System.out.println("==========");
        body.setNextHandler(head);
        head.setNextHandler(tail);
        body.handleCar();
        System.out.println("==========");
        body.setNextHandler(head).setNextHandler(tail);
        body.handleCar();
    }
}
