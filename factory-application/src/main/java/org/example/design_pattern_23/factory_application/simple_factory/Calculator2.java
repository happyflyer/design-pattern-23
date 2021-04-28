package org.example.design_pattern_23.factory_application.simple_factory;

import java.util.Scanner;

/**
 * @author lifei
 */
public class Calculator2 {
    public static void main(String[] args) {
        new Calculator2().calculate();
    }

    public void calculate() {
        System.out.println("---第二个计算器程序---");
        // 1、接收控制台输入
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入第一个操作数");
        String numStr1 = scanner.nextLine();
        System.out.println("输入预算符");
        String operator = scanner.nextLine();
        System.out.println("输入第二个操作数");
        String numStr2 = scanner.nextLine();
        // 2、进行计算
        double result = 0;
        double num1 = Double.parseDouble(numStr1);
        double num2 = Double.parseDouble(numStr2);
        Operation operation = OperationFactory.getOperation(operator);
        assert operation != null;
        operation.setNum1(num1);
        operation.setNum2(num2);
        result = operation.getResult();
        // 3、返回结果
        System.out.println(numStr1 + operator + numStr2 + "=" + result);
    }
}
