# 迭代模式

## 1. 什么是迭代模式

Iterator 模式也叫迭代模式，是行为模式之一，它把对容器中包舍的内部对象的访问委让给外部类，使用 Iterator（遍历）按顺序进行遍历访问的设计模式

## 2. 不使用迭代模式的应用

在应用 Iterator 模式之前，首先应该明白 Iterator 模式用来解决什么问题。或者说，如果不使用 Iterator 模式，会存在什么问题。

1. 由容器自己实现顺序遍历。直接在容器类里直接添加顺序遍历方法。
2. 让调用者自己实现遍历。直接暴露数据细节给外部。

## 3. 不使用迭代模式的缺点

以上方法 1 与方法 2 都可以实现对遍历，这样有问题呢？

1. 容器类承担了太多功能：一方面需要提供添加删除等本身应有的功能；一方面还需要提供遍历访问功能。
2. 往往容器在实现遍历的过程中，需要保存遍历状态，当跟元素的添加删除等功能夹杂在一起，很容易引起混乱和程序运行错误等。

## 4. 使用迭代模式的应用

Iterator 模式就是为了有效地处理按顺序进行遍历访问的一种设计模式，简单地说，Iterator 模式提供一种有效的方法，可以屏蔽聚集对象集合的容器类的实现细节，而能对容器内包含的对象元素按顺序进行有效的遍历访问。

所以， Iterator 模式的应用场景可以归纳为满足以下几个条件：

- 访问容器中包含的内部对象
- 按顺序访问

## 5. 迭代模式的结构

![迭代模式](https://cdn.jsdelivr.net/gh/happyflyer/picture-bed@main/2020/迭代模式.2kuva2xqhrs0.png)

## 6. 迭代模式的角色与职责

- Iterator（迭代器接口）：该接口必须定义实现迭代功能的最小定义方法集比如提供 hasNext（）和 next（）方法。
- ConcreteIterator（迭代器实现类）：迭代器接口 Iterator 的实现类。可以根据具体情况加以实现。
- Aggregate（容器接口）定义基本功能以及提供类似 Iterator iterator()的方法。
- concrete Aggregate（容器实现类）：容器接口的实现类。必须实现 Iterator iterator() 方法。

## 7. 迭代模式的优点

1. 实现功能分离，简化容器接口。让容器只实现本身的基本功能，把迭代功能委让给外部类实现，符合类的设计原则。
2. 隐藏容器的实现细节。
3. 为容器或其子容器提供了一个统一接口，一方面方便调用；另一方面使得调用者不必关注迭代器的实现细节。
4. 可以为容器或其子容器实现不同的迭代方法或多个迭代方法。

## 8. 代码演示

```java
public class Book {
    private String isbn;
    private String name;
    private double price;
    public Book(String isbn, String name, double price) {
        this.isbn = isbn;
        this.name = name;
        this.price = price;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
```

### 8.1. 容器实现遍历

```java
public class BookList1 {
    private final List<Book> bookList;
    private int index;
    public BookList1() {
        this.bookList = new ArrayList<>();
    }
    public void addBook(Book book) {
        this.bookList.add(book);
    }
    public void removeBook(Book book) {
        bookList.remove(book);
    }
    public boolean hasNext() {
        return index < bookList.size();
    }
    public Book getNext() {
        return this.bookList.get(index++);
    }
}
```

```java
BookList1 bookList = new BookList1();
Book book1 = new Book("010203", "Java编程思想", 90);
Book book2 = new Book("010204", "Java从入门到精通", 60);
bookList.addBook(book1);
bookList.addBook(book2);
while (bookList.hasNext()) {
    System.out.println(bookList.getNext());
}
```

### 8.2. 调用者实现遍历

```java
public class BookList2 {
    private final List<Book> bookList;
    public BookList2() {
        this.bookList = new ArrayList<>();
    }
    public void addBook(Book book) {
        this.bookList.add(book);
    }
    public void removeBook(Book book) {
        bookList.remove(book);
    }
    public List<Book> getBookList() {
        return this.bookList;
    }
}
```

```java
BookList2 bookList = new BookList2();
Book book1 = new Book("010203", "Java编程思想", 90);
Book book2 = new Book("010204", "Java从入门到精通", 60);
bookList.addBook(book1);
bookList.addBook(book2);
for (Book book : bookList.getBookList()) {
    System.out.println(book);
}
```

### 8.3. 使用迭代模式

```java
public class BookList {
    private final List<Book> bookList;
    private int index;
    public BookList() {
        this.bookList = new ArrayList<>();
    }
    public void addBook(Book book) {
        this.bookList.add(book);
    }
    public void removeBook(Book book) {
        bookList.remove(book);
    }
    public Iterator<Book> getIterator() {
        return new Itr();
    }
    private class Itr implements Iterator<Book> {
        @Override
        public boolean hasNext() {
            return index < bookList.size();
        }
        @Override
        public Book next() {
            return bookList.get(index++);
        }
        @Override
        public void remove() {
        }
        @Override
        public void forEachRemaining(Consumer action) {
        }
    }
}
```

```java
BookList bookList = new BookList();
Book book1 = new Book("010203", "Java编程思想", 90);
Book book2 = new Book("010204", "Java从入门到精通", 60);
bookList.addBook(book1);
bookList.addBook(book2);
Iterator<Book> iter = bookList.getIterator();
while (iter.hasNext()) {
    System.out.println(iter.next());
}
```
