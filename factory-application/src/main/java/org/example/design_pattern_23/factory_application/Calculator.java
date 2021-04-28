package org.example.design_pattern_23.factory_application;

import java.util.Scanner;

/**
 * @author lifei
 */
public class Calculator {
    public static void main(String[] args) {
        new Calculator().calculate();
    }

    public void calculate() {
        System.out.println("---第一个计算器程序---");
        // 1、接收控制台输入
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入第一个操作数");
        String numStr1 = scanner.nextLine();
        System.out.println("输入运算符");
        String operator = scanner.nextLine();
        System.out.println("输入第二个操作数");
        String numStr2 = scanner.nextLine();
        // 2、进行计算
        double result = 0;
        if ("+".equals(operator)) {
            result = Double.parseDouble(numStr1) + Double.parseDouble(numStr2);
        } else if ("-".equals(operator)) {
            result = Double.parseDouble(numStr1) - Double.parseDouble(numStr2);
        } else if ("*".equals(operator)) {
            result = Double.parseDouble(numStr1) * Double.parseDouble(numStr2);
        } else if ("/".equals(operator)) {
            result = Double.parseDouble(numStr1) / Double.parseDouble(numStr2);
        } else {
            result = 0;
        }
        // 3、返回结果
        System.out.println(numStr1 + operator + numStr2 + "=" + result);
    }
}
