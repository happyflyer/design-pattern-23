# 命令模式

## 1. 什么是命令模式

Command 模武也叫命令模式，是行为设计模式的一种。Command 模式通过被称为 Command 的类封装了对目标对象的调用行为以及调用参数。

## 2. 命令模式的应用场景

在面向对象的程序设计中，一个对象调用另一个对象，一般情况下的调用过程是：创建目标对象实例；设置调用参数；调用目标对象的方法。

但在有些情况下有必要使用一个专门的类对这种调用过程加以封装，我们把这种专门的类称作 command 类。

- 整个调用过程比较繁杂，或者存在多处这种调用。这时，使用 Command 类对该调用加以封装，便于功能的再利用。
- 调用前后需要对调用参数进行某些处理。
- 调用前后需要进行某些额外处理，比如日志，缓存，记录历史操作等。

## 3. 命令模式的结构

![命令模式](https://cdn.jsdelivr.net/gh/happyflyer/picture-bed@main/2020/命令模式.4ts7zigs8140.jpg)

## 4. 命令模式的角色与职责

- Command：Command 抽象类。
- ConcreteCommand：Command 的具体实现类。
- Receiver：需要被调用的目标对象。
- Invoker：通过 Invoker 执行 Command 对象。

## 5. 代码演示

### 5.1. 不使用命令模式

```java
public class Peddler {
    public void sellApple() {
        System.out.println("卖苹果");
    }
    public void sellBanana() {
        System.out.println("卖香蕉");
    }
}
```

```java
Peddler peddler = new Peddler();
peddler.sellApple();
peddler.sellBanana();
```

### 5.2. Command

```java
public abstract class Command {
    private Peddler peddler;
    public Command(Peddler peddler) {
        this.peddler = peddler;
    }
    public Peddler getPeddler() {
        return peddler;
    }
    public void setPeddler(Peddler peddler) {
        this.peddler = peddler;
    }
    public abstract void sell();
}
```

```java
public class AppleCommand extends Command {
    public AppleCommand(Peddler peddler) {
        super(peddler);
    }
    @Override
    public void sell() {
        this.getPeddler().sellApple();
    }
}
```

```java
public class BananaCommand extends Command {
    public BananaCommand(Peddler peddler) {
        super(peddler);
    }
    @Override
    public void sell() {
        this.getPeddler().sellBanana();
    }
}
```

```java
Peddler peddler = new Peddler();
Command appleCommand = new AppleCommand(peddler);
Command bananaCommand = new BananaCommand(peddler);
appleCommand.sell();
bananaCommand.sell();
```

### 5.3. Waiter

```java
public class Waiter {
    private Command command;
    public Waiter() {
    }
    public Command getCommand() {
        return command;
    }
    public void setCommand(Command command) {
        this.command = command;
    }
    public void sell() {
        this.command.sell();
    }
}
```

```java
Peddler peddler = new Peddler();
Command appleCommand = new AppleCommand(peddler);
Command bananaCommand = new BananaCommand(peddler);
Waiter waiter = new Waiter();
waiter.setCommand(appleCommand);
waiter.sell();
waiter.setCommand(bananaCommand);
waiter.sell();
```

### 5.4. 改进 Waiter

```java
public class Waiter {
    private final List<Command> commands;
    public Waiter() {
        commands = new ArrayList<>();
    }
    public void addOrder(Command command) {
        this.commands.add(command);
    }
    public void removeOrder(Command command) {
        this.commands.remove(command);
    }
    public void sell() {
        for (Command command : commands) {
            command.sell();
        }
    }
}
```

```java
Peddler peddler = new Peddler();
Command appleCommand = new AppleCommand(peddler);
Command bananaCommand = new BananaCommand(peddler);
Waiter waiter = new Waiter();
waiter.addOrder(appleCommand);
waiter.sell();
System.out.println("==========");
waiter.addOrder(bananaCommand);
waiter.sell();
System.out.println("==========");
waiter.removeOrder(appleCommand);
waiter.sell();
```

```java
卖苹果
==========
卖苹果
卖香蕉
==========
卖香蕉
```
