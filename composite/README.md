# 组合模式

## 1. 什么是组合模式

Composite 模式也叫组合模式，是构造型的设计模式之一。通过递归手段来构造树形的对象结构，并可以通过一个对象来访问整个对象树。

## 2. 组合模式的结构

![组合模式](https://cdn.jsdelivr.net/gh/happyflyer/picture-bed@main/2020/组合模式.5c6or7rrkps0.png)

## 3. 组合模式的角色与职责

- Component（树形结构的节点抽象）
  - 为所有的对象定义统一的接口（公共属性，行为等的定义）
  - 提供管理子节点对象的接口方法
  - 【可选】提供管理父节点对象的接口方法
- Leaf（树形结构的叶节点）
  - Component 的实现子类
- Composite（树形结构的枝节点）
  - Component 的实现子类

## 4. 代码演示

```java
public interface IFile {
    void display();
    boolean add(IFile file);
    boolean remove(IFile file);
    List<IFile> getChild();
}
```

```java
public class File implements IFile {
    private final String name;
    public File(String name) {
        this.name = name;
    }
    @Override
    public void display() {
        System.out.println(name);
    }
    @Override
    public boolean add(IFile file) {
        return false;
    }
    @Override
    public boolean remove(IFile file) {
        return false;
    }
    @Override
    public List<IFile> getChild() {
        return null;
    }
}
```

```java
public class Folder implements IFile {
    private final String name;
    private final List<IFile> children;
    public Folder(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }
    @Override
    public void display() {
        System.out.println(name);
    }
    @Override
    public boolean add(IFile file) {
        return this.children.add(file);
    }
    @Override
    public boolean remove(IFile file) {
        return this.children.remove(file);
    }
    @Override
    public List<IFile> getChild() {
        return children;
    }
}
```

```java
public class Util {
    public static void displayTree(IFile iFile, int deep) {
        for (int i = 0; i < deep; i++) {
            System.out.print("--");
        }
        iFile.display();
        List<IFile> children = iFile.getChild();
        for (IFile file : children) {
            if (file instanceof File) {
                for (int i = 0; i <= deep; i++) {
                    System.out.print("--");
                }
                file.display();
            } else {
                displayTree(file, deep + 1);
            }
        }
    }
}
```

```java
IFile rootFolder = new Folder("C:");
IFile beiFengFolder = new Folder("beifeng");
IFile beiFengFile = new File("beifeng.txt");
rootFolder.add(beiFengFolder);
rootFolder.add(beiFengFile);
IFile iBeifengFolder = new Folder("ibeifeng");
IFile iBeifengFile = new File("ibeifeng.txt");
beiFengFolder.add(iBeifengFolder);
beiFengFolder.add(iBeifengFile);
IFile iiBeifengFolder = new Folder("iibeifeng");
IFile iiBeifengFile = new File("iibeifeng.txt");
iBeifengFolder.add(iiBeifengFolder);
iBeifengFolder.add(iiBeifengFile);
Util.displayTree(rootFolder, 0);
```

```java
C:
--beifeng
----ibeifeng
------iibeifeng
------iibeifeng.txt
----ibeifeng.txt
--beifeng.txt
```
