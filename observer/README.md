# 观察者模式

## 1. 什么是观察者模式

Observer 模式是行为模式之一，它的作用是当个对象的状态发生变化时，能够自动通知其他关联对象，自动刷新对象状态。

Observer 模式提供给关联对象一种同步通信的手段，使某个对象与依赖它的其他对象之间保持状态同步。

## 2. 观察者模式的结构

![观察者模式](https://cdn.jsdelivr.net/gh/happyflyer/picture-bed@main/2020/观察者模式.5ntjxdzf4240.png)

## 3. 观察者模式的角色和职责

- Subject(被观察者)：被观察的对象。当需要被观察的状态发生变化时，需要通知队列中所有观察者对象。Subject 需要维持（添加、删除、通知）一个观察者对象的队列列表。
- Concrete Subject：被观察者的具体实现。包含一些基本的属性状态及其他操作。
- Observer(观察者)：接口或抽象类。当 Subject 的状态发生变化时，Observer 对象将通过 callback 函数得到通知。
- Concrete Observer：观察者的具体实现。得到通知后将完成一些具体的业务逻辑处理。

## 4. 观察者模式的经典应用

- 侦听事件驱动程序设计中的外部事件。
- 侦听/监视某个对象的状态变化。
- 发布者/订阅者(publisher/subscriber)模型中，当一个外部事件（新的产品，消息的出现等等）被触发时，通知邮件列表中的订阅者。

## 5. 代码演示

### 5.1. Person

```java
public class Person extends Observable {
    private String name;
    private int age;
    private String sex;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
        this.setChanged();
        this.notifyObservers();
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
        this.setChanged();
        this.notifyObservers();
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
        this.setChanged();
        this.notifyObservers();
    }
}
```

```java
public class MyObserver1 implements Observer {
    private final String name;
    public MyObserver1(String name) {
        this.name = name;
    }
    @Override
    public void update(Observable o, Object arg) {
        System.out.println(this.name + "：对象发生变化");
    }
}
```

```java
Person person = new Person();
person.addObserver(new MyObserver1("观察者1"));
person.addObserver(new MyObserver1("观察者2"));
System.out.println(person.countObservers());
person.setName("lifengxing");
person.setAge(23);
person.setSex("男");
```

```java
2
观察者2：对象发生变化
观察者1：对象发生变化
观察者2：对象发生变化
观察者1：对象发生变化
观察者2：对象发生变化
观察者1：对象发生变化
```

### 5.2. BlogUser

```java
public class Article {
    private String title;
    private String content;
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
}
```

```java
public class BlogUser extends Observable {
    public void publishBlog(String title, String content) {
        Article article = new Article();
        article.setTitle(title);
        article.setContent(content);
        System.out.println("博主：发表新文章，文章标题：" + title + "，文章内容：" + content);
        this.setChanged();
        this.notifyObservers(article);
    }
}
```

```java
public class MyObserver2 implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        Article article = (Article) arg;
        System.out.println("博主发布可新文章，快去看看吧");
        System.out.println("博客标题为：" + article.getTitle());
        System.out.println("博客内容为：" + article.getContent());
    }
}
```

```java
BlogUser blogUser = new BlogUser();
blogUser.addObserver(new MyObserver2());
blogUser.publishBlog("哈哈，博主上线了", "大家多来访问");
```

```java
博主：发表新文章，文章标题：哈哈，博主上线了，文章内容：大家多来访问
博主发布可新文章，快去看看吧
博客标题为：哈哈，博主上线了
博客内容为：大家多来访问
```
