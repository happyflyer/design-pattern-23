package org.example.design_pattern_23.interpreter;

/**
 * @author lifei
 */
public class MinusExpression extends Expression {
    @Override
    public void interpret(Context context) {
        System.out.println("自动递减");
        String input = context.getInput();
        int intInput = Integer.parseInt(input);
        --intInput;
        context.setInput(String.valueOf(intInput));
        context.setOutput(intInput);
    }
}
