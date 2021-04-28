package org.example.design_pattern_23.interpreter;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ExpressionTest {
    @Test
    public void test1() {
        String number = "20";
        Context context = new Context(number);
        Expression expression = new PlusExpression();
        expression.interpret(context);
        System.out.println(context.getOutput());
    }

    @Test
    public void test2() {
        String number = "20";
        Context context = new Context(number);
        Expression expression1 = new MinusExpression();
        expression1.interpret(context);
        System.out.println(context.getOutput());
        Expression expression2 = new PlusExpression();
        expression2.interpret(context);
        System.out.println(context.getOutput());
        Expression expression3 = new PlusExpression();
        expression3.interpret(context);
        System.out.println(context.getOutput());
    }

    @Test
    public void test3() {
        String number = "20";
        Context context = new Context(number);
        List<Expression> expressions = new ArrayList<>();
        expressions.add(new PlusExpression());
        expressions.add(new PlusExpression());
        expressions.add(new MinusExpression());
        expressions.add(new MinusExpression());
        expressions.add(new MinusExpression());
        for (Expression ex : expressions) {
            ex.interpret(context);
            System.out.println(context.getOutput());
        }
    }
}
