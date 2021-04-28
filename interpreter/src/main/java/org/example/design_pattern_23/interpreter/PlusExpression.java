package org.example.design_pattern_23.interpreter;

/**
 * @author lifei
 */
public class PlusExpression extends Expression {
    @Override
    public void interpret(Context context) {
        System.out.println("自动递增");
        String input = context.getInput();
        int intInput = Integer.parseInt(input);
        ++intInput;
        context.setInput(String.valueOf(intInput));
        context.setOutput(intInput);
    }
}
