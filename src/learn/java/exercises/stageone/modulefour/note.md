# JavaEE ���ð�

- java.lang java ���İ����ð��е����������� java ������Զ����룬����Ψһֻ����һ�������Զ�����ġ�
- java.util java ���߰�������������ͼ�����
- java.io java �����������������д�ļ���ص�
- java.net java ��������������������
- java.sql java ���ݰ��������������ݿ����ͽӿ�

# Java Object

`Object`�������е�������ڣ����е��඼ֱ�ӻ��Ӽ̳���`Object`

# ��װ��

| ������������ | ��װ����  |
| ------------ | --------- |
| int          | Integer   |
| byte         | Byte      |
| boolean      | Boolean   |
| long         | Long      |
| float        | Float     |
| double       | Double    |
| char         | Character |
| short        | Short     |

## װ��Ͳ���

������������ �� ��װ���� Ϊװ�䣬��װ���� �� ������������ Ϊ���䡣

### Integer �е��Զ�װ���

�� Integer ����ڲ��ṩ���Զ�װ��صļ�������-128~127 ֮��������Ѿ�װ����ϣ���������ʹ�ø÷�Χ֮�������ʱ������װ��ֱ��ȡ���Զ�װ����еĶ��󣬴Ӷ�������ܡ�

# String ��

- ֱ�Ӽ̳��� Object �ࡣ
- �� jdk1.9 �汾��ʼ������ĵײ㲻��ʹ��`char[]`�洢���ݣ�����ʹ��`byte[]`���ϱ����ǣ��Ӷ���Լ��һЩ�ռ䡣
- �����������ַ��������Ǹ��������ɸ��ģ���˿��Ա�����ʹ��

## ������

���� String �����������ַ��������ǳ��������Ըı䣬��� JAVA ��������״γ��ֵ��ַ������볣�����У������������г�������ͬ�ַ���������ֱ��ʹ�ó������е��ַ�����������������ڴ漰�������󣬴Ӷ���������ܡ�

# �ɱ��ַ���

`StringBuilder` �� `StringBuffer`

- `StringBuffer` jdk1.0 �����ģ������̰߳�ȫ���࣬���ܽϵ͡�  
  `StringBuffer` ���� capacity �����ã��ײ��ʵ��Ϊ`char[]`���飬�������ݣ�����ÿ��������������ͬ����`synchronized`
- `StringBuilder` jdk1.5 �����ģ����ڷ��̰߳�ȫ���࣬���ܸߡ�  
  `StringBuilder` ���� capacity �����ã��ײ��ʵ��Ϊ`char[]`���飬�������ݡ�

# Canlendar ����

ʵ��ȫ�򻯵� Data

```
Calendar instance = Calendar.getInstance();
```

# ����

## ���ϵĶ����ܽṹ `java.util.Collection` �� `java.util.Map`

### Collection ����

`java.util.Collection` �ӿ���`List`�ӿڣ�`Queue`�ӿ��Լ�`Set`�ӿڵĸ��ӿڡ�

### Iterator �ӿ�

- `java.util.Iterator` �ӿ���Ҫ�����������������󣬿��Ա��� Collection �����е�����Ԫ��
- `java.util.Collection` �ӿڼ̳���`Iterator` ����

```java
public class main {
    public static void main(String[] args) {
        Collection c1 = new ArrayList();
        c1.add(1);
        c1.add("����");

        Iterator iterator = c1.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
```

### for each ѭ��

```java
public class main {
    public static void main(String[] args) {
        Collection c1 = new ArrayList();
        c1.add(1);
        c1.add("����");

        for (Object j : c1) {
            System.out.println(j);
        }
    }
}
```

### List ����

- `java.util.List`������ Collection ���ϵ��Ӽ��ϣ��ü������������ظ���Ԫ�أ��������Ⱥ����˳��
- `java.util.List`��ʵ���࣬��`ArrayList`��`LinkedList`��`Stack`��`Vector`
- `ArrayList`�ײ���ö�̬����������ݹ�����������  
  �ײ㣺ԭʼ����\*1.5
- `LinkedList`�ײ����˫������������ݹ���
- `Stack` �ײ���ö�̬����������ݹ���ʹ��ջ(����ȳ�)����ṹ����������
- `Vector` �ײ���ö�̬����������ݹ���������`ArrayList`������̰߳�ȫ���� �ײ������� 2 ��

### Queue ����

- `java.util.Queue`������ Collection ���ϵ��Ӽ���,�� List ����ƽ����ϵ
- �ü�����������Ϊ�Ƚ��ȳ����������ݽṹ����Ϊ`����`
- �ü�����Ҫ��ʵ����Ϊ`LinkedList`��

# ����

�Ƿ��� Collection ʹ�� Ojbect �洢���ݣ��������Դ洢���ֲ�һ�����������ͣ�ȡ������ʱҲ�� Object ���ͣ������Ҫ��ʵ�������ͣ�����Ҫǿ��ת�������׳���  
������`java5`�Ƴ��˷��ͻ��ƣ��ڱ����ڼ�ǿ��Ҫ����������һ�£�����ʱ�������������͡�

## ���͵�ͨ���

- `ArrayList<?> arrayList = new ArrayList<>;`  
  ������ͨ�������ʾ���ǿ��Դ����������͵Ĳ���
- `ArrayList<? extend E> arrayList = new ArrayList<>;`  
  ��ʾ���͵��Ͻ��� E ��ֻ���� E ���� E ������
- `ArrayList<? super E> arrayList = new ArrayList<>;`  
  ��ʾ���͵��½��� E ��ֻ���� E ���� E �ĸ���

# Set ����

- `java.util.Set`������ Collection ���ϵ��Ӽ��ϣ��� List ����ƽ��
- �ü�����Ԫ��û���Ⱥ�˳���Ҳ������ظ�
- �ü��ϵ�ʵ������Ҫ��`HashSet`�ࡢ`TreeSet`�ࡢ`LinkedHashSet`��

## HashSet ��

- �ײ����Ҫʵ���ǲ��ù�ϣ��������ݹ����

## TreeSet ��

- �ײ����Ҫʵ���ǲ��ú�����������ݹ����

## LinkedHashSet ��

- �� HashSet ��ͬ�����ڲ�ά����һ��˫�����������¼��Ԫ�ص�˳��Ҳ����Ԫ�ز��뼯�����Ⱥ�˳��

# Map ����

- java.util.Map<K,V> �����д�ȡԪ�صĻ�����λ������Ԫ��
- �ü��ϵ�ʵ������Ҫ��`HashMap`�ࡢ`TreeMap`�ࡢ`LinkedHashMap`�ࡢ`HashTable`�ࡢ`Properties`��

## HashMap

- �ײ���ù�ϣ��������ݹ���
- ��������Ϊ 0.75 Ĭ������Ϊ 16
- ����������࣬��ת���ɺ�����������ݹ���

## TreeMap

- �ײ���ú�����������ݹ���

## LinkedHashMap ��

- �� HashMap ��ͬ�����ڲ�ά����һ��˫�����������¼��Ԫ�ص�˳��Ҳ����Ԫ�ز��뼯�����Ⱥ�˳��

## HashTable ��

- �ǹ��ϵ� Map ʵ���࣬�� HashMap ��������̰߳�ȫ���࣬�Ҳ����� null ��Ϊ Key ���� Value ��ֵ

## Properties ��

- HashTable ������࣬�ö������ڴ��������ļ���key �� value ���� String ���͵�

# Collections ��

- java.util.Collection ����Ҫ�ṩ�˶Լ��ϲ����ľ�̬����

# �쳣����

- `java.lang.Throwable`����`java`�����д���(Error)���쳣(Exception)�ĳ���

## �쳣�ķ���

- `java.lang.Exception`���������쳣�ĳ�����Ҫ��Ϊ��������
  - `RuntimeException` ����ʱ�쳣��Ҳ�����Ǽ�����쳣
  - `IOException`�������쳣 Ҳ����������쳣����ν������쳣��ָ�ڱ���׶ξ��ܱ����ֵ��쳣

## finally

- ͨ����Ϊ�ƺ����� cache ��������á���� cache ���� return����ô�� retrun ǰ���á�
- finally �޷��ı� cache retun ��ֵ

## �쳣���׳�

- ͨ���ڷ���������� `throw Exception` �׳��쳣
- ͨ�� `thrwo new Exception` �׳��쳣
  ������д�ķ��������׳�������쳣����ƽ�����쳣

## �Զ����쳣

ͨ���̳�`Exception`�࣬ʵ���Զ����쳣��

- ʵ���вΡ��޲ι��췽�����Լ����л��汾��

# File ��

- `java.io.File`����Ҫ���������ļ�����Ŀ¼·���ĳ����ʾ��Ϣ�����Ի�ȡ�ļ�����Ŀ¼��������Ϣ��

# IO ��

- IO ���� Input �� Output �ļ�д����������ĺ���
- IO ����ָ�ڶ�д�����Գ���ʽ`��`һ������

## ��������

- ���ն�д���ݵĻ�����λ��ͬ����Ϊ`�ֽ���`,`�ַ���`
  - `�ֽ���` ���ֽ�Ϊ��λ�������ݶ�д���������Զ�д�������͵��ļ�
  - `�ַ���` ���ַ�(2 ���ֽ�)Ϊ��λ�������ݶ�д������ֻ�ܶ�д�ı��ļ�
- ���ն�д���ݵķ���ͬ����Ϊ`������`,`�����`
  - `������` ���ļ��ж�ȡ����������
  - `�����` �����е�����������ļ���
- �������Ľ�ɫ��ͬ����Ϊ`�ڵ���`,`������`
  - `�ڵ���` ֱָ�Ӻ��������Դ�Խӵ���
  - `������` ������`�ڵ���`�����ϵ���

## IO ������ϵ�ṹ

- ������ �ֽ��� `InputStream` `OutputStream`
- ������ �ַ��� `Reader` `Writer`

## ���������

### FileWriter

- java.io.FileWriter ����Ҫ���ڽ��ı�����д�뵽�ı��ļ���

### FileReader

- java.io.FileReader

# ���߳�

## �̵߳Ĵ���

### Thread ��ĸ���

- java.lang.Thread ������̣߳��κ��̶߳����� Thread ���ʵ����
- Thread �����̵߳�ģ�壬��װ�˸��ӵ��߳̿����Ȳ�������װ�˲���ϵͳ�Ĳ�����

### ������ʽ
- �Զ�����̳�Thread�ಢ��дRun������Ȼ�󴴽�����Ķ������start������
- �Զ�����ʵ��Runnable�ӿڲ���дrun��������������Ķ�����Ϊʵ��������Thread���͵Ķ���Ȼ��ʹ��Thread���͵Ķ������start������

### ִ������
- ����start������ava��������Զ����ø��߳����е�run����
- ���ֱ�ӵ���run��������ͬ��û�������̵߳���
- ִ��main�������߳̽������̣߳�ִ��run�������߳̽������̡߳�


### �̵߳���������
- ����״̬
- ����״̬
- ����״̬
- ����״̬
- ����״̬

### �̵߳ı�ź�����
Thread��ͨ��
- `getId()`��ȡ�̵߳ı��
- `getName()`��ȡ�̵߳�����
- `setName(String name)`�����޸��̵߳�����
- `Thread.currentThread()`��ȡ��ǰ����ִ���̵߳�����


### �̵߳�ͬ������

#### synchronized
ʹ��`synchronized`�ؼ�����ʵ��ͬ�������ƴӶ���֤�߳�ִ�е�ԭ����
- ʹ��ͬ���������ʵ��
```java
private Object obj = new Object();
synchronized(�������͵�ʵ��){

}
```

- ʹ��ͬ�������ķ�ʽ��ʵ��
ʹ��`synchronized`�ؼ��������������������ȼ���`synchronized(this)`
�����ε��Ǿ�̬����ʱ���ȼ��ڵȼ���`synchronized(����.class)`
 
#### lock
- ��java5��ʼ�ṩ��ǿ����߳�ͬ�����ơ���ʹ����ʾ����ͬ������ʵ��
- java.util.concurrent.locks.Lock �ӿ��ǿ��ƶ���̶߳Թ�����Դ���з��ʵĹ���
- �ýӿڵ���Ҫʵ������`ReentrantLock`�࣬����ӵ����`synchronized`��ͬ�Ĳ����ԣ����Ժ���̰߳�ȫ�����У�����ʹ��`ReentrantLock`����ʾ�������ͷ���

PS�� ʹ��Lock����ʽʱ��java����������Ѹ��ٵ�ʱ���������̣߳��������ܸ��á�

 

 ### �̳߳�
 - java5 ��ʼ�ṩ���̳߳ص������ͽӿ�: 
    - `java.util.concurrent.Executors`��
    - `java.util.concurrent.ExecutorService` �ӿ�


 
# ������


## �߲�ģ��
- OSI(open system interconnect) ,����ʽϵͳ����
- OSI�߲�ģ�� Ӧ�ò� -> ��ʾ�� -> �Ự�� -> ����� -> ����� -> ������·�� -> �����


## ����TCPЭ��
- java.net.ServerSocket ��
���������������׽�����Ϣ
- java.net.Socket ��
���������ͻ����׽�����Ϣ


## ����UDPЭ��
- java.net.DatagramSocket ��
�����������ͺͽ������ݱ����׽���
- java.net.DatagramPacket ��
�����������ݱ���Ϣ

## URL��
- java.net.URL ����Ҫ��ʾͳһ����Դ��λ��