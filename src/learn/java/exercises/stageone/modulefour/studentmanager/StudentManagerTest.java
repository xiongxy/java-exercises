package learn.java.exercises.stageone.modulefour.studentmanager;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author xxywindows@hotmail.com
 */
public class StudentManagerTest {

    public static void main(String[] args) throws FileNotFoundException {
        load();
        doShutDownWork();
        Scanner scanner = new Scanner(System.in);
        welcome();
        System.out.println("���¼");
        Manager manager = new Manager();
        if (manager.Login(scanner)) {
            while (true) {
                System.out.println("��������������������������������������������������������������������������������");
                System.out.println("�밴����ʾ�������ֲ�ѯ������Ҫ�Ĺ���:");
                System.out.println("1.�鿴����ѧ����Ϣ");
                System.out.println("2.���һ��ѧ����Ϣ");
                System.out.println("3.����ѧ�Ų���ĳ��ѧ������Ϣ");
                System.out.println("4.����ѧ��ɾ��ĳ��ѧ������Ϣ");
                System.out.println("5.����ѧ���޸�ĳ��ѧ������Ϣ");
                System.out.println("6.�˳���");
                System.out.print("��ѡ��");
                String choice = scanner.nextLine();
                switch (choice) {
                    case "1":
                        manager.look();
                        break;
                    case "2":
                        manager.add(scanner);
                        System.out.println("��ӳɹ�");
                        break;
                    case "3":
                        Student student = manager.find(scanner);
                        if (student == null) {
                            System.out.println("û���ҵ�ѧ��:");
                        } else {
                            System.out.println(student.toString());
                        }
                        break;
                    case "4":
                        if (manager.delete(scanner)) {
                            System.out.println("ɾ���ɹ�");
                        } else {
                            System.out.println("û���ҵ�ѧ��");
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
            System.out.println("�˳�ϵͳ");
        }
    }

    public static void welcome() {
        System.out.println("ѧ����Ϣ����ϵͳ");
        System.out.println("****��ӭ��****");
    }

    /**
     * ����
     */
    private static void load() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("student.stu"));
            Object object = objectInputStream.readObject();
            Manager.setStudents((ArrayList<Student>) object);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * ���Ĺرշ���
     */
    private static void doShutDownWork() {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                try {
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("student.stu"));
                    objectOutputStream.writeObject(Manager.getStudents());
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
