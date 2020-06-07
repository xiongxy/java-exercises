package student;

import java.io.Serializable;

/**
 * @author xxyWi
 * 学生传输类
 */
public class StudentDTO implements Serializable {

    private static final int MIN_AGE = 18;
    private static final int MAX_AGE = 50;
    private static final int NUMBER_LENGTH = 18;

    private String number;
    private String name;


    private String password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAge(String age) {
        boolean result = age.matches("[0-9]+");
        if (result) {
            this.age = Integer.parseInt(age);
        } else {
            this.age = 18;
        }
    }

    public StudentDTO() {
    }

    public StudentDTO(String number, String name, int age) {
        setNumber(number);
        setName(name);
        setAge(age);
    }
}
