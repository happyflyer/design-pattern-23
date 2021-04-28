# 解释器模式

## 1. 什么是解释器模式

Interpreter 模式也叫解释器模式，是行为模式之一，它是一种特殊的设计模式，它建立一个解释聲，对于特定的计算机程序设计语言，用来解释预先定义的文法。简单地说，Interpreter 模式是一种简单的语法解释器构架。

## 2. 解释器模式应用场景

当有一个语言需要解释执行，并且你可将该语言中的句子表示为一个抽象语法树时，可使用解释器模式。而当存在以下情况时该模式效果最好。

- 该文法简单对于复杂的文法，文法的类层次变得庞大而无法管理。此时语法分析程序生成器这样的工具是更好的选择。它们无需构建抽象语法树即可解释表达式，这样可以节省空间而且还可能节省时间。
- 效率不是一个关键问题，最高效的解释器通常不是通过直接解释语法分析树实现的，而是首先将它们转换成另一种形式。例如，正则表达式通常被转换成状态机。但即使在这种情况下，转换器仍可用解释器模式实现，该模式仍是有用的。

## 3. 解释器模式的结构

![解释器模式](https://cdn.jsdelivr.net/gh/happyflyer/picture-bed@main/2020/解释器模式.5o14vb3oszs0.jpeg)

## 4. 解释器模式的角色与职责

- Context：解释器上下文环境类。用来存储解释器的上下文环境，比如需要解释的文法等。
- AbstractExpression：解释器抽象类。
- Concrete Expression：解释器具体实现类。

## 5. 代码演示

```java
public class Context {
    private String input;
    private int output;
    public Context(String input) {
        this.input = input;
    }
    public String getInput() {
        return input;
    }
    public void setInput(String input) {
        this.input = input;
    }
    public int getOutput() {
        return output;
    }
    public void setOutput(int output) {
        this.output = output;
    }
}
```

```java
public abstract class Expression {
    public abstract void interpret(Context context);
}
```

```java
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
```

```java
tring number = "20";
Context context = new Context(number);
Expression expression = new PlusExpression();
expression.interpret(context);
System.out.println(context.getOutput());
```

```java
自动递增
21
```

```java
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
```

```java
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
```

```java
自动递减
19
自动递增
20
自动递增
21
```

```java
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
```

```java
自动递增
21
自动递增
22
自动递减
21
自动递减
20
自动递减
19
```
