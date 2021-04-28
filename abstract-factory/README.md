# 抽象工厂模式

## 1. 什么是抽象工厂模式

抽象工厂模式是所有形态的工厂模式中最为抽象和最其一般性的。抽象工厂模式可以向客户端提供一个接口，使得客户端在不必指定产品的具体类型的情况下，能够创建多个产品族的产品对象。

![抽象工厂模式](https://cdn.jsdelivr.net/gh/happyflyer/picture-bed@main/2020/抽象工厂模式.16mdp5rbz1mk.png)

## 2. 模式中包含的角色及其职责

1. 抽象工厂(Creator)角色：工厂模式的核心，包含对多个产品结构的声明，任何工厂类都必须实现这个。
2. 具体工厂(Concrete creator)角色：具体工厂类是抽象工厂的一个实现，负责实例化某个产品族中的产品对象。
3. 抽象(Product)角色：抽象模式所创建的所有对象的父类，它负责描述所有实例所共有的公共接口。
4. 具体产品(Concrete product)角色：抽象模式所创建的具体实例对象。

**总结：抽象工厂中方法对应产品结构，具体工厂对应产品族。**

## 3. 代码演示

### 3.1. 产品等级结构

```java
public interface Fruit {
    void get();
}
```

```java
public abstract class Apple implements Fruit {
    @Override
    public abstract void get();
}
```

```java
public abstract class Banana implements Fruit {
    @Override
    public abstract void get();
}
```

### 3.2. 具体产品

```java
public class NorthApple extends Apple {
    @Override
    public void get() {
        System.out.println("采集北方苹果");
    }
}
```

```java
public class SouthApple extends Apple {
    @Override
    public void get() {
        System.out.println("采集南方苹果");
    }
}
```

```java
public class NorthBanana extends Banana {
    @Override
    public void get() {
        System.out.println("采集北方香蕉");
    }
}
```

```java
public class SouthBanana extends Banana {
    @Override
    public void get() {
        System.out.println("采集南方香蕉");
    }
}
```

### 3.3. 抽象工厂

```java
public interface FruitFactory {
    Fruit getApple();
    Fruit getBanana();
}
```

### 3.4. 具体工厂

```java
public class NorthFruitFactory implements FruitFactory {
    @Override
    public Fruit getApple() {
        return new NorthApple();
    }
    @Override
    public Fruit getBanana() {
        return new NorthBanana();
    }
}
```

```java
public class SouthFruitFactory implements FruitFactory {
    @Override
    public Fruit getApple() {
        return new SouthBanana();
    }
    @Override
    public Fruit getBanana() {
        return new SouthBanana();
    }
}
```

```java
FruitFactory northFruitFactory = new NorthFruitFactory();
Fruit apple1 = northFruitFactory.getApple();
apple1.get();
Fruit banana1 = northFruitFactory.getBanana();
banana1.get();
FruitFactory southFruitFactory = new SouthFruitFactory();
Fruit apple2 = southFruitFactory.getApple();
apple2.get();
Fruit banana2 = southFruitFactory.getBanana();
banana2.get();
```

### 3.5. 新增产品族

```java
public class WenshiApple extends Apple {
    @Override
    public void get() {
        System.out.println("采集温室苹果");
    }
}
```

```java
public class WenshiBanana extends Banana {
    @Override
    public void get() {
        System.out.println("采集温室香蕉");
    }
}
```

```java
public class WenshiFruitFactory implements FruitFactory {
    @Override
    public Fruit getApple() {
        return new WenshiApple();
    }
    @Override
    public Fruit getBanana() {
        return new WenshiBanana();
    }
}
```

```java
FruitFactory wenshiFruitFactory = new WenshiFruitFactory();
Fruit apple3 = wenshiFruitFactory.getApple();
apple3.get();
Fruit banana3 = wenshiFruitFactory.getBanana();
banana3.get();
```

### 3.6. 新增产品等级

比较麻烦，要修改抽象工厂和具体工厂。

| 水果工厂 \\ 水果 | 苹果     | 香蕉     |
| ---------------- | -------- | -------- |
| **北方水果工厂** | 北方苹果 | 北方香蕉 |
| **南方水果工厂** | 南方苹果 | 南方香蕉 |
| **温室水果工厂** | 温室苹果 | 温室香蕉 |

- 纵向一列表示一个产品等级
- 横向一排表示一个产品族
- 一个产品族对应一个具体工厂
- 新增产品族
  - 新增不同产品等级的具体产品
  - 新增产品族的具体工厂
- 新增产品等级
  - 修改抽象工厂的定义
  - 修改已存在的具体工厂的定义
