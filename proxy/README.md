# 代理模式

## 1. 什么是代理模式

Proxy 模式又叫做代理模式，是构造型的设计模式之一，它可以为其他对象提供一种代理（Proxy）以控制对这个对象的访问。

所谓代理，是指具有与代理元（被代理的对象）具有相同的接口的类，客户端必须通过代理与被代理的目标类交互，而代理一般在交互的过程中（交互前后），进行某些特别的处理。

## 2. 代理模式的结构

![代理模式](https://cdn.jsdelivr.net/gh/happyflyer/picture-bed@main/2020/代理模式.5un7ypqynys0.png)

## 3. 代理模式的角色和职责

- Subject（抽象主题角色）：真实主题与代理主题的共同接口。
- RealSubject（真实主题角色）：定义了代理角色所代表的真实对象。
- Proxy（代理主题角色）：含有对真实主题角色的引用，代理角色通常在将客户端调用传递给真是主题对象之前或者之后执行某些操作，而不是单纯返回真实的对象。

## 4. 动态代理

- `InvocationHandler` 接口
- `invoke` 方法
- `Proxy.newProxyInstance();`

## 5. 代码演示

### 5.1. 不使用代理

```java
public interface Subject {
    void sellBook();
}
```

```java
public class RealSubject implements Subject {
    @Override
    public void sellBook() {
        System.out.println("卖书");
    }
}
```

```java
Subject subject = new RealSubject();
subject.sellBook();
```

### 5.2. 使用代理

```java
public class ProxySubject implements Subject {
    private Subject realSubject;
    @Override
    public void sellBook() {
        this.daZhe();
        if (this.realSubject == null) {
            this.realSubject = new RealSubject();
        }
        this.realSubject.sellBook();
        this.give();
    }
    public void daZhe() {
        System.out.println("打折");
    }
    public void give() {
        System.out.println("赠送代金券");
    }
}
```

```java
Subject proxySubject = new ProxySubject();
proxySubject.sellBook();
```

```java
打折
卖书
赠送代金券
```

### 5.3. 动态代理

```java
public class MyHandler implements InvocationHandler {
    private Subject realSubject;
    public void setRealSubject(Subject realSubject) {
        this.realSubject = realSubject;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        Object result = null;
        daZhe();
        try {
            result = method.invoke(realSubject, args);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        give();
        return result;
    }
    public void daZhe() {
        System.out.println("打折");
    }
    public void give() {
        System.out.println("赠送代金券");
    }
}
```

```java
Subject realSubject = new RealSubject();
MyHandler handler = new MyHandler();
handler.setRealSubject(realSubject);
Subject proxySubject = (Subject) Proxy.newProxyInstance(
        RealSubject.class.getClassLoader(),
        realSubject.getClass().getInterfaces(),
        handler
);
proxySubject.sellBook();
```

```java
打折
卖书
赠送代金券
```
