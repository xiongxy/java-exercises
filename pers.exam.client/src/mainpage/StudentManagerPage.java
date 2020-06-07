package mainpage;

import business.StudentService;
import student.StudentDTO;
import user.UserAccountDTO;
import util.ClientScanner;

import java.util.List;

/**
 * @author xxyWi
 * 学生管理主页面
 */
public class StudentManagerPage {
    String inputText;
    UserAccountDTO userAccountDTO = new UserAccountDTO();

    public int start() {
        return mainPage();
    }

    private int mainPage() {
        System.out.println("欢迎进入学员管理系统,输入序号进行相应的操作！");
        System.out.println("[1] 查看所有学生");
        System.out.println("[2] 增加学生");
        System.out.println("[3] 修改学生");
        System.out.println("[4] 删除学生");
        System.out.print("请输入:");
        inputText = ClientScanner.getNextLine();
        switch (inputText) {
            case "1":
                List<StudentDTO> studentList = StudentService.getStudentList();
                if (studentList.size() != 0) {
                    System.out.println(studentList.toString());
                } else {
                    System.out.println("暂时没有学生");
                }
                return 1;
            case "2":
                addStudentPage();
                return 1;
            case "3":
                editStudentPage();
                return 1;
            case "4":
                deleteStudentPage();
                return 1;
            default:
                return 0;
        }
    }

    private void deleteStudentPage() {
        System.out.println("请输入需要删除的这位学生的学号:");
        inputText = ClientScanner.getNextLine();
        if (StudentService.deleteStudent(inputText)) {
            return;
        } else {
            System.out.println("修改失败！");
        }
    }

    private void editStudentPage() {
        System.out.println("请输入需要修改信息的这位学生的学号:");
        inputText = ClientScanner.getNextLine();
        List<StudentDTO> studentList = StudentService.getStudentList();
        for (StudentDTO student : studentList) {
            if (student.getNumber().equals(inputText)) {
                while (true) {
                    System.out.println("请输入修改后密码");
                    inputText = ClientScanner.getNextLine();
                    student.setPassword(inputText);

                    System.out.println("请输入修改后姓名");
                    inputText = ClientScanner.getNextLine();
                    student.setName(inputText);

                    System.out.println("请输入修改后年龄");
                    int age = Integer.parseInt(ClientScanner.getNextLine());
                    student.setAge(age);

                    if (StudentService.updateStudent(student)) {
                        return;
                    } else {
                        System.out.println("修改失败！");
                    }
                }
            } else {
                System.out.println("没有找到学生");
            }
        }
    }

    private void addStudentPage() {
        StudentDTO studentDTO = new StudentDTO();
        System.out.println("请输入学号:");
        inputText = ClientScanner.getNextLine();
        studentDTO.setNumber(inputText);

        System.out.println("请输入密码:");
        inputText = ClientScanner.getNextLine();
        studentDTO.setPassword(inputText);

        System.out.println("请输入学生姓名:");
        inputText = ClientScanner.getNextLine();
        studentDTO.setName(inputText);

        System.out.println("请输入学生年龄:");
        inputText = ClientScanner.getNextLine();
        studentDTO.setAge(inputText);

        StudentService.addStudent(studentDTO);
    }
}
