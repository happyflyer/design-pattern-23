# 建造者模式

## 1. 什么是建造者模式

Builder 模式也叫建造者模式或者生成器模式，是由 GoF 提出的 23 种设计模式中的一种。

Builder 模式是一种对象创建型模式之一，用来隐藏复合对象的创建过程，它把复合对象的创建过程加以抽象，通过子类继承和重载的方式，动态地创建具有复合属性的对象。

## 2. 建造者模式的结构

![建造者模式](https://cdn.jsdelivr.net/gh/happyflyer/picture-bed@main/2020/建造者模式.4gckedz1cpa0.png)

## 3. 建造者模式应用场景

- 对象的创建：Builder 模式是为对象的。
- 创建而设计的模式创建的是一个复合对象：被创建的对象为一个具有复合属性的复合对象。
- 关注对象创建的各部分的创建过程：不同的工厂（这里指 builder 生成器）对产品属性有不同的创建方法。

## 4. 代码演示

### 4.1. 直接创建

```java
public class House {
    private String floor;
    private String wall;
    private String ceiling;
    public String getFloor() {
        return floor;
    }
    public void setFloor(String floor) {
        this.floor = floor;
    }
    public String getWall() {
        return wall;
    }
    public void setWall(String wall) {
        this.wall = wall;
    }
    public String getCeiling() {
        return ceiling;
    }
    public void setCeiling(String ceiling) {
        this.ceiling = ceiling;
    }
    @Override
    public String toString() {
        return "House{" +
                "floor='" + floor + '\'' +
                ", wall='" + wall + '\'' +
                ", ceiling='" + ceiling + '\'' +
                '}';
    }
}
```

```java
House house = new House();
house.setFloor("地板");
house.setWall("墙");
house.setCeiling("屋顶");
System.out.println(house);
```

### 4.2. 使用建造者

```java
public interface HouseBuilder {
    void makeFloor();
    void makeWall();
    void makeCeiling();
    House getHouse();
}
```

```java
public class PingFangBuilder implements HouseBuilder {
    House house = new House();
    @Override
    public void makeFloor() {
        house.setFloor("平房-->地板");
    }
    @Override
    public void makeWall() {
        house.setWall("平房-->墙");
    }
    @Override
    public void makeCeiling() {
        house.setCeiling("平房-->屋顶");
    }
    @Override
    public House getHouse() {
        return house;
    }
}
```

```java
HouseBuilder builder = new PingFangBuilder();
builder.makeFloor();
builder.makeWall();
builder.makeCeiling();
House house = builder.getHouse();
System.out.println(house);
```

### 4.3. 引入包工头

```java
public class HouseDirector {
    private final HouseBuilder builder;
    public HouseDirector(HouseBuilder builder) {
        this.builder = builder;
    }
    public void makeHouse() {
        builder.makeFloor();
        builder.makeWall();
        builder.makeCeiling();
    }
}
```

```java
HouseBuilder builder = new PingFangBuilder();
HouseDirector director = new HouseDirector(builder);
director.makeHouse();
House house = builder.getHouse();
System.out.println(house);
```

### 4.4. 新增建造者

```java
public class GongYuBuilder implements HouseBuilder {
    House house = new House();
    @Override
    public void makeFloor() {
        house.setFloor("公寓-->地板");
    }
    @Override
    public void makeWall() {
        house.setWall("公寓-->墙");
    }
    @Override
    public void makeCeiling() {
        house.setCeiling("公寓-->屋顶");
    }
    @Override
    public House getHouse() {
        return house;
    }
}
```

```java
HouseBuilder builder1 = new PingFangBuilder();
HouseDirector1 director1 = new HouseDirector1(builder1);
director1.makeHouse();
House house = builder1.getHouse();
System.out.println(house);
HouseBuilder builder2 = new GongYuBuilder();
HouseDirector1 director2 = new HouseDirector1(builder2);
director2.makeHouse();
House house2 = builder2.getHouse();
System.out.println(house2);
```

### 4.5. 另一种包工头

```java
public class HouseDirector3 {
    public void makeHouse(HouseBuilder builder) {
        builder.makeFloor();
        builder.makeWall();
        builder.makeCeiling();
    }
}
```

```java
HouseBuilder builder1 = new PingFangBuilder();
HouseDirector2 director1 = new HouseDirector2();
director1.makeHouse(builder1);
House house = builder1.getHouse();
System.out.println(house);
HouseBuilder builder2 = new GongYuBuilder();
HouseDirector2 director2 = new HouseDirector2();
director2.makeHouse(builder2);
House house2 = builder2.getHouse();
System.out.println(house2);
```
