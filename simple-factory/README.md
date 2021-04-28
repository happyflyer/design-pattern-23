# 简单工厂模式

## 1. 什么是简单工厂模式

简单工厂模式属于类的创建型模式，又叫做静态工厂方法模式。通过专门定义一个类来负责创建其他类的实例，被创建的实例通常都具有共同的父类。

## 2. 模式中包含的角色及其职责

1. 工厂(Creator)角色：简单工厂模式的核心，它负责实现创建所有实例的内部逻辑。工厂类可以被外界直接调用，创建所需的产品对象。
2. 抽象(Product)角色：简单工厂模式所创建的所有对象的父类，它负责描述所有实例所共有的公共接口。
3. 具体产品(Concrete Product)角色：简单工厂模式所创建的具体实例对象。

## 3. 简单工厂模式的优缺点

在这个模式中，工厂类是整个模式的关键所在。它包含必要的判断逻辑，能够根据外界给定的信息，决定究竟应该创建哪个具体类的对象。用户在使用时可以直接根据工厂类去创建所需的实例，而无需了解这些对象是如何创建以及如何组织的。有利于整个软件体系结构的优化。

不难发现，简单工厂模式的缺点也正体现在其工厂类上，由于工厂类集中了所有实例的创建逻辑，所以高内聚方面做的并另外，当系统中的具体产品类不断增多时，可能会出现要求工厂类也要做相应的修改，扩展性并不很好。

## 4. 代码演示

```java
public interface Fruit {
    void get();
}
```

```java
public class Apple implements Fruit {
    @Override
    public void get() {
        System.out.println("采集苹果");
    }
}
```

```java
public class Banana implements Fruit {
    @Override
    public void get() {
        System.out.println("采集香蕉");
    }
}
```

### 4.1. 只有类

```java
Apple apple = new Apple();
Banana banana = new Banana();
apple.get();
banana.get();
```

### 4.2. 使用接口

```java
Fruit apple = new Apple();
Fruit banana = new Banana();
apple.get();
banana.get();
```

### 4.3. 实例工厂

```java
public class FruitFactory1 {
    public Fruit getApple() {
        return new Apple();
    }
    public Fruit getBanana() {
        return new Banana();
    }
}
```

```java
Fruit apple = new FruitFactory1().getApple();
Fruit banana = new FruitFactory1().getBanana();
apple.get();
banana.get();
```

### 4.4. 静态工厂

```java
public class FruitFactory2 {
    public static Fruit getApple() {
        return new Apple();
    }
    public static Fruit getBanana() {
        return new Banana();
    }
}
```

```java
Fruit apple = FruitFactory2.getApple();
Fruit banana = FruitFactory2.getBanana();
apple.get();
banana.get();
```

### 4.5. 类型判断

```java
public class FruitFactory3 {
    public static Fruit getFruit(String type)
            throws IllegalAccessException, InstantiationException {
        if ("apple".equalsIgnoreCase(type)) {
            return Apple.class.newInstance();
        } else if ("banana".equalsIgnoreCase(type)) {
            return Banana.class.newInstance();
        } else {
            System.out.println("找不到响应的实例化类");
            return null;
        }
    }
}
```

```java
try {
    Fruit apple = FruitFactory3.getFruit("apple");
    Fruit banana = FruitFactory3.getFruit("banana");
    assert apple != null;
    apple.get();
    assert banana != null;
    banana.get();
    Fruit orange = FruitFactory3.getFruit("orange");
    assert orange == null;
} catch (IllegalAccessException | InstantiationException e) {
    e.printStackTrace();
}
```

### 4.6. 使用反射

```java
public class FruitFactory4 {
    public static Fruit getFruit(String type) throws ClassNotFoundException,
            IllegalAccessException, InstantiationException {
        Class fruit = Class.forName(type);
        return (Fruit) fruit.newInstance();
    }
}
```

```java
try {
    Fruit apple = FruitFactory4.getFruit("org.example.design_pattern_23.simple_factory.Apple");
    Fruit banana = FruitFactory4.getFruit("org.example.design_pattern_23.simple_factory.Banana");
    apple.get();
    banana.get();
    Fruit orange = FruitFactory4.getFruit("org.example.design_pattern_23.simple_factory.Orange");
} catch (IllegalAccessException | InstantiationException | ClassNotFoundException e) {
    e.printStackTrace();
}
```
