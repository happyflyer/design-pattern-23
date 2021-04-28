package org.example.design_pattern_23.strategy;

import org.junit.Test;

public class StrategyTest {
    @Test
    public void test() {
        Strategy strategy = new Md5Strategy();
        strategy.encrypt();
    }
}
