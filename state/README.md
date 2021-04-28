# 状态模式

## 1. 什么是状态模式

State 模式也叫状态模式，是行为设计模式的一种。 State 模式允许通过改变对象的内部状态而改变对象的行为，这个对象表现得就好像修改了它的类一样。

## 2. 状态模式的应用场景

状态模式主要解决的是当控制一个对象状态转换的条件表达式过于复杂时的情况。把状态的判断逻辑转译到表现不同状态的一系列类当中，可以把复杂的判断逻辑简化。

## 3. 状态模式的结构

![状态模式](https://cdn.jsdelivr.net/gh/happyflyer/picture-bed@main/2020/状态模式.269rdf5mttmo.jpg)

## 4. 状态模式的角色和职责

- Context：用户对象拥有一个 State 类型的成员，以标识对象的当前状态。
- State：接口或基类封装与 Context 的特定状态相关的行为。
- ConcreteState：接口实现类或子类实现了一个与 Context 某个状态相关的行为。

## 5. 代码演示

### 5.1. 不使用状态模式

```java
public class Person {
    private int hour;
    public int getHour() {
        return hour;
    }
    public void setHour(int hour) {
        this.hour = hour;
    }
    public void doSomething() {
        if (hour == 7) {
            System.out.println("吃早餐");
        } else if (hour == 12) {
            System.out.println("吃午饭");
        } else if (hour == 18) {
            System.out.println("吃晚饭");
        } else {
            System.out.println(hour + "未定义");
        }
    }
}
```

```java
Person person = new Person();
person.setHour(7);
person.doSomething();
person.setHour(12);
person.doSomething();
person.setHour(18);
person.doSomething();
person.setHour(8);
person.doSomething();
```

```java
吃早餐
吃午饭
吃晚饭
8未定义
```

### 5.2. 使用状态模式

```java
public class Person {
    private int hour;
    private State state;
    // ...
    public void doSomething() {
        if (hour == 7) {
            state = new State7();
        } else if (hour == 12) {
            state = new State12();
        } else if (hour == 18) {
            state = new State18();
        } else {
            state = new NoState();
        }
        state.doOneThing();
    }
}
```

```java
public abstract class State {
    public abstract void doOneThing();
}
```

```java
public class State7 extends State {
    @Override
    public void doOneThing() {
        System.out.println("吃早餐");
    }
}
```

```java
public class State12 extends State {
    @Override
    public void doOneThing() {
        System.out.println("吃午饭");
    }
}
```

```java
public class State18 extends State {
    @Override
    public void doOneThing() {
        System.out.println("吃晚饭");
    }
}
```

```java
public class NoState extends State {
    @Override
    public void doOneThing() {
        System.out.println("未定义");
    }
}
```

### 5.3. 改进

```java
public class Person {
    private int hour;
    private State state;
    public Person() {
        this.state = new State7();
    }
    // ...
    public void doSomething() {
        this.state.doOneThing(this);
        this.state = new State7();
    }
}
```

```java
public abstract class State {
    public abstract void doOneThing(Person person);
}
```

```java
public class State7 extends State {
    @Override
    public void doOneThing(Person person) {
        if (person.getHour() == 7) {
            System.out.println("吃早餐");
        } else {
            person.setState(new State12());
            person.doSomething();
        }
    }
}
```

```java
public class State12 extends State {
    @Override
    public void doOneThing(Person person) {
        if (person.getHour() == 12) {
            System.out.println("吃午饭");
        } else {
            person.setState(new State18());
            person.doSomething();
        }
    }
}
```

```java
public class State18 extends State {
    @Override
    public void doOneThing(Person person) {
        if (person.getHour() == 18) {
            System.out.println("吃晚饭");
        } else {
            person.setState(new NoState());
            person.doSomething();
        }
    }
}
```

```java
public class NoState extends State {
    @Override
    public void doOneThing(Person person) {
        System.out.println(person.getHour() + "未定义");
    }
}
```

```java
Person person = new Person();
person.setHour(7);
person.doSomething();
person.setHour(12);
person.doSomething();
person.setHour(18);
person.doSomething();
person.setHour(8);
person.doSomething();
person.setHour(7);
person.doSomething();
person.setHour(18);
person.doSomething();
```

```java
吃早餐
吃午饭
吃晚饭
8未定义
吃早餐
吃晚饭
```
