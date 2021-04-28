# 适配器模式

## 1. 什么是适配器模式

Adapter 模式也叫适配器模式，是构造型模式之一，通过 Adapter 模式可以改变已有类（或外部类）的接口形式。

## 2. 适配器模式应用场景

在大规模的系统开发过程中，我们常常碰到诸如以下这些情况：我们需要实现某些功能，这些功能已有还不太成熟的一个或多个外部组件，如果我们自己重新开发这些功能会花费大量时间；所以很多情况下会选择先暂时使用外部组件，以后再考虑随时替换。但这样一来，会带来一个问题，随着对外部组件库的替换，可能需要对引用该外部组件的源代码进行大面积的修改，因此也极可能引入新的问题等等。如何最大限度的降低修改面呢？

Adapter 模式就是针对这种类似需求而提出来的。

Adapter 模式通过定义一个新的接口（对要实现的功能加以抽象）和一个实现该接口的 Adapter（适配器）类来透明地调用外部组件。这样替换外部组件时，最多只要修改几个 Adapter 类就可以了，其他源代码都不会受到影响。

## 3. 适配器模式的结构

### 3.1. 通过继承实现 Adapter

![通过继承实现适配器模式](https://cdn.jsdelivr.net/gh/happyflyer/picture-bed@main/2020/通过继承实现适配器模式.13zr8kpre068.png)

### 3.2. 通过委让实现 Adapter

![通过委让实现适配器模式](https://cdn.jsdelivr.net/gh/happyflyer/picture-bed@main/2020/通过委让实现适配器模式.4mtxcjobf080.png)

## 4. 代码演示

### 4.1. 不使用适配器

```java
public class Current {
    public void use220V() {
        System.out.println("使用220V电压");
    }
}
```

```java
Current current = new Current();
current.use220V();
```

### 4.2. 通过继承实现适配

```java
public class Adapter1 extends Current {
    public void use18V() {
        this.use220V();
        System.out.println("输入220V，输出18V");
    }
}
```

```java
Adapter1 adapter = new Adapter1();
adapter.use18V();
```

### 4.3. 通过委让实现适配

```java
public class Adapter2 {
    private final Current current;
    public Adapter2(Current current) {
        this.current = current;
    }
    public void use18V() {
        this.current.use220V();
        System.out.println("输入220V，输出18V");
    }
}
```

```java
Adapter2 adapter = new Adapter2(new Current());
adapter.use18V();
```
