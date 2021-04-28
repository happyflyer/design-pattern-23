package org.example.design_pattern_23.strategy.cost;

/**
 * @author lifei
 */
public class StrategyB implements Strategy {
    @Override
    public double cost(double num) {
        if (num >= 200) {
            return num - 50;
        }
        return num;
    }
}
