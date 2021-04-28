# 外观模式

## 1. 什么是外观模式

Facade 模式也叫外观模式，是由 GoF 提出的 23 种设计模式中的一种。 Facade 模式为一组具有类似功能的类群，比如类库，子系统等等，提供一个一致的简单的界面。这个一致的简单的界面被称作 facade。

## 2. 外观模式的结构

![外观模式](https://cdn.jsdelivr.net/gh/happyflyer/picture-bed@main/2020/外观模式.xuwgsyru69s.png)

## 3. 外观模式的角色和职责

- Facade：为调用方定义简单的调用接口。
- Clients：调用者。通过 Facade 接口调用提供某功能的内部类群。
- Packages：功能提供者。指提供功能的类群（模块或子系统）。

## 4. 代码演示

### 4.1. 不使用外观模式

```java
public class SystemA {
    public void doSomething() {
        System.out.println("实现A子系统功能");
    }
}
```

```java
public class SystemB {
    public void doSomething() {
        System.out.println("实现B子系统功能");
    }
}
```

```java
public class SystemC {
    public void doSomething() {
        System.out.println("实现C子系统功能");
    }
}
```

```java
SystemA systemA = new SystemA();
systemA.doSomething();
SystemB systemB = new SystemB();
systemB.doSomething();
SystemC systemC = new SystemC();
systemC.doSomething();
```

### 4.2. 使用外观模式

```java
public class Facade {
    private final SystemA systemA;
    private final SystemB systemB;
    private final SystemC systemC;
    public Facade() {
        this.systemA = new SystemA();
        this.systemB = new SystemB();
        this.systemC = new SystemC();
    }
    public void doAbc() {
        this.systemA.doSomething();
        this.systemB.doSomething();
        this.systemC.doSomething();
    }
    public void doAb() {
        this.systemA.doSomething();
        this.systemB.doSomething();
    }
}
```

```java
Facade facade = new Facade();
facade.doAbc();
System.out.println("==========");
facade.doAb();
```

```java
实现A子系统功能
实现B子系统功能
实现C子系统功能
==========
实现A子系统功能
实现B子系统功能
```

### 4.3. 买基金的例子

```java
public class GuPiao {
    public void chao() {
        System.out.println("炒股票");
    }
}
```

```java
public class QiHuo {
    public void mai() {
        System.out.println("买期货");
    }
}
```

```java
public class GuoZhai {
    public void mai() {
        System.out.println("买国债");
    }
}
```

```java
public class JiJin {
    private final GuPiao guPiao;
    private final QiHuo qiHuo;
    private final GuoZhai guoZhai;
    public JiJin() {
        this.guPiao = new GuPiao();
        this.qiHuo = new QiHuo();
        this.guoZhai = new GuoZhai();
    }
    public void maiJiJinA() {
        this.guoZhai.mai();
        this.qiHuo.mai();
    }
    public void maiJiJinB() {
        this.guPiao.chao();
        this.qiHuo.mai();
        this.guoZhai.mai();
    }
}
```

```java
JiJin jiJin = new JiJin();
jiJin.maiJiJinA();
System.out.println("==========");
jiJin.maiJiJinB();
```

```java
买国债
买期货
==========
炒股票
买期货
买国债
```
