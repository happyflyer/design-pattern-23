# 职责链模式

## 1. 什么是职责链模式

Chain of Responsibility（CoR）模式也叫职责链模式或者职责连锁模式，是行为模式之一，该模式构造一系列分别担当不同的职责的类的对象来共同完成一个任务，这些类的对象之间像链条一样紧密相连，所以被称作职责链模式。

## 2. 职责链模式的应用场景

例 1：比如客户 Client 要完成一个任务，这个任务包括 a,b,c,d 四个部分。首先客户 Client 把任务交给 A,A 完成 a 部分之后，把任务交给 B,B 完成 b 部分，…，直到 D 完成 d 部分。

例 2：比如政府部分的某项工作，县政府先完成自己能处理的部分，不能处理的部分交给省政府，省政府再完成自己职责范围内的部分，不能处理的部分交给中央政府，中央政府最后完成该项工作。

例 3：软件窗口的消息传播。

例 4：Servlet 容器的过滤器（Filter）框架实现。

## 3. 职责链模式的基本条件

要实现 Chain of Responsibility 模式，需要满足该模式的基本条件：

1. 对象链的组织。需要将某任务的所有职责执行对象以链的形式加以组织。
2. 消息或请求的传递。将消息或请求沿着对象链传递，以让处于对象链中的对象得到处理机会。
3. 处于对象链中的对象的职责分配。不同的对象完成不同的职责。
4. 任务的完成。处于对象链的末尾的对象结束任务并停止消息或请求的继续传递。

## 4. 责任链模式的结构

![职责链模式](https://cdn.jsdelivr.net/gh/happyflyer/picture-bed@main/2020/职责链模式.2u2oxl7lmmy0.png)

## 5. 职责链模式的角色与职责

- Handler：处理类的抽象父类。
- concrete Handler：具体的处理类。

## 6. 职责链模式的优缺点

### 6.1. 优点

1. 责任的分担。每个类只需要处理自己该处理的工作（不该处理的传递给下一个对象完成），明确各类的责任范围，符合类的最小封装原则。
2. 可以根据需要自由组合工作流程。如工作流程发生变化，可以通过重新分配对象链便可适应新的工作流程。
3. 类与类之间可以以松耦合的形式加以组织。

### 6.2. 缺点

因为处理时以链的形式在对象间传递消息，根据实现方式不同，有可能会影响处理的速度。

## 7. 代码演示

### 7.1. 不使用职责链

```java
public abstract class CarHandler {
    public abstract void handleCar();
}
```

```java
public class CarHeadHandler extends CarHandler {
    @Override
    public void handleCar() {
        System.out.println("组装车头");
    }
}
```

```java
public class CarBodyHandler extends CarHandler {
    @Override
    public void handleCar() {
        System.out.println("组装车身");
    }
}
```

```java
public class CarTailHandler extends CarHandler {
    @Override
    public void handleCar() {
        System.out.println("组装车尾");
    }
}
```

```java
CarHeadHandler head = new CarHeadHandler();
CarBodyHandler body = new CarBodyHandler();
CarTailHandler tail = new CarTailHandler();
head.handleCar();
body.handleCar();
tail.handleCar();
```

```java
组装车头
组装车身
组装车尾
```

### 7.2. 使用职责链

```java
public abstract class CarHandler {
    protected CarHandler nextHandler;
    public CarHandler setNextHandler(CarHandler nextHandler) {
        this.nextHandler = nextHandler;
        return this.nextHandler;
    }
    public abstract void handleCar();
}
```

```java
public class CarHeadHandler extends CarHandler {
    @Override
    public void handleCar() {
        System.out.println("组装车头");
        if (this.nextHandler != null) {
            this.nextHandler.handleCar();
        }
    }
}
```

```java
public class CarBodyHandler extends CarHandler {
    @Override
    public void handleCar() {
        System.out.println("组装车身");
        if (this.nextHandler != null) {
            this.nextHandler.handleCar();
        }
    }
}
```

```java
public class CarTailHandler extends CarHandler {
    @Override
    public void handleCar() {
        System.out.println("组装车尾");
        if (this.nextHandler != null) {
            this.nextHandler.handleCar();
        }
    }
}
```

```java
CarHeadHandler head = new CarHeadHandler();
CarBodyHandler body = new CarBodyHandler();
CarTailHandler tail = new CarTailHandler();
head.setNextHandler(body);
body.setNextHandler(tail);
head.handleCar();
System.out.println("==========");
body.setNextHandler(head);
head.setNextHandler(tail);
body.handleCar();
System.out.println("==========");
body.setNextHandler(head).setNextHandler(tail);
body.handleCar();
```

```java
组装车头
组装车身
组装车尾
==========
组装车身
组装车头
组装车尾
==========
组装车身
组装车头
组装车尾
```
