# JavaEE 常用包

- java.lang java 核心包，该包中的所有内容由 java 虚拟机自动导入，并且唯一只有这一个包是自动导入的。
- java.util java 工具包，大量工具类和集合类
- java.io java 输入输出包，大量读写文件相关的
- java.net java 网络包，大量网络编程相关
- java.sql java 数据包，大量操作数据库的类和接口

# Java Object

`Object`类是所有的类的祖宗，所有的类都直接或间接继承自`Object`

# 包装类

| 基本数据类型 | 包装类型  |
| ------------ | --------- |
| int          | Integer   |
| byte         | Byte      |
| boolean      | Boolean   |
| long         | Long      |
| float        | Float     |
| double       | Double    |
| char         | Character |
| short        | Short     |

## 装箱和拆箱

基本数据类型 到 包装类型 为装箱，包装类型 到 基本数据类型 为拆箱。

### Integer 中的自动装箱池

在 Integer 类的内部提供了自动装箱池的技术，将-128~127 之间的整数已经装箱完毕，当程序中使用该范围之间的整数时，无需装箱直接取用自动装箱池中的对象，从而提高性能。

# String 类

- 直接继承自 Object 类。
- 从 jdk1.9 版本开始，该类的底层不在使用`char[]`存储数据，而是使用`byte[]`加上编码标记，从而节约了一些空间。
- 该类描述的字符串内容是个常量不可更改，因此可以被共享使用

## 常量池

由于 String 类型描述的字符串内容是常量不可以改变，因此 JAVA 虚拟机将首次出现的字符串放入常量池中，若后续代码中出现了相同字符串内容则直接使用池中已有的字符串对象而无需申请内存及创建对象，从而提高了性能。

# 可变字符串

`StringBuilder` 和 `StringBuffer`

- `StringBuffer` jdk1.0 新增的，属于线程安全的类，性能较低。  
  `StringBuffer` 存在 capacity 的设置，底层的实现为`char[]`数组，进行扩容，但是每个方法都加上了同步块`synchronized`
- `StringBuilder` jdk1.5 新增的，属于非线程安全的类，性能高。  
  `StringBuilder` 存在 capacity 的设置，底层的实现为`char[]`数组，进行扩容。


# Canlendar 类型
实现全球化的Data
```
Calendar instance = Calendar.getInstance();
```


# 集合

## 集合的顶层框架结构 `java.util.Collection` 和 `java.util.Map`

### Collection 集合
`java.util.Collection` 接口是`List`接口，`Queue`接口以及`Set`接口的父接口。

### Iterator 接口
- `java.util.Iterator` 接口主要用来描述迭代器对象，可以遍历Collection集合中的所有元素
- `java.util.Collection` 接口继承自`Iterator` 对象 

```java
public class main {
    public static void main(String[] args) {
        Collection c1 = new ArrayList();
        c1.add(1);
        c1.add("真三");

        Iterator iterator = c1.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
```

### for each 循环
```java
public class main {
    public static void main(String[] args) {
        Collection c1 = new ArrayList();
        c1.add(1);
        c1.add("真三");

        for (Object j : c1) {
            System.out.println(j);
        }
    }
}
```


### List 集合
- `java.util.List`集合是Collection集合的子集合，该集合中允许有重复的元素，并且有先后放入顺序。
- `java.util.List`的实现类，有`ArrayList`、`LinkedList`、`Stack`、`Vector`
- `ArrayList`底层采用动态数组进行数据管理，扩容数组  
底层：原始长度*1.5
- `LinkedList`底层采用双向链表进行数据管理 
- `Stack` 底层采用动态数组进行数据管理，使用栈(后进先出)特殊结构来管理数据
- `Vector` 底层采用动态数组进行数据管理，该类与`ArrayList`相比是线程安全的类 底层扩大于2倍


### Queue集合
- `java.util.Queue`集合是Collection集合的子集合,与List属于平级关系
- 该集合主的描述为先进先出的特殊数据结构，称为`队列`
- 该集合主要的实现类为`LinkedList`类


# 泛型
非泛型Collection使用Ojbect存储数据，这样可以存储各种不一样的数据类型，取出数据时也是Object类型，如果需要真实数据类型，则需要强制转换，容易出错。  
于是在`java5`推出了泛型机制，在编译期间强制要求数据类型一致，运行时不区分数据类型。