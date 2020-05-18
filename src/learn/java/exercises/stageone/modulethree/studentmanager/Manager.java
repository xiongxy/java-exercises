package learn.java.exercises.stageone.modulethree.studentmanager;


import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author xxywindows@hotmail.com
 */
public class Manager {

    final String USERNAME = "root";
    final String PASSWORD = "123456";
    private ArrayList<Student> students = new ArrayList<>();

    public Manager() {

    }

    public boolean Login(Scanner scanner) {
        for (int i = 3; i > 0; i--) {
            System.out.println("请输入管理员用户名:");
            String userName = scanner.nextLine();
            System.out.println("请输入管理员登陆密码:");
            String password = scanner.nextLine();
            if (USERNAME.equals(userName) && PASSWORD.equals(password)) {
                System.out.println("用户名和密码格式输入正确，登陆成功");
                return true;
            } else {
                if (i == 1) {
                    System.out.println("用户名和密码连续错误3次，系统自动退出");
                    System.exit(0);
                } else {
                    System.out.println("输入错误，请从新输入，你还有" + (i - 1) + "次机会");
                }
            }
        }
        return false;
    }

    public void add(Scanner scanner) {
        while (true) {
            System.out.println("请输入学号:");
            String number = scanner.nextLine();
            boolean bool = students.stream().anyMatch(x -> x.getNumber().equals(number));
            if (bool) {
                System.out.println("学号已经存在！");
                continue;
            }
            System.out.println("请输入学生姓名:");
            String name = scanner.nextLine();

            System.out.println("请输入学生年龄:");
            int age = Integer.parseInt(scanner.nextLine());

            Student student = new Student(number, name, age);
            students.add(student);
            return;
        }
    }

    public void look() {
        if (students.size() == 0) {
            System.out.println("当前没有学生！");
            return;
        }
        System.out.println("查询所有学生信息如下:");
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            System.out.println(student.toString());
        }
    }

    public Student find(Scanner scanner) {
        System.out.println("请输入学生学号查找学生信息:");
        String number = scanner.nextLine();
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            if (student.getNumber().equals(number)) {
                return student;
            }
        }
        return null;
    }

    public boolean delete(Scanner scanner) {
        System.out.println("请输入学生学号删除学生信息:");
        String number = scanner.nextLine();
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            if (student.getNumber().equals(number)) {
                students.remove(student);
                return true;
            }
        }
        return false;
    }

    public void edit(Scanner scanner) {
        System.out.println("请输入需要修改信息的这位学生的学号:");
        String number = scanner.nextLine();
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            if (student.getNumber().equals(number)) {
                while (true) {
                    System.out.println("请输入修改后姓名");
                    String name = scanner.nextLine();
                    System.out.println("请输入修改后年龄");
                    int age = Integer.parseInt(scanner.nextLine());
                    student = students.remove(i);
                    student.setName(name);
                    student.setAge(age);
                    students.add(student);
                    System.out.println("修改成功！");
                    return;
                }
            } else {
                System.out.println("没有找到学生");
            }
        }
    }

}
