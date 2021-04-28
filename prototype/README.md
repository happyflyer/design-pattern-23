# 原型模式

## 1. 什么是原型模式

Prototype 模式是一种对象创建型模式，它采取复制原型对象的方法来创建对象的实例。使用 Prototype 模式创建的实例，具有与原型一样的数据。

## 2. 原型模式的特点

1. 由原型对象自身创建目标对象。也就是说，对象创建这一动作发自原型对象本身。
2. 目标对象是原型对象的一个克隆。也就是说，通过 Prototype 模式创建的对象，不仅仅与原型对象具有相同的结构，还与原型对象具有相同的值。
3. 根据对象克隆深度层次的不同，有浅度克隆与深度克隆。

## 3. 原型模式应用场景

- 在创建对象的时候，我们不只是希望被创建的对象继承其基类的基本结构，还希望继承原型对象的数据。
- 希望对目标对象的修改不影响既有的原型对象（深度克隆的时候可以完全互不影响）
- 隐藏克隆操作的细节。很多时候，对对象本身的克隆需要涉及到类本身的数据细节。

## 4. 代码演示

### 4.1. 直接创建

```java
public class Person1 {
    private String name;
    private int age;
    private String sex;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    @Override
    public String toString() {
        return "Person1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
```

```java
Person person1 = new Person1();
person1.setName("lifengxing");
person1.setAge(30);
person1.setSex("男");
Person person2 = new Person1();
person2.setName("beifeng");
person2.setAge(30);
person2.setSex("男");
System.out.println(person1);
System.out.println(person2);
```

```java
Person1{name='lifengxing', age=30, sex='男'}
Person1{name='beifeng', age=30, sex='男'}
```

### 4.2. 使用克隆

```java
public class Person2 implements Cloneable {
    // ...
    @Override
    protected Person2 clone() {
        try {
            return (Person2) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
```

```java
Person2 person1 = new Person2();
person1.setName("lifengxing");
person1.setAge(30);
person1.setSex("男");
Person2 person2 = person1.clone();
person2.setName("厉风行");
System.out.println(person1);
System.out.println(person2);
```

```java
Person2{name='lifengxing', age=30, sex='男'}
Person2{name='厉风行', age=30, sex='男'}
```

### 4.3. 浅度克隆

```java
public class Person3 implements Cloneable {
    // ...
    private List<String> friends;
    // ...
    @Override
    protected Person3 clone() {
        try {
            return (Person3) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
```

```java
Person3 person1 = new Person3();
person1.setName("lifengxing");
List<String> friends = new ArrayList<>();
friends.add("James");
friends.add("Yao");
person1.setFriends(friends);
Person3 person2 = person1.clone();
person2.setName("厉风行");
System.out.println(person1);
System.out.println(person2);
System.out.println(person1.getFriends());
System.out.println(person2.getFriends());
friends.add("Mike");
person1.setFriends(friends);
System.out.println(person1.getFriends());
System.out.println(person2.getFriends());
```

```java
Person3{name='lifengxing', age=0, sex='null', friends=[James, Yao]}
Person3{name='厉风行', age=0, sex='null', friends=[James, Yao]}
[James, Yao]
[James, Yao]
[James, Yao, Mike]
[James, Yao, Mike]
```

### 4.4. 深度克隆

```java
public class Person4 implements Cloneable {
    // ...
    @Override
    protected Person4 clone() {
        try {
            Person4 person = (Person4) super.clone();
            List<String> friends = new ArrayList<>(this.getFriends());
            person.setFriends(friends);
            return person;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
```

```java
Person4 person1 = new Person4();
person1.setName("lifengxing");
List<String> friends = new ArrayList<>();
friends.add("James");
friends.add("Yao");
person1.setFriends(friends);
Person4 person2 = person1.clone();
person2.setName("厉风行");
System.out.println(person1);
System.out.println(person2);
System.out.println(person1.getFriends());
System.out.println(person2.getFriends());
friends.add("Mike");
person1.setFriends(friends);
System.out.println(person1.getFriends());
System.out.println(person2.getFriends());
```

```java
Person3{name='lifengxing', age=0, sex='null', friends=[James, Yao]}
Person3{name='厉风行', age=0, sex='null', friends=[James, Yao]}
[James, Yao]
[James, Yao]
[James, Yao, Mike]
[James, Yao]
```
