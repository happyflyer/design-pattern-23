# 中介者模式

## 1. 什么是中介者模式

Mediator 模式也叫中介者模式，是由 GOF 提出的 23 种软件设计模式的一种。 Mediator 模式是行为模式之一。在 Mediator 模式中，类之间的交互行为被统一放在 Mediator 的对象中，对象通过 Mediator 对象同其他对象交互， Mediator 对象起着控制器的作用。

## 2. 中介者模式的结构

![中介者模式](https://cdn.jsdelivr.net/gh/happyflyer/picture-bed@main/2020/中介者模式.3f6zyph8ins.png)

## 3. 中介者模式的角色和职责

- mediator 中介者类的抽象父类。
- concreteMediator 具体的中介者类。
- colleague 关联类的抽象父类。
- concreteColleague 具体的关联类。

## 4. 中介者模式的优点

1. 将系统按功能分割成更小的对象，符合类的最小设计原则。
2. 对关联对象的集中控制。
3. 减小类的耦合程度，明确类之间的相互关系：当类之间的关系过于复杂时，其中任何一个类的修改都会影响到其他类，不符合类的设计的开闭原则，而 Mediator 模式将原来相互依存的多对多的类之间的关系简化为 Mediator 控制类与其他关联类的一对多的关系，当其中一个类修改时，可以对其他关联类不产生影响（即使有修改，也集中在 Mediator 控制类）。
4. 有利于提高类的重用性

## 5. 代码演示

### 5.1. 不使用中介者

```java
public abstract class Person {
    private String name;
    private int condition;
    public Person(String name, int condition) {
        this.name = name;
        this.condition = condition;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getCondition() {
        return condition;
    }
    public void setCondition(int condition) {
        this.condition = condition;
    }
    public abstract void getPartner(Person person);
}
```

```java
public class Man extends Person {
    public Man(String name, int condition) {
        super(name, condition);
    }
    @Override
    public void getPartner(Person person) {
        if (person instanceof Man) {
            System.out.println("汗，我不是同性恋！");
        } else {
            if (this.getCondition() == person.getCondition()) {
                System.out.println(this.getName() + "和" + person.getName() + "绝配");
            } else {
                System.out.println(this.getName() + "和" + person.getName() + "不相配");
            }
        }
    }
}
```

```java
public class Woman extends Person {
    public Woman(String name, int condition) {
        super(name, condition);
    }
    @Override
    public void getPartner(Person person) {
        if (person instanceof Man) {
            System.out.println("汗，我不是同性恋！");
        } else {
            if (this.getCondition() == person.getCondition()) {
                System.out.println(this.getName() + "和" + person.getName() + "绝配");
            } else {
                System.out.println(this.getName() + "和" + person.getName() + "不相配");
            }
        }
    }
}
```

```java
Person zhangsan = new Man("张三", 5);
Person lisi = new Man("李四", 6);
Person xiaofang = new Woman("小芳", 6);
zhangsan.getPartner(xiaofang);
lisi.getPartner(xiaofang);
zhangsan.getPartner(lisi);
```

```java
张三和小芳不相配
李四和小芳绝配
汗，我不是同性恋！
```

### 5.2. 使用中介者

```java
public abstract class Person {
    private String name;
    private int condition;
    private Mediator mediator;
    public Person(String name, int condition, Mediator mediator) {
        this.name = name;
        this.condition = condition;
        this.mediator = mediator;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getCondition() {
        return condition;
    }
    public void setCondition(int condition) {
        this.condition = condition;
    }
    public Mediator getMediator() {
        return mediator;
    }
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }
    public abstract void getPartner(Person person);
}
```

```java
public class Mediator {
    private Man man;
    private Woman woman;
    public void setMan(Man man) {
        this.man = man;
    }
    public void setWoman(Woman woman) {
        this.woman = woman;
    }
    public void getPartner(Person person) {
        if (person instanceof Man) {
            this.setMan((Man) person);
        } else {
            this.setWoman((Woman) person);
        }
        if (man == null || woman == null) {
            System.out.println("汗，我不是同性恋！");
        } else {
            if (man.getCondition() == woman.getCondition()) {
                System.out.println(man.getName() + "和" + woman.getName() + "绝配");
            } else {
                System.out.println(man.getName() + "和" + woman.getName() + "不相配");
            }
        }
    }
}
```

```java
public class Man extends Person {
    public Man(String name, int condition, Mediator mediator) {
        super(name, condition, mediator);
    }
    @Override
    public void getPartner(Person person) {
        this.getMediator().setMan(this);
        this.getMediator().setWoman(null);
        this.getMediator().getPartner(person);
    }
}
```

```java
public class Woman extends Person {
    public Woman(String name, int condition, Mediator mediator) {
        super(name, condition, mediator);
    }
    @Override
    public void getPartner(Person person) {
        this.getMediator().setWoman(this);
        this.getMediator().setMan(null);
        this.getMediator().getPartner(person);
    }
}
```

```java
Mediator mediator = new Mediator();
Person zhangsan = new Man("张三", 5, mediator);
Person lisi = new Man("李四", 6, mediator);
Person xiaofang = new Woman("小芳", 6, mediator);
zhangsan.getPartner(xiaofang);
lisi.getPartner(xiaofang);
zhangsan.getPartner(lisi);
```

```java
张三和小芳不相配
李四和小芳绝配
汗，我不是同性恋！
```
