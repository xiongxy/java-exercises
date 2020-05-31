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

实现全球化的 Data

```
Calendar instance = Calendar.getInstance();
```

# 集合

## 集合的顶层框架结构 `java.util.Collection` 和 `java.util.Map`

### Collection 集合

`java.util.Collection` 接口是`List`接口，`Queue`接口以及`Set`接口的父接口。

### Iterator 接口

- `java.util.Iterator` 接口主要用来描述迭代器对象，可以遍历 Collection 集合中的所有元素
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

- `java.util.List`集合是 Collection 集合的子集合，该集合中允许有重复的元素，并且有先后放入顺序。
- `java.util.List`的实现类，有`ArrayList`、`LinkedList`、`Stack`、`Vector`
- `ArrayList`底层采用动态数组进行数据管理，扩容数组  
  底层：原始长度\*1.5
- `LinkedList`底层采用双向链表进行数据管理
- `Stack` 底层采用动态数组进行数据管理，使用栈(后进先出)特殊结构来管理数据
- `Vector` 底层采用动态数组进行数据管理，该类与`ArrayList`相比是线程安全的类 底层扩大于 2 倍

### Queue 集合

- `java.util.Queue`集合是 Collection 集合的子集合,与 List 属于平级关系
- 该集合主的描述为先进先出的特殊数据结构，称为`队列`
- 该集合主要的实现类为`LinkedList`类

# 泛型

非泛型 Collection 使用 Ojbect 存储数据，这样可以存储各种不一样的数据类型，取出数据时也是 Object 类型，如果需要真实数据类型，则需要强制转换，容易出错。  
于是在`java5`推出了泛型机制，在编译期间强制要求数据类型一致，运行时不区分数据类型。

## 泛型的通配符

- `ArrayList<?> arrayList = new ArrayList<>;`  
  无限制通配符，表示我们可以传入任意类型的参数
- `ArrayList<? extend E> arrayList = new ArrayList<>;`  
  表示类型的上界是 E ，只能是 E 或者 E 的子类
- `ArrayList<? super E> arrayList = new ArrayList<>;`  
  表示类型的下界是 E ，只能是 E 或者 E 的父类

# Set 集合

- `java.util.Set`集合是 Collection 集合的子集合，与 List 集合平级
- 该集合中元素没有先后顺序，且不允许重复
- 该集合的实现类主要是`HashSet`类、`TreeSet`类、`LinkedHashSet`类

## HashSet 类

- 底层的主要实现是采用哈希表进行数据管理的

## TreeSet 类

- 底层的主要实现是采用红黑树进行数据管理的

## LinkedHashSet 类

- 与 HashSet 不同的是内部维护了一个双向链表，链表记录了元素的顺序，也就是元素插入集合中先后顺序。

# Map 集合

- java.util.Map<K,V> 集合中存取元素的基本单位：单对元素
- 该集合的实现类主要是`HashMap`类、`TreeMap`类、`LinkedHashMap`类、`HashTable`类、`Properties`类

## HashMap

- 底层采用哈希表进行数据管理
- 扩容因子为 0.75 默认容量为 16
- 如果容量过多，会转换成红黑树进行数据管理

## TreeMap

- 底层采用红黑树进行数据管理

## LinkedHashMap 类

- 与 HashMap 不同的是内部维护了一个双向链表，链表记录了元素的顺序，也就是元素插入集合中先后顺序

## HashTable 类

- 是古老的 Map 实现类，与 HashMap 相比属于线程安全的类，且不允许 null 作为 Key 或者 Value 的值

## Properties 类

- HashTable 类的子类，该对象用于处理属性文件，key 和 value 都是 String 类型的

# Collections 类

- java.util.Collection 类主要提供了对集合操作的静态方法

# 异常机制

- `java.lang.Throwable`类是`java`语言中错误(Error)和异常(Exception)的超类

## 异常的分类

- `java.lang.Exception`类是所有异常的超类主要分为以下两种
  - `RuntimeException` 运行时异常，也叫作非检测性异常
  - `IOException`和其他异常 也叫作检测性异常，所谓检测性异常是指在编译阶段就能被发现的异常

## finally

- 通常作为善后处理，在 cache 结束后调用。如果 cache 中有 return，那么先 retrun 前调用。
- finally 无法改变 cache retun 的值

## 异常的抛出

- 通过在方法后面加上 `throw Exception` 抛出异常
- 通过 `thrwo new Exception` 抛出异常
  子类重写的方法不能抛出更大的异常或者平级的异常

## 自定义异常

通过继承`Exception`类，实现自定义异常。

- 实现有参、无参构造方法，以及序列化版本号

# File 类

- `java.io.File`类主要用于描述文件或者目录路径的抽象表示信息，可以获取文件或者目录的特征信息。

# IO 流

- IO 就是 Input 和 Output 的简写，输入输出的含义
- IO 流是指在读写数据以抽象方式`流`一样传递

## 基本分类

- 按照读写数据的基本单位不同，分为`字节流`,`字符流`
  - `字节流` 以字节为单位进行数据读写的流，可以读写任意类型的文件
  - `字符流` 以字符(2 个字节)为单位进行数据读写的流，只能读写文本文件
- 按照读写数据的方向不同，分为`输入流`,`输出流`
  - `输入流` 从文件中读取数据内容中
  - `输出流` 程序中的数据输出到文件中
- 按照流的角色不同，分为`节点流`,`处理流`
  - `节点流` 指直接和输入输出源对接的流
  - `处理流` 建立在`节点流`基础上的流

## IO 流的体系结构

- 抽象类 字节流 `InputStream` `OutputStream`
- 抽象类 字符流 `Reader` `Writer`

## 相关流介绍

### FileWriter

- java.io.FileWriter 类主要用于将文本内容写入到文本文件中

### FileReader

- java.io.FileReader

# 多线程

## 线程的创建

### Thread 类的概念

- java.lang.Thread 类代表线程，任何线程对象都是 Thread 类的实例。
- Thread 类是线程的模板，封装了复杂的线程开启等操作，封装了操作系统的差异性

### 创建方式
- 自定义类继承Thread类并重写Run方法，然后创建该类的对象调用start方法。
- 自定义类实现Runnable接口并重写run方法，创建该类的对象作为实参来构造Thread类型的对象，然后使用Thread类型的对象调用start方法。

### 执行流程
- 调用start方法，ava虚拟机会自动调用该线程类中的run方法
- 如果直接调用run方法，等同于没有启动线程调用
- 执行main方法的线程叫做主线程，执行run方法的线程叫做新线程。


### 线程的生命周期
- 创建状态
- 就绪状态
- 运行状态
- 消亡状态
- 阻塞状态

### 线程的编号和名称
Thread类通过
- `getId()`获取线程的编号
- `getName()`获取线程的名称
- `setName(String name)`设置修改线程的名称
- `Thread.currentThread()`获取当前正在执行线程的引用


### 线程的同步机制

#### synchronized
使用`synchronized`关键字来实现同步锁机制从而保证线程执行的原子性
- 使用同步代码块来实现
```java
private Object obj = new Object();
synchronized(引用类型的实例){

}
```

- 使用同步方法的方式来实现
使用`synchronized`关键字来修饰整个方法，等价于`synchronized(this)`
当修饰的是静态方法时，等价于等价于`synchronized(类名.class)`
 
#### lock
- 从java5开始提供更强大的线程同步机制——使用显示定义同步锁来实现
- java.util.concurrent.locks.Lock 接口是控制多个线程对共享资源进行访问的工具
- 该接口的主要实现类是`ReentrantLock`类，该类拥有与`synchronized`相同的并发性，在以后的线程安全控制中，经常使用`ReentrantLock`类显示加锁和释放锁

PS： 使用Lock锁方式时，java虚拟机将花费更少的时间来调度线程，所以性能更好。

 

 ### 线程池
 - java5 开始提供了线程池的相关类和接口: 
    - `java.util.concurrent.Executors`类
    - `java.util.concurrent.ExecutorService` 接口


 
# 网络编程


## 七层模型
- OSI(open system interconnect) ,开放式系统互联
- OSI七层模型 应用层 -> 表示层 -> 会话层 -> 传输层 -> 网络层 -> 数据链路层 -> 物理层


## 基于TCP协议
- java.net.ServerSocket 类
用于描述服务器套接字信息
- java.net.Socket 类
用于描述客户端套接字信息


## 基于UDP协议
- java.net.DatagramSocket 类
用于描述发送和接收数据报的套接字
- java.net.DatagramPacket 类
用于描述数据报信息

## URL类
- java.net.URL 类主要表示统一的资源定位器