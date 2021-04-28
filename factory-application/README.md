# 工厂模式应用

## 1. 第一个计算器程序

```java
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
```

## 2. 抽象运算行为

```java
public abstract class Operation {
    private double num1;
    private double num2;
    public double getNum1() {
        return num1;
    }
    public void setNum1(double num1) {
        this.num1 = num1;
    }
    public double getNum2() {
        return num2;
    }
    public void setNum2(double num2) {
        this.num2 = num2;
    }
    public abstract double getResult();
}
```

```java
public class AddOperation extends Operation {
    @Override
    public double getResult() {
        return this.getNum1() + this.getNum2();
    }
}
```

```java
public class SubOperation extends Operation {
    @Override
    public double getResult() {
        return this.getNum1() - this.getNum2();
    }
}
```

```java
public class MultiOperation extends Operation {
    @Override
    public double getResult() {
        return this.getNum1() * this.getNum2();
    }
}
```

```java
public class DivOperation extends Operation {
    @Override
    public double getResult() {
        return this.getNum1() / this.getNum2();
    }
}
```

## 3. 简单工厂模式

```java
public class OperationFactory {
    public static Operation getOperation(String operator) {
        if ("+".equals(operator)) {
            return new AddOperation();
        } else if ("-".equals(operator)) {
            return new SubOperation();
        } else if ("*".equals(operator)) {
            return new MultiOperation();
        } else if ("/".equals(operator)) {
            return new DivOperation();
        } else {
            return null;
        }
    }
}
```

```java
// 2、进行计算
double result = 0;
double num1 = Double.parseDouble(numStr1);
double num2 = Double.parseDouble(numStr2);
Operation operation = OperationFactory.getOperation(operator);
assert operation != null;
operation.setNum1(num1);
operation.setNum2(num2);
result = operation.getResult();
```

## 4. 工厂方法模式

```java
public interface OperationFactory {
    Operation getOperation();
}
```

```java
public class AddOperationFactory implements OperationFactory {
    @Override
    public Operation getOperation() {
        return new AddOperation();
    }
}
```

```java
public class SubOperationFactory implements OperationFactory {
    @Override
    public Operation getOperation() {
        return new SubOperation();
    }
}
```

```java
public class MultiOperationFactory implements OperationFactory {
    @Override
    public Operation getOperation() {
        return new MultiOperation();
    }
}
```

```java
public class DivOperationFactory implements OperationFactory {
    @Override
    public Operation getOperation() {
        return new DivOperation();
    }
}
```

```java
// 2、进行计算
double result = 0;
double num1 = Double.parseDouble(numStr1);
double num2 = Double.parseDouble(numStr2);
OperationFactory factory = null;
if ("+".equals(operator)) {
    factory = new AddOperationFactory();
} else if ("-".equals(operator)) {
    factory = new SubOperationFactory();
} else if ("*".equals(operator)) {
    factory = new MultiOperationFactory();
} else if ("/".equals(operator)) {
    factory = new DivOperationFactory();
}
assert factory != null;
Operation operation = factory.getOperation();
operation.setNum1(num1);
operation.setNum2(num2);
result = operation.getResult();
```
