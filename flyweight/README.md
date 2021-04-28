# 享元模式

## 1. 什么是享元模式

Flyweight 模式也叫享元模式，是构造型模式之一，它通过与其他类似对象共享数据来减小内存占用。

## 2. 享元模式的结构

![享元模式](https://cdn.jsdelivr.net/gh/happyflyer/picture-bed@main/2020/享元模式.7e7m69b2ok00.png)

## 3. 享元模式的角色和职责

- 抽象享元角色：所有具体享元类的父类，规定一些需要实现的公共接口。
- 具体享元角色：抽象享元角色的具体实现类，并实现了抽象享元角色规定的方法。
- 享元工厂角色：负责创建和管理享元角色。

## 4. 代码演示

### 4.1. MyCharacter

```java
public class MyCharacter {
    private final char myChar;
    public MyCharacter(char myChar) {
        this.myChar = myChar;
    }
    public void display() {
        System.out.println(myChar);
    }
}
```

```java
public class MyCharacterFactory {
    private final Map<Character, MyCharacter> pool;
    public MyCharacterFactory() {
        this.pool = new HashMap<>();
    }
    public MyCharacter getMyCharacter(Character character) {
        MyCharacter myChar = this.pool.get(character);
        if (myChar == null) {
            myChar = new MyCharacter(character);
            this.pool.put(character, myChar);
        }
        return myChar;
    }
}
```

```java
MyCharacter myChar1 = new MyCharacter('a');
MyCharacter myChar2 = new MyCharacter('b');
MyCharacter myChar3 = new MyCharacter('a');
MyCharacter myChar4 = new MyCharacter('d');
myChar1.display();
myChar2.display();
myChar3.display();
myChar4.display();
System.out.println(myChar1 == myChar3);
```

```java
a
b
a
d
false
```

```java
MyCharacterFactory factory = new MyCharacterFactory();
MyCharacter myChar1 = factory.getMyCharacter('a');
MyCharacter myChar2 = factory.getMyCharacter('b');
MyCharacter myChar3 = factory.getMyCharacter('a');
MyCharacter myChar4 = factory.getMyCharacter('d');
myChar1.display();
myChar2.display();
myChar3.display();
myChar4.display();
System.out.println(myChar1 == myChar3);
```

```java
a
b
a
d
true
```

### 4.2. Teacher

```java
public class Person {
    private String name;
    private int age;
    private String sex;
    public Person() {
    }
    public Person(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
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
}
```

```java
public class Teacher extends Person {
    private String number;
    public Teacher(String number) {
        super();
        this.number = number;
    }
    public Teacher(String name, int age, String sex, String number) {
        super(name, age, sex);
        this.number = number;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    @Override
    public String toString() {
        return "Teacher{" +
                "number='" + number + '\'' +
                '}';
    }
}
```

```java
public class TeacherFactory {
    private final Map<String, Teacher> pool;
    public TeacherFactory() {
        this.pool = new HashMap<>();
    }
    public Teacher getTeacher(String number) {
        Teacher teacher = this.pool.get(number);
        if (teacher == null) {
            teacher = new Teacher(number);
            this.pool.put(number, teacher);
        }
        return teacher;
    }
}
```

```java
TeacherFactory factory = new TeacherFactory();
Teacher teacher1 = factory.getTeacher("0102034");
Teacher teacher2 = factory.getTeacher("0102035");
Teacher teacher3 = factory.getTeacher("0102034");
Teacher teacher4 = factory.getTeacher("0102037");
System.out.println(teacher1);
System.out.println(teacher2);
System.out.println(teacher3);
System.out.println(teacher4);
System.out.println(teacher1 == teacher3);
```

```java
Teacher{number='0102034'}
Teacher{number='0102035'}
Teacher{number='0102034'}
Teacher{number='0102037'}
true
```
