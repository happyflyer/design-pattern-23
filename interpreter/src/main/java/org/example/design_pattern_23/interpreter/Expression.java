package org.example.design_pattern_23.interpreter;

/**
 * @author lifei
 */
public abstract class Expression {
    /**
     * interpret
     *
     * @param context context
     */
    public abstract void interpret(Context context);
}
