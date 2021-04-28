package org.example.design_pattern_23.strategy.cost;

/**
 * @author lifei
 */
public class StrategyA implements Strategy {
    @Override
    public double cost(double num) {
        return num * 0.8;
    }
}
