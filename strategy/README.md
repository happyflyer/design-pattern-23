# 策略模式

## 1. 什么是策略模式

Strategy 模式也叫策略模式是行为模式之一，它对一系列的算法加以封装，为所有算法定义个抽象的算法接口，并通过继承该抽象算法接口对所有的算法加以封装和实现，具体的算法选择交由客户端决定（策略）。 Strategy 模式主要用来平滑地处理算法的切换。

## 2. 策略模式的结构

![策略模式](https://cdn.jsdelivr.net/gh/happyflyer/picture-bed@main/2020/策略模式.75absy8ytrk0.png)

## 3. 策略模式的角色和职责

- Strategy：策略(算法)抽象。
- Concrete Strategy：各种策略(算法)的具体实现。
- Context：策略的外部封装类，或者说策略的容器类。根据不同策略执行不同的行为。策略由外部环境决定。

## 4. 策略模式的优点

1. 策略模式提供了管理相关的算法族的办法。策略类的等级结枃定义了一个算法或行为族。恰当使用继承可以把公共的代码移到父类里面，从而避免重复的代码。
2. 策略模式提供了可以替换继承关系的办法。继承可以处理多种算法或行为。如果不是用策略模式，那么使用算法或行为的环境类就可能会有一些子类，每一个子类提供一个不同的算法或行为。但是，这样来算法或行为的使用者就和算法或行为本身混在一起。决定使用哪种算法或釆取哪一种行为的逻辑就和算法或行为的逻辑混合在一起，从而不可能再独立演化。继承使得动态改变算法或行为变得不可能。
3. 使用策略模式可以避免使用多重条件转移语句。多重转移语句不易维护，它把采取哪种算法或釆取哪种行为的逻辑与算法或行为的逻辑混合在一起，统统列在一个多重转移语句里面，比使用继承的办法还要原始和落后。

## 5. 策略模式的缺点

1. 客户端必须知道所有的策略类，并自行决定使用哪户端别，以便适时选择恰当的算法类。换言之，策略模式只适用于客户端知道所有的算法或行为的情况。
2. 策略模式造成很多的策略类。有时候可以通过把依赖于环境的状态保存到客户端里面，而将策略类设计成可共享的，这样策略类实例可以被不同客户端使用。换言之，可以使用享元模式来减少对象的数量。

## 6. 代码演示

### 6.1. 直接调用

```java
public interface Strategy {
    void encrypt();
}
```

```java
public class Md5Strategy implements Strategy {
    @Override
    public void encrypt() {
        System.out.println("实现MD5加密");
    }
}
```

```java
Strategy strategy = new Md5Strategy();
strategy.encrypt();
```

### 6.2. 使用 Context

```java
public class Context {
    private final Strategy strategy;
    public Context(Strategy strategy) {
        this.strategy = strategy;
    }
    public void encrypt() {
        this.strategy.encrypt();
    }
}
```

```java
public class RsaStrategy implements Strategy {
    @Override
    public void encrypt() {
        System.out.println("实现RSA加密");
    }
}
```

```java
Context context1 = new Context(new Md5Strategy());
context1.encrypt();
Context context2 = new Context(new RsaStrategy());
context2.encrypt();
```

### 6.3. 价格打折的例子

```java
public interface Strategy {
    double cost(double num);
}
```

```java
public class StrategyA implements Strategy {
    @Override
    public double cost(double num) {
        return num * 0.8;
    }
}
```

```java
public class StrategyB implements Strategy {
    @Override
    public double cost(double num) {
        if (num >= 200) {
            return num - 50;
        }
        return num;
    }
}
```

```java
public class Context {
    private final Strategy strategy;
    public Context(Strategy strategy) {
        this.strategy = strategy;
    }
    public double cost(double num) {
        return this.strategy.cost(num);
    }
}
```

```java
double num = 200;
Context context = new Context(new StrategyA());
double cost = context.cost(num);
System.out.println(cost);
Context context2 = new Context(new StrategyB());
double cost2 = context2.cost(num);
System.out.println(cost2);
```
