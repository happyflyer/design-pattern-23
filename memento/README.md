# 备忘录模式

## 1. 什么是备忘录模式

Memento 模式也叫备忘录模式，是行为模式之一，它的作用是保存对象的内部状态，并在需要的时候（undo/rollback）恢复对象以前的状态。

## 2. 备忘录模式的应用场景

如果一个对象需要保存状态并可通过 undo 或 rollback 等操作恢复到以前的状态时，可以使用 Memento 模式。

1. 一个类需要保存它的对象的状态（相当于 Originator 角色）。
2. 设计一个类，该类只是用来保存上述对象的状态（相当于 Memento 角色）。
3. 需要的时候，Caretaker 角色要求 Originator 返回一个 Memento 并加以保存。
4. undo 或 rollback 操作时，通过 Caretaker 保存的 Memento 恢复 Originator 对象的状态。

## 3. 备忘录模式的结构

![备忘录模式](https://cdn.jsdelivr.net/gh/happyflyer/picture-bed@main/2020/备忘录模式.1okzrrakhdr4.png)

## 4. 备忘录模式的角色和职责

- Originator（原生者）：需要被保存状态以便恢复的那个对象
- Memento（备忘录）：该对象由 Originator 创建，主要用来保存 Originator 的内部状态。
- Caretaker（管理者）：负责在适当的时间保存恢复 Originator 对象的状态

## 5. 代码演示

### 5.1. 手动备份

```java
public class Person {
    private String name;
    private String sex;
    private int age;
    public Person() {
    }
    public Person(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}
```

```java
Person person = new Person("lifengxing", "男", 30);
Person backup = new Person();
backup.setName(person.getName());
backup.setSex(person.getSex());
backup.setAge(person.getAge());
System.out.println(person);
person.setAge(20);
System.out.println(person);
person.setName(backup.getName());
person.setSex(backup.getSex());
person.setAge(backup.getAge());
System.out.println(person);
```

```java
Person{name='lifengxing', sex='男', age=30}
Person{name='lifengxing', sex='男', age=20}
Person{name='lifengxing', sex='男', age=30}
```

### 5.2. 使用备忘录

```java
public class Person {
    // ...
    public Memento createMemento() {
        return new Memento(name, sex, age);
    }
    public void setMemento(Memento memento) {
        this.setName(memento.getName());
        this.setSex(memento.getSex());
        this.setAge(memento.getAge());
    }
}
```

```java
public class Memento {
    private String name;
    private String sex;
    private int age;
    public Memento(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
```

```java
public class Caretaker {
    private Memento memento;
    public Memento getMemento() {
        return memento;
    }
    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
```

```java
Person person = new Person("lifengxing", "男", 30);
Memento memento = person.createMemento();
System.out.println(person);
person.setAge(20);
System.out.println(person);
person.setMemento(memento);
System.out.println(person);
```

```java
Person person = new Person("lifengxing", "男", 30);
Caretaker caretaker = new Caretaker();
caretaker.setMemento(person.createMemento());
System.out.println(person);
person.setAge(20);
System.out.println(person);
person.setMemento(caretaker.getMemento());
System.out.println(person);
```
