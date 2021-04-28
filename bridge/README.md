# 桥接模式

## 1. 什么是桥接模式

Bridge 模式又叫做桥接模式，是构造型的设计模式之一。 Bridge 模式基于类的最小设计原则，通过使用封装，聚合以及继承等行为来让不同的类承担不同的责任。它的主要特点是把抽象（abstraction）与行为实现（implementation）分离开来，从而可以保持各部分的独立性以及应对它们的功能扩展。

## 2. 桥接模式的结构

![桥接模式](https://cdn.jsdelivr.net/gh/happyflyer/picture-bed@main/2020/桥接模式.75sly0bvmx0.jpg)

## 3. 代码演示

### 3.1. car1

```java
public interface Car {
    void installEngine();
}
```

```java
public abstract class Bus implements Car {
    @Override
    public abstract void installEngine();
}
```

```java
public class Bus2000 extends Bus {
    @Override
    public void installEngine() {
        System.out.println("给Bus安装2000cc发动机");
    }
}
```

```java
public class Bus2200 extends Bus {
    @Override
    public void installEngine() {
        System.out.println("给Bus安装2200cc发动机");
    }
}
```

```java
public abstract class Jeep implements Car {
    @Override
    public abstract void installEngine();
}
```

```java
public class Jeep2000 extends Bus {
    @Override
    public void installEngine() {
        System.out.println("给Jeep安装2000cc发动机");
    }
}
```

```java
public class Jeep2200 extends Bus {
    @Override
    public void installEngine() {
        System.out.println("给Jeep安装2200cc发动机");
    }
}
```

```java
Car bus2000 = new Bus2000();
bus2000.installEngine();
Car bus2200 = new Bus2200();
bus2200.installEngine();
Car jeep2000 = new Jeep2000();
jeep2000.installEngine();
Car jeep2200 = new Jeep2200();
jeep2200.installEngine();
```

```java
给Bus安装2000cc发动机
给Bus安装2200cc发动机
给Jeep安装2000cc发动机
给Jeep安装2200cc发动机
```

### 3.2. car2

```java
public interface Car {
    void install2000Engine();
    void install2200Engine();
    void install2400Engine();
}
```

```java
public class Bus implements Car {
    @Override
    public void install2000Engine() {
        System.out.println("给Bus安装2000cc发动机");
    }
    @Override
    public void install2200Engine() {
        System.out.println("给Bus安装2200cc发动机");
    }
    @Override
    public void install2400Engine() {
        System.out.println("给Bus安装2400cc发动机");
    }
}
```

```java
Car bus = new Bus();
bus.install2000Engine();
bus.install2200Engine();
bus.install2400Engine();
```

```java
给Bus安装2000cc发动机
给Bus安装2200cc发动机
给Bus安装2400cc发动机
```

### 3.3. car3

```java
public interface Engine {
    void displayEngine();
}
```

```java
public class Engine2000 implements Engine {
    @Override
    public void displayEngine() {
        System.out.println("安装2000cc发动机");
    }
}
```

```java
public class Engine2200 implements Engine {
    @Override
    public void displayEngine() {
        System.out.println("安装2200cc发动机");
    }
}
```

```java
public abstract class Car {
    private final Engine engine;
    public Car(Engine engine) {
        this.engine = engine;
    }
    public Engine getEngine() {
        return engine;
    }
    public abstract void installEngine();
}
```

```java
public class Bus extends Car {
    public Bus(Engine engine) {
        super(engine);
    }
    @Override
    public void installEngine() {
        System.out.print("Bus：");
        this.getEngine().displayEngine();
    }
}
```

```java
public class Jeep extends Car {
    public Jeep(Engine engine) {
        super(engine);
    }
    @Override
    public void installEngine() {
        System.out.print("Jeep：");
        this.getEngine().displayEngine();
    }
}
```

```java
Engine engine2000 = new Engine2000();
Engine engine2200 = new Engine2200();
Car bus1 = new Bus(engine2000);
bus1.installEngine();
Car bus2 = new Bus(engine2200);
bus2.installEngine();
Car jeep1 = new Jeep(engine2000);
jeep1.installEngine();
Car jeep2 = new Jeep(engine2200);
jeep2.installEngine();
```

```java
Bus：安装2000cc发动机
Bus：安装2200cc发动机
Jeep：安装2000cc发动机
Jeep：安装2200cc发动机
```

### 3.4. 新增 Truck

```java
public class Truck extends Car {
    public Truck(Engine engine) {
        super(engine);
    }
    @Override
    public void installEngine() {
        System.out.print("Truck：");
        this.getEngine().displayEngine();
    }
}
```

```java
Car truck1 = new Truck(engine2000);
truck1.installEngine();
Car truck2 = new Truck(engine2200);
truck2.installEngine();
```

```java
Truck：安装2000cc发动机
Truck：安装2200cc发动机
```
