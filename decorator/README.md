# 装饰模式

## 1. 什么是装饰模式

Decorator 模式又叫做装饰模式、包装模式。通过一种对客户端透明的方式来扩展对象的功能，是继承关系的一个替换方案。

## 2. 装饰模式的结构

![装饰模式](https://cdn.jsdelivr.net/gh/happyflyer/picture-bed@main/2020/装饰模式.5754bkpvc840.png)

## 3. 装饰模式的角色和职责

- 抽象组件角色：一个抽象接口，是被装饰类和装饰类的父接口。
- 具体组件角色：为抽象组件的实现类。
- 抽象装饰角色：包含一个组件的引用，并定义了与抽象组件一致的接口。
- 具体装饰角色：为抽象装饰角色的实现类。负责具体的装饰。

## 4. 代码演示

### 4.1. 直接创建

```java
public class Car {
    public void run() {
        System.out.println("可以跑");
    }
    public void fly() {
        System.out.println("可以飞");
    }
    public void swim() {
        System.out.println("可以游");
    }
    public void show() {
        System.out.println("拥有的功能");
        this.run();
        this.fly();
        this.swim();
    }
}
```

```java
Car car = new Car();
car.show();
```

所有车都会飞、会游显然不合理，但是又需要有的车会飞，有的车会游，有的既会飞又会游。

### 4.2. 使用继承

```java
public interface Car {
    void run();
    void show();
}
```

```java
public class RunCar implements Car {
    @Override
    public void run() {
        System.out.println("可以跑");
    }
    @Override
    public void show() {
        this.run();
    }
}
```

```java
public class FlyCar implements Car {
    @Override
    public void run() {
        System.out.println("可以跑");
    }
    public void fly() {
        System.out.println("可以飞");
    }
    @Override
    public void show() {
        this.run();
        this.fly();
    }
}
```

```java
public class SwimCar implements Car {
    @Override
    public void run() {
        System.out.println("可以跑");
    }
    public void swim() {
        System.out.println("可以游");
    }
    @Override
    public void show() {
        this.run();
        this.swim();
    }
}
```

```java
Car runCar = new RunCar();
runCar.show();
System.out.println("==========");
Car flyCar = new FlyCar();
flyCar.show();
System.out.println("==========");
Car swimCar = new SwimCar();
swimCar.show();
```

```java
可以跑
==========
可以跑
可以飞
==========
可以跑
可以游
```

当功能组合很多时，使用继承方式...

### 4.3. 使用装饰

#### 4.3.1. 抽象组件

```java
public interface Car {
    void run();
    void show();
}
```

#### 4.3.2. 具体组件

```java
public class RunCar implements Car {
    @Override
    public void run() {
        System.out.println("可以跑");
    }
    @Override
    public void show() {
        this.run();
    }
}
```

#### 4.3.3. 抽象装饰

```java
public abstract class CarDecorator implements Car {
    private final Car car;
    public CarDecorator(Car car) {
        this.car = car;
    }
    public Car getCar() {
        return car;
    }
    @Override
    public abstract void run();
    @Override
    public abstract void show();
}
```

#### 4.3.4. 具体装饰

```java
public class FlyCarDecorator extends CarDecorator {
    public FlyCarDecorator(Car car) {
        super(car);
    }
    @Override
    public void run() {
    }
    @Override
    public void show() {
        this.getCar().show();
        this.fly();
    }
    public void fly() {
        System.out.println("可以飞");
    }
}
```

```java
public class SwimCarDecorator extends CarDecorator {
    public SwimCarDecorator(Car car) {
        super(car);
    }
    @Override
    public void run() {
    }
    @Override
    public void show() {
        this.getCar().show();
        this.swim();
    }
    public void swim() {
        System.out.println("可以游");
    }
}
```

#### 4.3.5. 扩展一个功能

```java
Car car = new RunCar();
Car flyCar = new FlyCarDecorator(car);
flyCar.show();
```

```java
可以跑
可以飞
```

#### 4.3.6. 分别扩展多个功能

```java
Car car = new RunCar();
Car flyCar = new FlyCarDecorator(car);
flyCar.show();
System.out.println("==========");
Car swimCar = new SwimCarDecorator(car);
swimCar.show();
```

```java
可以跑
可以飞
==========
可以跑
可以游
```

#### 4.3.7. 同时扩展多个功能

```java
Car car = new RunCar();
car.show();
System.out.println("==========");
Car flyCar = new FlyCarDecorator(car);
flyCar.show();
System.out.println("==========");
Car flySwimCar = new SwimCarDecorator(flyCar);
flySwimCar.show();
```

```java
可以跑
==========
可以跑
可以飞
==========
可以跑
可以飞
可以游
```
