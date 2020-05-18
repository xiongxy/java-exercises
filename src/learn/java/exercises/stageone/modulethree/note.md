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
ʵ��ȫ�򻯵�Data
```
Calendar instance = Calendar.getInstance();
```


# ����

## ���ϵĶ����ܽṹ `java.util.Collection` �� `java.util.Map`

### Collection ����
`java.util.Collection` �ӿ���`List`�ӿڣ�`Queue`�ӿ��Լ�`Set`�ӿڵĸ��ӿڡ�

### Iterator �ӿ�
- `java.util.Iterator` �ӿ���Ҫ�����������������󣬿��Ա���Collection�����е�����Ԫ��
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
- `java.util.List`������Collection���ϵ��Ӽ��ϣ��ü������������ظ���Ԫ�أ��������Ⱥ����˳��
- `java.util.List`��ʵ���࣬��`ArrayList`��`LinkedList`��`Stack`��`Vector`
- `ArrayList`�ײ���ö�̬����������ݹ�����������  
�ײ㣺ԭʼ����*1.5
- `LinkedList`�ײ����˫������������ݹ��� 
- `Stack` �ײ���ö�̬����������ݹ���ʹ��ջ(����ȳ�)����ṹ����������
- `Vector` �ײ���ö�̬����������ݹ���������`ArrayList`������̰߳�ȫ���� �ײ�������2��


### Queue����
- `java.util.Queue`������Collection���ϵ��Ӽ���,��List����ƽ����ϵ
- �ü�����������Ϊ�Ƚ��ȳ����������ݽṹ����Ϊ`����`
- �ü�����Ҫ��ʵ����Ϊ`LinkedList`��


# ����
�Ƿ���Collectionʹ��Ojbect�洢���ݣ��������Դ洢���ֲ�һ�����������ͣ�ȡ������ʱҲ��Object���ͣ������Ҫ��ʵ�������ͣ�����Ҫǿ��ת�������׳���  
������`java5`�Ƴ��˷��ͻ��ƣ��ڱ����ڼ�ǿ��Ҫ����������һ�£�����ʱ�������������͡�