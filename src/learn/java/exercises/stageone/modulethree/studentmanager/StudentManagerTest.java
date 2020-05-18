package learn.java.exercises.stageone.modulethree.studentmanager;


import java.util.Scanner;

/**
 * @author xxywindows@hotmail.com
 */
public class StudentManagerTest {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        welcome();
        System.out.println("请登录");
        Manager manager = new Manager();
        if (manager.Login(scanner)) {
            while (true) {
                System.out.println("————————————————————————————————————————");
                System.out.println("请按照提示输入数字查询你所需要的功能:");
                System.out.println("1.查看所有学生信息");
                System.out.println("2.添加一个学生信息");
                System.out.println("3.根据学号查找某个学生的信息");
                System.out.println("4.根据学号删除某个学生的信息");
                System.out.println("5.根据学号修改某个学生的信息");
                System.out.println("6.退出。");
                System.out.print("请选择：");
                String choice = scanner.nextLine();
                switch (choice) {
                    case "1":
                        manager.look();
                        break;
                    case "2":
                        manager.add(scanner);
                        System.out.println("添加成功");
                        break;
                    case "3":
                        Student student = manager.find(scanner);
                        if (student == null) {
                            System.out.println("没有找到学生:");
                        } else {
                            System.out.println(student.toString());
                        }
                        break;
                    case "4":
                        if (manager.delete(scanner)) {
                            System.out.println("删除成功");
                        } else {
                            System.out.println("没有找到学生");
                        }
                        break;
                    case "5":
                        manager.edit(scanner);
                        break;
                    case "6":
                        System.exit(0);
                        break;
                    default:
                        break;
                }
            }
        } else {
            System.out.println("退出系统");
        }
    }

    public static void welcome() {
        System.out.println("学生信息管理系统");
        System.out.println("****欢迎您****");
    }
}
