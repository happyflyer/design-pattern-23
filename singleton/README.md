# 单例模式

## 1. 什么是单例模式

单例模式是一种对象创建型模式，使用单例模式，可以保证为一个类只生成唯一的实例对象。也就是说，在整个程序空间中，该类只存在一个实例对象。

其实，GoF 对单例模式的定义是：保证一个类只有一个实例存在，同时提供能对该实例加以访问的全局访问方法。

## 2. 为什么要使用单例模式

在应用系统开发中，我们常常有以下需求在多个线程之间，比如 servlet 环境，共享同一个资源或者操作同一个对象在整个程序空间使用全局变量，共享资源大规模系统中，为了性能的考虑，需要节省对象的创建时间等等。

因为 Singleton 模式可以保证为一个类只生成唯一的实例对象，所以这些情况， Singleton 模式就派上用场了。

## 3. 单例模式实现

1. 饿汉式
2. 懒汉式
3. 双重检查

## 4. 代码演示

### 4.1. 饿汉式

```java
public class Person2 {
    public static final Person2 person = new Person2();
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    private Person2() {
    }
    public static Person2 getPerson2() {
        return person;
    }
}
```

### 4.2. 懒汉式

```java
public class Person3 {
    private static Person3 person;
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    private Person3() {
    }
    public static Person3 getPerson3() {
        if (person == null) {
            person = new Person3();
        }
        return person;
    }
}
```

```java
public class Person4 {
    private static Person4 person;
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    private Person4() {
    }
    public static synchronized Person4 getPerson4() {
        if (person == null) {
            person = new Person4();
        }
        return person;
    }
}
```

### 4.3. 双重检查

```java
public class Person5 {
    private static Person5 person;
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    private Person5() {
    }
    public static Person5 getPerson5() {
        if (person == null) {
            synchronized (Person5.class) {
                if (person == null) {
                    person = new Person5();
                }
            }
        }
        return person;
    }
}
```
