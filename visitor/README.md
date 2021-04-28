# 访问者模式

## 1. 什么是访问者模式

Visitor 模式也叫访问者模式，是行为模式之一，它分离对象的数据和行为，使用 Visitor 模式，可以不修改已有类的情况下，增加新的操作。

## 2. 访问者模式的应用示例

比如有一个公园，有一到多个不同的组成部分；该公园存在多个访问者：清洁工 A 负责打扫公园的 A 部分，清洁工 B 负责打扫公园的 B 部分，公园的管理者负责检点各项事务是否完成，上级领导可以视察公园等等。也就是说，对于同一个公园，不同的访问者有不同的行为操作，而且访问者的种类也可能需要根据时间的推移而变化（行为的扩展性）。

根据软件设计的开闭原则（对修改关闭，对扩展开放），我们怎么样实现这种需求呢？

## 3. 访问者模式的结构

![访问者模式](https://cdn.jsdelivr.net/gh/happyflyer/picture-bed@main/2020/访问者模式.34gnpwccsy80.jpg)

## 4. 访问者模式的角色和职责

1. 访问者角色（Visitor）：为该对象结构中具体元素角色声明一个访问操作接口。该操作接口的名字和参数标识了发送访问请求给具体访问者的具体元素角色。这样访问者就可以通过该元素角色的特定接囗直接访问它。
2. 具体访问者角色（Concrete visitor）：实现每个由访问者角色（ Visitor）声明的操作。
3. 元素角色（Element）：定义一个 Accept 操作，它以一个访问者为参数。
4. 具体元素角色（Concrete element）：实现由元素角色提供的 Accept 操作。
5. 对象结构角色（Object Structure）：这是使用访问者模式必备的角色。它要具备以下特征：能枚举它的元素；可以提供一个高层的接囗以允许该访间者访问它的元素；可以是一个复合（组合模式）或是一个集合，如一个列表或一个无序集合。

## 5. 代码演示

```java
public interface ParkElement {
    void accept(Visitor visitor);
}
```

```java
public class ParkA implements ParkElement {
    private String name;
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
```

```java
public class ParkB implements ParkElement {
    private String name;
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
```

```java
public class Park implements ParkElement {
    private String name;
    private final ParkA parkA;
    private final ParkB parkB;
    public Park() {
        this.parkA = new ParkA();
        this.parkB = new ParkB();
        this.parkA.setName("A");
        this.parkB.setName("B");
    }
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
        this.parkA.accept(visitor);
        this.parkB.accept(visitor);
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
```

```java
public interface Visitor {
    void visit(Park park);
    void visit(ParkA parkA);
    void visit(ParkB parkB);
}
```

```java
public class VisitorA implements Visitor {
    @Override
    public void visit(Park park) {
    }
    @Override
    public void visit(ParkA parkA) {
        System.out.println("清洁工A：完成公园" + parkA.getName() + "的卫生");
    }
    @Override
    public void visit(ParkB parkB) {
    }
}
```

```java
public class VisitorB implements Visitor {
    @Override
    public void visit(Park park) {
    }
    @Override
    public void visit(ParkA parkA) {
    }
    @Override
    public void visit(ParkB parkB) {
        System.out.println("清洁工B：完成公园" + parkB.getName() + "的卫生");
    }
}
```

```java
public class VisitorManager implements Visitor {
    @Override
    public void visit(Park park) {
        System.out.println("管理员：负责检查" + park.getName() + "卫生");
    }
    @Override
    public void visit(ParkA parkA) {
        System.out.println("管理员：负责检查公园" + parkA.getName() + "的卫生");
    }
    @Override
    public void visit(ParkB parkB) {
        System.out.println("管理员：负责检查公园" + parkB.getName() + "的卫生");
    }
}
```

```java
Park park = new Park();
park.setName("越秀公园");
Visitor visitorA = new VisitorA();
park.accept(visitorA);
Visitor visitorB = new VisitorB();
park.accept(visitorB);
Visitor visitorManager = new VisitorManager();
park.accept(visitorManager);
```

```java
清洁工A：完成公园A的卫生
清洁工B：完成公园B的卫生
管理员：负责检查越秀公园卫生
管理员：负责检查公园A的卫生
管理员：负责检查公园B的卫生
```
