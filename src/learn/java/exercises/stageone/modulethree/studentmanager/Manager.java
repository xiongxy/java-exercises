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
            System.out.println("���������Ա�û���:");
            String userName = scanner.nextLine();
            System.out.println("���������Ա��½����:");
            String password = scanner.nextLine();
            if (USERNAME.equals(userName) && PASSWORD.equals(password)) {
                System.out.println("�û����������ʽ������ȷ����½�ɹ�");
                return true;
            } else {
                if (i == 1) {
                    System.out.println("�û�����������������3�Σ�ϵͳ�Զ��˳�");
                    System.exit(0);
                } else {
                    System.out.println("���������������룬�㻹��" + (i - 1) + "�λ���");
                }
            }
        }
        return false;
    }

    public void add(Scanner scanner) {
        while (true) {
            System.out.println("������ѧ��:");
            String number = scanner.nextLine();
            boolean bool = students.stream().anyMatch(x -> x.getNumber().equals(number));
            if (bool) {
                System.out.println("ѧ���Ѿ����ڣ�");
                continue;
            }
            System.out.println("������ѧ������:");
            String name = scanner.nextLine();

            System.out.println("������ѧ������:");
            int age = Integer.parseInt(scanner.nextLine());

            Student student = new Student(number, name, age);
            students.add(student);
            return;
        }
    }

    public void look() {
        if (students.size() == 0) {
            System.out.println("��ǰû��ѧ����");
            return;
        }
        System.out.println("��ѯ����ѧ����Ϣ����:");
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            System.out.println(student.toString());
        }
    }

    public Student find(Scanner scanner) {
        System.out.println("������ѧ��ѧ�Ų���ѧ����Ϣ:");
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
        System.out.println("������ѧ��ѧ��ɾ��ѧ����Ϣ:");
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
        System.out.println("��������Ҫ�޸���Ϣ����λѧ����ѧ��:");
        String number = scanner.nextLine();
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            if (student.getNumber().equals(number)) {
                while (true) {
                    System.out.println("�������޸ĺ�����");
                    String name = scanner.nextLine();
                    System.out.println("�������޸ĺ�����");
                    int age = Integer.parseInt(scanner.nextLine());
                    student = students.remove(i);
                    student.setName(name);
                    student.setAge(age);
                    students.add(student);
                    System.out.println("�޸ĳɹ���");
                    return;
                }
            } else {
                System.out.println("û���ҵ�ѧ��");
            }
        }
    }

}
