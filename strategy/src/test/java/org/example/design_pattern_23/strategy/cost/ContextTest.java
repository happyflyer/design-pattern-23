package org.example.design_pattern_23.strategy.cost;

import org.junit.Test;

public class ContextTest {
    @Test
    public void test() {
        double num = 200;
        Context context = new Context(new StrategyA());
        double cost = context.cost(num);
        System.out.println(cost);
        Context context2 = new Context(new StrategyB());
        double cost2 = context2.cost(num);
        System.out.println(cost2);
    }
}
