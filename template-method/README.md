# 模板方法模式

## 1. 什么是模板方法模式

Template Method 模式也叫模板方法模式，是行为模式之一，它把具有特定步骤算法中的某些必要的处理委让给抽象方法，通过子类继承对抽象方法的不同实现改变整个算法的行为。

## 2. 模板方法模式的应用场景

Template Method 模式一般应用在具有以下条件的应用中：

- 具有统一的操作步骤或操作过程。
- 具有不同的操作细节。
- 存在多个具有同样操作步骤的应用场景，但某些具体的操作细节却各不相同。

## 3. 模板方法模式的结构

![模板方法模式](https://cdn.jsdelivr.net/gh/happyflyer/picture-bed@main/2020/模板方法模式.3chnfc7dcui0.jpg)

## 4. 模板方法的角色和职责

- AbstractClass：抽象类的父类
- ConcreteClass：具体的实现子类
- template Method()：模板方法
- method1() 与 method2()：具体步骤方法

## 5. 代码演示

```java
public abstract class MakeCar {
    public abstract void makeHead();
    public abstract void makeBody();
    public abstract void makeTail();
    public void make() {
        this.makeHead();
        this.makeBody();
        this.makeTail();
    }
}
```

```java
public class MakeBus extends MakeCar {
    @Override
    public void makeHead() {
        System.out.println("bus: 组装车头");
    }
    @Override
    public void makeBody() {
        System.out.println("bus: 组装车身");
    }
    @Override
    public void makeTail() {
        System.out.println("bus: 组装车尾");
    }
}
```

```java
public class MakeJeep extends MakeCar {
    @Override
    public void makeHead() {
        System.out.println("jeep: 组装车头");
    }
    @Override
    public void makeBody() {
        System.out.println("jeep: 组装车身");
    }
    @Override
    public void makeTail() {
        System.out.println("jeep: 组装车尾");
    }
}
```

### 5.1. 不使用模板方法

```java
MakeCar bus = new MakeBus();
bus.makeHead();
bus.makeBody();
bus.makeTail();
System.out.println("==========");
MakeCar jeep = new MakeJeep();
jeep.makeHead();
jeep.makeBody();
jeep.makeTail();
```

### 5.2. 使用模板方法

```java
MakeCar bus = new MakeBus();
bus.make();
System.out.println("==========");
MakeCar jeep = new MakeJeep();
jeep.make();
```
