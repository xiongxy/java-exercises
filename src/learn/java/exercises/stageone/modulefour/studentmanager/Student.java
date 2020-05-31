package learn.java.exercises.stageone.modulefour.studentmanager;


import java.io.Serializable;

/**
 * @author xxywindows@hotmail.com
 */
public class Student implements Serializable {
    static final long serialVersionUID = -3387516993124229948L;

    private static final int MIN_AGE = 18;
    private static final int MAX_AGE = 50;
    private static final int NUMBER_LENGTH = 18;


    private String number;
    private String name;
    private int age;

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "学生信息 ：Student{" +
                "number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void setNumber(String number) {
        if (number.length() != NUMBER_LENGTH) {
            try {
                throw new StudentNumberException("学号位数不匹配");
            } catch (StudentNumberException e) {
                e.printStackTrace();
            }
        }
        this.number = number;
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
        if (age < MIN_AGE || age > MAX_AGE) {
            try {
                throw new AgeException("年龄不合法");
            } catch (AgeException e) {
                e.printStackTrace();
            }
        }

        this.age = age;
    }

    public Student(String number, String name, int age) {
        setNumber(number);
        setName(name);
        setAge(age);
    }
}
