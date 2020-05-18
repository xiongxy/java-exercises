package learn.java.exercises.stageone.modulethree.studentmanager;


/**
 * @author xxywindows@hotmail.com
 */
public class Student {
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
        this.age = age;
    }

    public Student(String number, String name, int age) {
        setNumber(number);
        setName(name);
        setAge(age);
    }
}
