package org.example.design_pattern_23.strategy.cost;

/**
 * @author lifei
 */
public class Context {
    private final Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public double cost(double num) {
        return this.strategy.cost(num);
    }
}
